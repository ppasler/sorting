package de.ppasler.sorting.impl;

import static de.ppasler.sorting.util.GenericsComparer.lt;
import static java.util.Collections.swap;

import java.util.ArrayList;
import java.util.List;

import de.ppasler.sorting.Sorter;

public class SelectionSorter<T extends Comparable<T>> implements Sorter<T> {

	@Override
	public List<T> sort(final List<T> list) {
		final List<T> copiedList = new ArrayList<>(list);

		for (int i = 0; i < copiedList.size() - 1; i++) {
			int minIndex = findMinIndex(copiedList, i);
			swap(copiedList, i, minIndex);
		}

		return copiedList;
	}

	private int findMinIndex(final List<T> list, final int start) {
		int curMinIndex = start;
		T curMinValue = list.get(start);

		for (int j = start + 1; j < list.size(); j++) {
			final T curValue = list.get(j);
			if (lt(curValue, curMinValue)) {
				curMinValue = curValue;
				curMinIndex = j;
			}
		}
		return curMinIndex;
	}
}
