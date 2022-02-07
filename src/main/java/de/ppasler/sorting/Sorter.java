package de.ppasler.sorting;

import java.util.List;

/**
 * Interface for sorting {@link java.util.List} in-place
 */
public interface Sorter<T extends Comparable<T>> {
	void sort(List<T> list);

	boolean isStable();
}
