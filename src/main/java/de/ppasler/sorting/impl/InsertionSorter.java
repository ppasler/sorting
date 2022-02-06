package de.ppasler.sorting.impl;

import static de.ppasler.sorting.util.GenericsComparer.gt;

import java.util.List;

import de.ppasler.sorting.Sorter;

public class InsertionSorter<T extends Comparable<T>> implements Sorter<T> {

	@Override
	public List<T> sort(final List<T> list) {
		for (int i = 1; i < list.size(); i++) {
			final T value = list.remove(i);
			int position = getPosition(list, value, i);
			list.add(position, value);
		}
		return list;
	}

	private int getPosition(final List<T> list, final T value, int j) {
		while (j > 0 && gt(list.get(j - 1), value)) {
			j--;
		}
		return j;
	}
}
