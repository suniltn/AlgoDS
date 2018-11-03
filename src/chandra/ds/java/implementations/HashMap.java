package com.chandra.ds.java.implementations;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;


public class HashMap<K, V> extends AbstractMap<K, V> {

	private static final int MINIMUM_CAPACITY = 16;
	
	/**
     * Max capacity for a HashMap. Must be a power of two >= MINIMUM_CAPACITY.
     */
	private static final int MAXIMUM_CAPACITY = 1 << 30;
	
	HashMapEntry<K, V>[] table;
	
	int size;
	int threshold;
	
	public HashMap(int initialCapacity) {
		if (initialCapacity < 0) 
			throw new IllegalArgumentException("Capacity : " + initialCapacity);
		
		if (initialCapacity < MINIMUM_CAPACITY)
			initialCapacity = MINIMUM_CAPACITY;
		else if (initialCapacity > MAXIMUM_CAPACITY)
			initialCapacity = MAXIMUM_CAPACITY;
		
		makeTable(initialCapacity);
	}
	
	public HashMap(int initialCapacity, int loadFactor) {
		this(initialCapacity);
		
		if (loadFactor <= 0 | Float.isNaN(loadFactor))
			throw new IllegalArgumentException("Illegal load factor: " +
					                                              loadFactor);
		
		/**
		 * Current implementation always ignores loadFactor; it always uses
		 * a load factor of 3/4.
		 */
	}
	
	public HashMap() {
		this(MINIMUM_CAPACITY);
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	public V get(Object key) {
		int hash = key.hashCode();
		HashMapEntry<K, V>[] tab = table;
		for (HashMapEntry<K, V> e = tab[indexFor(hash, tab.length)]; e != null; e = e.next) {
			K eKey = e.key;
			if (eKey == key || (e.hash == hash && key.equals(eKey))) {
				return e.value;
			}
		}
		return null;
	}
	
	@Override
	public boolean containsKey(Object key) {
		int hash = key.hashCode();
		HashMapEntry<K, V>[] tab = table;
		for (HashMapEntry<K, V> e = tab[indexFor(hash, tab.length)]; e != null; e = e.next) {
			K eKey = e.key;
			if (eKey == key || (e.hash == hash && key.equals(eKey)))
				return true;
		}
		return false;
	}
	
	@Override
	public boolean containsValue(Object value) {
		HashMapEntry<K, V>[] tab = table;
		int len = tab.length;
		for (int i=0;i<len;i++) {
			for (HashMapEntry<K, V> e = tab[i]; e != null; e = e.next) {
				if (value.equals(e.value))
					return true;
			}
		}
		return false;
	}
	
	@Override
	public V put(K key, V value) {
		if (key == null || value == null)
			throw new IllegalStateException("Key or Value cannot be null");
		HashMapEntry<K, V>[] tab = table;
		int hash = key.hashCode();
		int index = indexFor(hash, tab.length);
		for (HashMapEntry<K, V> e = tab[index]; e != null; e = e.next) {
			K eKey = e.key;
			if (eKey == key || (e.hash == hash && key.equals(eKey)))
				return e.setValue(value);
		}
		
		if (size++ > threshold) {
			tab = doubleCapacity();
			// Computes index for new table
			index = indexFor(hash, tab.length);
		}
		addNewEntry(key, value, hash, index);
		return null;
	}
	
	void addNewEntry(K key, V value, int hash, int index) {
		table[index] = new HashMapEntry<K, V>(key, value, hash, table[index]);
	}
	
	@Override
	public V remove(Object key) {
		if (key == null)
			throw new IllegalArgumentException("Key cannot be null");
		int hash = key.hashCode();
		HashMapEntry<K, V>[] tab = table;
		int index = indexFor(hash, tab.length);
		for (HashMapEntry<K, V> e = tab[index], prev = null; e != null; prev=e, e = e.next) {
			if (e.hash == hash && key.equals(e.key)) {
				if (prev == null) {
					tab[index] = e.next;
				} else {
					prev.next = e.next;
				}
				size--;
				return e.value;
			}
		}
		return null;
	}
	
	@Override
	public void clear() {
		if (size != 0) {
			Arrays.fill(table, null);
			size = 0;
		}
	}
	
	private HashMapEntry<K, V>[] doubleCapacity() {
		HashMapEntry<K, V>[] oldTable = table;
		int oldCapacity = oldTable.length;
		if (oldCapacity == MAXIMUM_CAPACITY)
			return oldTable;
		
		int newCapacity = oldCapacity * 2;
		HashMapEntry<K, V>[] newTable = makeTable(newCapacity);
		if (size == 0)
			return newTable;
		for (int j=0;j<oldCapacity;j++) {
			HashMapEntry<K, V> e = oldTable[j];
			if (e != null) {
				oldTable[j] = null;
				/**
				 *  Before copying to new table, computes a new index for new table using 
				 *  hash stored in old table and new table capacity.
				 *  Copies entries to new table in reverse order
				 */
				
				do {
					HashMapEntry<K, V> next = e.next;
					int index = indexFor(e.hash, newCapacity);
					e.next = newTable[index];
					newTable[index] = e;
					e = next;
				} while (e != null);
			}
		}
		table = newTable;
		return newTable;
	}
	
	static int indexFor(int h, int length) {
		return h & (length - 1);
	}
	
	private HashMapEntry<K, V>[] makeTable(int newCapacity) {
		// Find a power of 2 >= initialCapacity
		int capacity = 1;
		while (capacity < newCapacity)
				capacity <<= 1;
		HashMapEntry<K, V>[] newTable = (HashMapEntry<K, V>[]) new HashMapEntry[capacity];
		table = newTable;
		threshold = (capacity >> 1) + (capacity >> 2);	// 3/4 capacity
		return newTable;
	}
	
	static class HashMapEntry<K, V> implements Entry<K, V> {
		final K key;
		V value;
		final int hash;
		HashMapEntry<K, V> next;
		
		public HashMapEntry(K key, V value, int hash, HashMapEntry<K, V> next) {
			this.key = key;
			this.value = value;
			this.hash = hash;
			this.next = next;
		}
		
		public final K getKey() {
			return key;
		}
		
		public final V getValue() {
			return value;
		}
		
		public V setValue(V value) {
			V oldValue = this.value;
			this.value = value;
			return oldValue;
		}
		
		@Override
		public final boolean equals(Object o) {
			if (!(o instanceof Entry))
					return false;
			Entry<?, ?> entry = (Entry<?, ?>) o;
			return Objects.equals(entry.getKey(), key)
					&& Objects.equals(entry.getValue(), value);
		}
		
		@Override
		public final int hashCode() {
			return (key == null ? 0 : key.hashCode()) ^
					(value == null ? 0 : value.hashCode());
		}
	}

	@Override
	public Iterable<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
}
