package de.ppasler.sorting.impl;

import static de.ppasler.sorting.util.GenericsComparer.lt;
import static java.util.Collections.swap;

import java.util.List;

import de.ppasler.sorting.Sorter;

/**
 * @see <a href="https://de.wikipedia.org/wiki/Selectionsort">Selectionsort</a>
 */
public class SelectionSorter<T extends Comparable<T>> implements Sorter<T> {

	@Override
	public void sort(final List<T> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			int minIndex = findMinIndex(list, i);
			swap(list, i, minIndex);
		}
	}

	@Override
	public boolean isStable() {
		return false;
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
