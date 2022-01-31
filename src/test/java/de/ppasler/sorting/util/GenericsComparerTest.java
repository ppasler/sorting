package de.ppasler.sorting.util;

import static de.ppasler.sorting.util.GenericsComparer.eq;
import static de.ppasler.sorting.util.GenericsComparer.gt;
import static de.ppasler.sorting.util.GenericsComparer.gte;
import static de.ppasler.sorting.util.GenericsComparer.lt;
import static de.ppasler.sorting.util.GenericsComparer.lte;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GenericsComparerTest {

	private final String apple = "apple";
	private final String banana = "banana";

	@Test
	void lt_testit() {
		assertTrue(lt(apple, banana));
		assertFalse(lt(banana, apple));
		assertFalse(lt(apple, apple));
	}

	@Test
	void gt_testit() {
		assertFalse(gt(apple, banana));
		assertTrue(gt(banana, apple));
		assertFalse(gt(apple, apple));
	}

	@Test
	void lte_testit() {
		assertTrue(lte(apple, banana));
		assertFalse(lte(banana, apple));
		assertTrue(lte(apple, apple));
	}

	@Test
	void gte_testit() {
		assertFalse(gte(apple, banana));
		assertTrue(gte(banana, apple));
		assertTrue(gte(apple, apple));
	}

	@Test
	void eq_testit() {
		assertFalse(eq(apple, banana));
		assertFalse(eq(banana, apple));
		assertTrue(eq(apple, apple));
	}
}
