package de.ppasler.sorting.impl;

import java.util.ArrayList;
import java.util.List;

public class FindMinInPlaceSorter extends FindMinSorter {

	@Override
	public List<Integer> sort(final List<Integer> list) {
		final ArrayList<Integer> copiedList = new ArrayList<>(list);

		Integer sortedMax = Integer.MIN_VALUE;
		for (int i = 0; i < list.size(); i++) {
			int minIndex = i + findMinIndex(copiedList.subList(i, copiedList.size()), sortedMax);
			Integer minValue = copiedList.get(minIndex);

			sortedMax = minValue;
			copiedList.remove(minIndex);
			copiedList.add(i, minValue);
		}

		return copiedList;
	}
}
