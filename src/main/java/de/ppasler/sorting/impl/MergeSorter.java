package de.ppasler.sorting.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import de.ppasler.sorting.AbstractSorter;

public class MergeSorter<T extends Comparable<T>> extends AbstractSorter<T> {

	@Override
	public List<T> sort(final List<T> list) {
		final List<T> copiedList = new LinkedList<>(list);

		return mergeSort(copiedList);
	}

	private List<T> mergeSort(final List<T> list) {
		final int size = list.size();
		if (size <= 1) {
			return list;
		}

		final int middle = size / 2;
		final List<T> left = mergeSort(newSublist(list, 0, middle));
		final List<T> right = mergeSort(newSublist(list, middle, list.size()));

		return merge(left, right);
	}

	private List<T> merge(final List<T> left, final List<T> right) {
		final List<T> mergedList = new ArrayList<>();
		while (!left.isEmpty() && !right.isEmpty()) {
			if (lte(left.get(0), right.get(0))) {
				mergedList.add(left.remove(0));
			} else {
				mergedList.add(right.remove(0));
			}
		}
		mergedList.addAll(left);
		mergedList.addAll(right);

		return mergedList;
	}

	private List<T> newSublist(final List<T> list, final int fromIndex, final int toIndex) {
		return new LinkedList<>(list.subList(fromIndex, toIndex));
	}
}
