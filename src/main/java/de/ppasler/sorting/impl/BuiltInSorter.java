package de.ppasler.sorting.impl;

import static java.util.stream.Collectors.toList;

import java.util.List;

import de.ppasler.sorting.AbstractSorter;

public class BuiltInSorter<T extends Comparable<T>> extends AbstractSorter<T> {

	@Override
	public List<T> sort(final List<T> list) {
		return list.stream()
				.sorted()
				.collect(toList());
	}
}
