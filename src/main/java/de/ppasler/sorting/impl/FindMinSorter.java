package de.ppasler.sorting.impl;

import java.util.ArrayList;
import java.util.List;

import de.ppasler.sorting.Sorter;

public class FindMinSorter implements Sorter {

	@Override
	public List<Integer> sort(final List<Integer> list) {
		final ArrayList<Integer> copiedList = new ArrayList<>(list); // handle multiple equal values
		final ArrayList<Integer> sortedList = new ArrayList<>(list.size());

		Integer sortedMax = Integer.MIN_VALUE;
		for (int i = 0; i < list.size(); i++) {
			int minIndex = findMinIndex(copiedList, sortedMax);
			Integer minValue = copiedList.get(minIndex);

			sortedMax = minValue;
			sortedList.add(minValue);
			copiedList.remove(minIndex);
		}

		return sortedList;
	}

	protected int findMinIndex(final List<Integer> list, final Integer sortedMax) {
		int minIndex = 0;
		Integer curMinValue = Integer.MAX_VALUE;

		for (int j = 0; j < list.size(); j++) {
			final Integer item = list.get(j);
			if (curMinValue > item && item >= sortedMax) {
				curMinValue = item;
				minIndex = j;
			}
		}
		return minIndex;
	}
}
