package de.ppasler.sorting;

import static de.ppasler.sorting.obj.Fruit.Color;
import static java.util.Arrays.asList;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

import de.ppasler.sorting.obj.Fruit;

public class DataProvider {

	public static final List<Integer> SIMPLE = asList(3, 1, 4, 2);
	public static final List<Integer> SIMPLE_SORTED = asList(1, 2, 3, 4);

	public static final List<Integer> DOUBLE = asList(2, 1, 2, 3);
	public static final List<Integer> DOUBLE_SORTED = asList(1, 2, 2, 3);

	public static final List<Integer> TRIPLE = asList(2, 1, 2, 3, 2);
	public static final List<Integer> TRIPLE_SORTED = asList(1, 2, 2, 2, 3);

	public static final List<Integer> SORTED = asList(1, 2, 3, 4);

	public static final List<Integer> REVERSED = asList(4, 3, 2, 1);

	public static final List<Integer> EXTENDED = asList(9, 3, 1, 4, 7, 5, 2, 0, 6, 8);
	public static final List<Integer> EXTENDED_SORTED = asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

	public static final List<String> SIMPLE_STRING = asList("banana", "cherry", "apple");
	public static final List<String> SIMPLE_STRING_SORTED = asList("apple", "banana", "cherry");

	public static final Fruit BANANA = new Fruit("banana", Color.YELLOW);
	public static final Fruit LEMON = new Fruit("lemon", Color.YELLOW);
	public static final Fruit PINEAPPLE = new Fruit("pineapple", Color.YELLOW);

	public static final Fruit ORANGE = new Fruit("orange", Color.ORANGE);

	public static final Fruit CHERRY = new Fruit("cherry", Color.RED);


	public static final List<Fruit> FRUITS = asList(
		LEMON, CHERRY, BANANA, ORANGE, PINEAPPLE
	);
	public static final List<Fruit> FRUITS_SORTED = asList(
			ORANGE, CHERRY, LEMON, BANANA, PINEAPPLE
	);

	public static Stream<Arguments> getLists() {
		return Stream.of(
				Arguments.of(SIMPLE, SIMPLE_SORTED),
				Arguments.of(DOUBLE, DOUBLE_SORTED),
				Arguments.of(TRIPLE, TRIPLE_SORTED),
				Arguments.of(SORTED, SIMPLE_SORTED),
				Arguments.of(REVERSED, SIMPLE_SORTED),
				Arguments.of(EXTENDED, EXTENDED_SORTED)
		);
	}
}
