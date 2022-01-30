package de.ppasler.sorting;

import java.util.List;

/**
 * Interface for sorting {@link List} in-place
 */
public abstract class AbstractSorter<T extends Comparable<T>> implements Sorter<T> {
	public abstract List<T> sort(List<T> list);

	protected boolean gt(final T x, final T y) {
		return x.compareTo(y) > 0;
	}

	protected boolean gte(final T x, final T y) {
		return x.compareTo(y) >= 0;
	}

	protected boolean lt(final T x, final T y) {
		return x.compareTo(y) < 0;
	}

	protected boolean lte(final T x, final T y) {
		return x.compareTo(y) <= 0;
	}

	protected boolean eq(final T x, final T y) {
		return x.compareTo(y) == 0;
	}
}

