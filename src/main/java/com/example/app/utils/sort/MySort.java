package com.example.app.utils.sort;

import java.util.List;

/**
 * ソートIF
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public interface MySort {

	/**
	 * ソート
	 * 
	 * @param numbers
	 * @return swapCount
	 */
	public int performSort(List<Integer> numbers);
}
