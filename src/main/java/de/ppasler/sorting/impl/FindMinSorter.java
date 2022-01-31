package de.ppasler.sorting.impl;

import static de.ppasler.sorting.util.GenericsComparer.gt;
import static de.ppasler.sorting.util.GenericsComparer.gte;

import java.util.ArrayList;
import java.util.List;

import de.ppasler.sorting.Sorter;

public class FindMinSorter<T extends Comparable<T>> implements Sorter<T> {

	@Override
	public List<T> sort(final List<T> list) {
		final List<T> copiedList = new ArrayList<>(list);

		T sortedMax = null;
		for (int i = 0; i < list.size(); i++) {
			int minIndex = i + findMinIndex(copiedList.subList(i, copiedList.size()), sortedMax);
			T minValue = copiedList.get(minIndex);

			sortedMax = minValue;
			copiedList.remove(minIndex);
			copiedList.add(i, minValue);
		}

		return copiedList;
	}

	private int findMinIndex(final List<T> list, final T sortedMax) {
		int minIndex = 0;
		T curMinValue = list.get(0);

		for (int j = 1; j < list.size(); j++) {
			final T item = list.get(j);
			if (gt(curMinValue, item) && nullSafeGte(item, sortedMax)) {
				curMinValue = item;
				minIndex = j;
			}
		}
		return minIndex;
	}

	private boolean nullSafeGte(final T x, final T y) {
		if (y == null) { // everything is greater null...
			return true;
		}
		return gte(x, y);
	}
}
