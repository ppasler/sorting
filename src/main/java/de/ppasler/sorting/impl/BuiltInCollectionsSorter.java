package de.ppasler.sorting.impl;

import java.util.Collections;
import java.util.List;

import de.ppasler.sorting.Sorter;

public class BuiltInCollectionsSorter<T extends Comparable<T>> implements Sorter<T> {

	@Override
	public List<T> sort(final List<T> list) {
		Collections.sort(list);
		return list;
	}
}
