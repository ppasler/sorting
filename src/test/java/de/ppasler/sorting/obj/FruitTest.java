package de.ppasler.sorting.obj;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import de.ppasler.sorting.obj.Fruit.Color;

class FruitTest {

	private static final Fruit greenApple = new Fruit("apple", Color.GREEN);
	private static final Fruit anotherGreenApple = new Fruit("apple", Color.GREEN);
	private static final Fruit redApple = new Fruit("apple", Color.RED);
	private static final Fruit raspberry = new Fruit("raspberry", Color.RED);

	@Test
	void equals() {
		assertEquals(greenApple, anotherGreenApple);
		assertNotEquals(greenApple, redApple);
		assertNotEquals(redApple, raspberry);
		assertNotEquals(greenApple, "yellowApple");
	}

	public static Stream<Arguments> fruits() {
		return Stream.of(
				Arguments.of(greenApple, greenApple, equalTo(0)),
				Arguments.of(greenApple, anotherGreenApple, equalTo(0)),
				Arguments.of(greenApple, redApple, lessThan(0)),
				Arguments.of(redApple, greenApple, greaterThan(0))
		);
	}

	@ParameterizedTest(name = "#{index}: {0}.compareTo({1}) == {2}")
	@MethodSource("fruits")
	void compareTo(final Fruit fruit, final Fruit anotherFruit, final Matcher<Integer> expected) {
		assertThat(fruit.compareTo(anotherFruit), expected);
	}
}
