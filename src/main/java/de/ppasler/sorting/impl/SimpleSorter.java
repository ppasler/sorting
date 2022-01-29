package de.ppasler.sorting.impl;

import java.util.ArrayList;
import java.util.List;

import de.ppasler.sorting.Sorter;

public class SimpleSorter implements Sorter {

	@Override
	public List<Integer> sort(final List<Integer> list) {
		final ArrayList<Integer> sortedList = new ArrayList<>(list.size());

		for (Integer item : list) {
			int curIndex = sortedList.size();
			for (int j = 0; j < sortedList.size(); j++) {
				Integer curMax = sortedList.get(j);
				if (item <= curMax) {
					curIndex = j;
					break;
				}
			}
			sortedList.add(curIndex, item);
		}

		return sortedList;
	}
}
