package com.chandra.ds.java.implementations;

import java.util.Iterator;
import java.util.Set;

public abstract class AbstractMap<K, V> implements Map<K, V> {

	protected AbstractMap() {}

	public void clear() {
		entrySet().clear();
	}
	
	public boolean containsKey(Object key) {
		Iterator<Map.Entry<K, V>> it = entrySet().iterator();
		if (key != null) {
			while (it.hasNext()) {
				if (key.equals(it.next().getKey()))
					return true;
			}
		} else {
			while (it.hasNext()) {
				if (it.next().getKey() == null)
					return true;
			}
		}
		return false;
	}
	
	public boolean containsValue(Object value) {
		Iterator<Map.Entry<K, V>> it = entrySet().iterator();
		if (value != null) {
			while (it.hasNext()) {
				if (value.equals(it.next().getValue()))
					return true;
			}
		} else {
			while (it.hasNext()) {
				if (it.next().getValue() == null)
					return true;
			}
		}
		return false;
	}
	
	public abstract Set<Map.Entry<K, V>> entrySet();
	
	public V get(Object key) {
		Iterator<Map.Entry<K, V>> it = entrySet().iterator();
		if (key != null) {
			while (it.hasNext()) {
				Map.Entry<K, V> entry = it.next();
				if (key.equals(entry.getKey()))
					return entry.getValue();
			}
		} else {
			while (it.hasNext()) {
				Map.Entry<K, V> entry = it.next();
				if (entry.getKey() == null) 
					return entry.getValue();
			}
		}
		return null;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	private class KeyIterator implements Iterator<K> {

		Iterator<Map.Entry<K, V>> iterator = entrySet().iterator();
		
		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		@Override
		public K next() {
			return iterator.next().getKey();
		}
		
		@Override
		public void remove() {
			iterator.remove();
		}
	}
	
	private class KeyIterable implements Iterable<K> {

		@Override
		public Iterator<K> iterator() {
			return new KeyIterator();
		}
		
	}
	public Iterable<K> keySet() {
		return new KeyIterable();
	}
	
	public abstract V put(K key, V value);
	
	public V remove(Object key) {
		Iterator<Map.Entry<K, V>> iterator = entrySet().iterator();
		if (key != null) {
			while (iterator.hasNext()) {
				Map.Entry<K, V> entry = iterator.next();
				if (key.equals(entry.getKey())) {
					iterator.remove();
					return entry.getValue();
				}
			}
		} else {
			while (iterator.hasNext()) {
				Map.Entry<K, V> entry = iterator.next();
				if (entry.getKey() == null) {
					iterator.remove();
					return entry.getValue();
				}
			}
		}
		
		return null;
	}
	
	public int size() {
		return entrySet().size();
	}
}
