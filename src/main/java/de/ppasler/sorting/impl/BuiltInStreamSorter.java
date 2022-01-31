package de.ppasler.sorting.impl;

import static java.util.stream.Collectors.toList;

import java.util.List;

import de.ppasler.sorting.Sorter;

public class BuiltInStreamSorter<T extends Comparable<T>> implements Sorter<T> {

	@Override
	public List<T> sort(final List<T> list) {
		return list.stream()
				.sorted()
				.collect(toList());
	}
}
