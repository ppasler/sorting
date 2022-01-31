package de.ppasler.sorting.impl;

import java.util.ArrayList;
import java.util.List;

import de.ppasler.sorting.AbstractSorter;

public class SimpleSorter<T extends Comparable<T>> extends AbstractSorter<T> {

	@Override
	public List<T> sort(final List<T> list) {
		final List<T> sortedList = new ArrayList<>(list.size());

		for (T item : list) {
			int curIndex = sortedList.size();
			for (int j = 0; j < sortedList.size(); j++) {
				T curMax = sortedList.get(j);
				if (lte(item, curMax)) {
					curIndex = j;
					break;
				}
			}
			sortedList.add(curIndex, item);
		}

		return sortedList;
	}
}
