package de.ppasler.sorting;

import static java.util.Arrays.asList;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class DataProvider {

	public static final List<Integer> SIMPLE = asList(3, 1, 4, 2);
	public static final List<Integer> SIMPLE_SORTED = asList(1, 2, 3, 4);

	public static final List<Integer> DOUBLE = asList(2, 1, 2, 3);
	public static final List<Integer> DOUBLE_SORTED = asList(1, 2, 2, 3);

	public static final List<Integer> SORTED = asList(1, 2, 3, 4);

	public static final List<Integer> REVERSED = asList(4, 3, 2, 1);

	public static final List<Integer> EXTENDED = asList(9, 3, 1, 4, 7, 5, 2, 0, 6, 8);
	public static final List<Integer> EXTENDED_SORTED = asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

	public static Stream<Arguments> getLists() {
		return Stream.of(
				Arguments.of(SIMPLE, SIMPLE_SORTED),
				Arguments.of(DOUBLE, DOUBLE_SORTED),
				Arguments.of(SORTED, SIMPLE_SORTED),
				Arguments.of(REVERSED, SIMPLE_SORTED),
				Arguments.of(EXTENDED, EXTENDED_SORTED)
		);
	}
}
