package de.ppasler.sorting.impl;

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
	void sort_originalListUnchanged() {
		List<Integer> list = asList(3, 5, 1);

		sorter.sort(list);

		assertEquals(asList(3, 5, 1), list);
	}

	@Test
	@Disabled
	void sort_isStable() {
		final Integer first = new Integer(2);
		final Integer second = new Integer(2);
		final Integer third = new Integer(2);
		List<Integer> list = asList(first, 3, second, 1, third);

		List<Integer> sortedList = sorter.sort(list);

		assertSame(sortedList.get(1), first);
		assertSame(sortedList.get(2), second);
		assertSame(sortedList.get(3), third);
	}
}
