package com.chandra.ds.java.implementations;

import java.util.Collection;
import java.util.Set;

public interface Map<K, V> {

	public static interface Entry<K,V> {
		public K getKey();
		public V getValue();
		public V setValue(V object);
	};
	
	public void clear();
	public boolean containsKey(Object key);
	public boolean containsValue(Object value);
	public Iterable<Map.Entry<K,V>> entrySet();
	public V get(Object key);
	public boolean isEmpty();
	public Iterable<K> keySet();
	public V put(K key, V value);
	public V remove(Object key);
	public int size();
	public Iterable<V> values();
}
