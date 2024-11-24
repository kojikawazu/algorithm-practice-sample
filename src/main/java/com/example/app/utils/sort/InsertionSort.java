package com.example.app.utils.sort;

import java.util.List;

/**
 * 挿入ソート
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class InsertionSort implements MySort {

	/**
	 * コンストラクタ
	 */
	public InsertionSort() {

	}

	@Override
	public int performSort(List<Integer> numbers) {
		if (numbers == null || numbers.size() <= 1) {
			return 0;
		}
		return this.insertionSort(numbers);
	}

	/**
	 * 挿入ソート
	 * 
	 * @param numbers
	 * @return swapCount
	 */
	private int insertionSort(List<Integer> numbers) {
		int swapCount = 0;
		int n = numbers.size();

		System.out.println("Start: " + numbers.toString());

		for (int i = 1; i < n; i++) {
			int key = numbers.get(i);
			int j = i - 1;

			while (j >= 0 && numbers.get(j) > key) {
				numbers.set(j + 1, numbers.get(j));
				j = j - 1;
				swapCount++;
			}
			numbers.set(j + 1, key);
			System.out.println("Sort: " + numbers.toString());
		}

		System.out.println("Finish: " + numbers.toString());
		return swapCount;
	}
}
