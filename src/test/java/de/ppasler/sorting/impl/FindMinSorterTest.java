package de.ppasler.sorting.impl;

import static de.ppasler.sorting.DataProvider.FRUITS;
import static de.ppasler.sorting.DataProvider.FRUITS_SORTED;
import static de.ppasler.sorting.DataProvider.SIMPLE_STRING;
import static de.ppasler.sorting.DataProvider.SIMPLE_STRING_SORTED;
import static de.ppasler.sorting.DataProvider.getLists;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToObject;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import de.ppasler.sorting.Sorter;
import de.ppasler.sorting.obj.Fruit;

class FindMinSorterTest {

	final Sorter<Integer> sorter = new FindMinSorter<>();

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
		final Sorter<String> stringSorter = new FindMinSorter<>();

		final List<String> sortedList = stringSorter.sort(SIMPLE_STRING);

		assertEquals(SIMPLE_STRING_SORTED, sortedList);
	}

	@Test
	void sort_originalListUnchanged() {
		final List<Integer> list = asList(3, 5, 1);

		sorter.sort(list);

		assertEquals(asList(3, 5, 1), list);
	}

	@Test
	void sort_isStable() {
		final Sorter<Fruit> fruitSorter = new FindMinSorter<>();

		List<Fruit> sortedList = fruitSorter.sort(FRUITS);

		assertThat(sortedList, is(equalToObject(FRUITS_SORTED)));
	}
}
