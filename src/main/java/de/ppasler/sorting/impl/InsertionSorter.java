package de.ppasler.sorting.impl;

import static de.ppasler.sorting.util.GenericsComparer.gt;
import static java.util.Collections.swap;

import java.util.ArrayList;
import java.util.List;

import de.ppasler.sorting.Sorter;

public class InsertionSorter<T extends Comparable<T>> implements Sorter<T> {

	@Override
	public List<T> sort(final List<T> list) {
		final List<T> copiedList = new ArrayList<>(list);

		for (int i = 1; i < copiedList.size(); i++) {
			final T value = copiedList.get(i);
			int j = i;
			while (j > 0 && gt(copiedList.get(j - 1), value)) {
				swap(copiedList, j, j - 1);
				j--;
			}
		}

		return copiedList;
	}

	private void move(final List<T> list, final int from, final int to) {
		if (from == to) {
			return;
		}

		final T value = list.remove(from);
		list.add(to, value);
	}
}
