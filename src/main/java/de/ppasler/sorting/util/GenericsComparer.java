package de.ppasler.sorting.util;

/**
 * Extends the generic sorter with
 */
public class GenericsComparer {

	public static <T extends Comparable<T>> boolean gt(final T x, final T y) {
		return x.compareTo(y) > 0;
	}

	public static <T extends Comparable<T>> boolean gte(final T x, final T y) {
		return x.compareTo(y) >= 0;
	}

	public static <T extends Comparable<T>> boolean lt(final T x, final T y) {
		return x.compareTo(y) < 0;
	}

	public static <T extends Comparable<T>> boolean lte(final T x, final T y) {
		return x.compareTo(y) <= 0;
	}

	public static <T extends Comparable<T>> boolean eq(final T x, final T y) {
		return x.compareTo(y) == 0;
	}
}

