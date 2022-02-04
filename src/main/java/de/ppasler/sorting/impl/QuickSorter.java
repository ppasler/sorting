package de.ppasler.sorting.impl;

import static de.ppasler.sorting.util.GenericsComparer.gt;
import static de.ppasler.sorting.util.GenericsComparer.gte;
import static de.ppasler.sorting.util.GenericsComparer.lt;
import static java.util.Collections.swap;

import java.util.LinkedList;
import java.util.List;

import de.ppasler.sorting.Sorter;

public class QuickSorter<T extends Comparable<T>> implements Sorter<T> {

	@Override
	public List<T> sort(final List<T> list) {
		final List<T> copiedList = new LinkedList<>(list);

		return quickSort(copiedList, 0, copiedList.size() - 1);
	}

	private List<T> quickSort(final List<T> list, final int left, final int right) {
		if (left < right) {
			final int divider = divide(list, left, right);
			quickSort(list, left, divider -  1);
			quickSort(list, divider + 1, right);
		}
		return list;
	}

	private int divide(final List<T> list, final int left, final int right) {
		int i = left;
		int j = right - 1;
		final T pivot = list.get(right);

		while (i < j) {
			i = getLeftSwapIndex(list, right, i, pivot);
			j = getRightSwapIndex(list, left, j, pivot);

			if (i < j) {
				swap(list, i, j);
			}
		}

		if (gt(list.get(i), pivot)) {
			swap(list, i, right);
		}
		return i;
	}

	private int getRightSwapIndex(final List<T> list, final int left, int j, final T pivot) {
		while (j > left && gte(list.get(j), pivot)) {
			j--;
		}
		return j;
	}

	private int getLeftSwapIndex(final List<T> list, final int right, int i, final T pivot) {
		while (i < right && lt(list.get(i), pivot)) {
			i++;
		}
		return i;
	}
}
