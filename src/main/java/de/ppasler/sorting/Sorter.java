package de.ppasler.sorting;

import java.util.List;

/**
 * Interface for sorting {@link java.util.List} in-place
 */
public interface Sorter {
	List<Integer> sort(List<Integer> list);
}
