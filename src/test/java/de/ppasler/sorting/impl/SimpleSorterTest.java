package de.ppasler.sorting.impl;

import static de.ppasler.sorting.DataProvider.SIMPLE_STRING;
import static de.ppasler.sorting.DataProvider.SIMPLE_STRING_SORTED;
import static de.ppasler.sorting.DataProvider.getLists;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import de.ppasler.sorting.Sorter;

class SimpleSorterTest {

	final Sorter<Integer> sorter = new SimpleSorter<>();

	public static Stream<Arguments> lists() {
		return getLists();
	}

	@ParameterizedTest(name = "#{index}: sort({0}) == {1}")
	@MethodSource("lists")
	void sort(final List<Integer> list, final List<Integer> expected) {
		final List<Integer> sortedList = sorter.sort(list);

		assertEquals(expected, sortedList);
	}

	@Test
	void sort_sortsStrings() {
		final Sorter<String> stringSorter = new SimpleSorter<>();

		final List<String> sortedList = stringSorter.sort(SIMPLE_STRING);

		assertEquals(SIMPLE_STRING_SORTED, sortedList);
	}

	@Test
	void sort_originalListUnchanged() {
		final List<Integer> list = asList(3, 5, 1);

		sorter.sort(list);

		assertEquals(asList(3, 5, 1), list);
	}
}
