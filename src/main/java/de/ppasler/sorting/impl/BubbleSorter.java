package de.ppasler.sorting.impl;

import static de.ppasler.sorting.util.GenericsComparer.gt;
import static java.util.Collections.swap;

import java.util.List;

import de.ppasler.sorting.Sorter;

public class BubbleSorter<T extends Comparable<T>> implements Sorter<T> {

	@Override
	public void sort(final List<T> list) {
		for (int i = list.size(); i > 1; i--) {
			for (int j = 0; j < i-1; j++) {
				if (gt(list.get(j), list.get(j + 1))) {
					swap(list, j, j + 1);
				}
			}
		}
	}

	@Override
	public boolean isStable() {
		return true;
	}
}
