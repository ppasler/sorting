package de.ppasler.sorting.impl;

import java.util.List;

import de.ppasler.sorting.Sorter;

/**
 * @see <a href="https://de.wikipedia.org/wiki/Bubblesort">BubbleSort</a>
 */
public class BuiltInCollectionsSorter<T extends Comparable<T>> implements Sorter<T> {

	@Override
	public void sort(final List<T> list) {
		list.sort(null);
	}

	@Override
	public boolean isStable() {
		return true;
	}
}
