package de.ppasler.sorting.impl;

import static de.ppasler.sorting.DataProvider.getLists;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import de.ppasler.sorting.Sorter;

class FindMinSorterTest {

	final Sorter sorter = new FindMinSorter();

	public static Stream<Arguments> lists() {
		return getLists();
	}

	@ParameterizedTest(name = "#{index}: sorted({0}) == {1}")
	@MethodSource("lists")
	void sort(final List<Integer> list, final List<Integer> expected) {
		final List<Integer> sortedList = sorter.sort(list);

		assertEquals(expected, sortedList);
	}
}
