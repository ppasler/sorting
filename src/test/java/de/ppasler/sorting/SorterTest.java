package de.ppasler.sorting;

import static de.ppasler.sorting.DataProvider.FRUITS_SORTED;
import static de.ppasler.sorting.DataProvider.SIMPLE_STRING_SORTED;
import static de.ppasler.sorting.DataProvider.getFruits;
import static de.ppasler.sorting.DataProvider.getLists;
import static de.ppasler.sorting.DataProvider.getStrings;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToObject;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import de.ppasler.sorting.obj.Fruit;

@Disabled
public class SorterTest {

	final Sorter<Integer> sorter;
	final Class<? extends Sorter> clazz;

	public SorterTest(final Class<? extends Sorter> clazz) throws Exception {
		this.clazz = clazz;
		sorter = newInstance();
	}

	private Sorter newInstance() throws Exception {
		return clazz.newInstance();
	}

	public static Stream<Arguments> lists() {
		return getLists();
	}

	@ParameterizedTest(name = "#{index}: sort({0}) == {1}")
	@MethodSource("lists")
	void sort(final List<Integer> list, final List<Integer> expected) {
		sorter.sort(list);

		assertThat(list, is(expected));
	}

	@Test
	void sort_sortsStrings() throws Exception {
		final Sorter<String> stringSorter = newInstance();
		final List<String> strings = getStrings();

		stringSorter.sort(strings);

		assertThat(strings, is(SIMPLE_STRING_SORTED));
	}

	@Test
	void sort_isStable() throws Exception {
		final Sorter<Fruit> fruitSorter = newInstance();
		final List<Fruit> fruits = getFruits();

		fruitSorter.sort(fruits);

		assertThat(fruits.equals(FRUITS_SORTED), is(fruitSorter.isStable()));
	}
}
