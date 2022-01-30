package de.ppasler.sorting;

import java.util.List;

/**
 * Interface for sorting {@link java.util.List} in-place
 */
public interface Sorter<T extends Comparable<T>> {
	List<T> sort(List<T> list);
}
