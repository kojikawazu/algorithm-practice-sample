package com.example.app.utils.sort;

import java.util.List;

/**
 * ヒープソート
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class HeapSort implements MySort {

	/**
	 * コンストラクタ
	 */
	public HeapSort() {

	}

	@Override
	public int performSort(List<Integer> numbers) {
		if (numbers == null || numbers.size() <= 1) {
			return 0;
		}
		return this.heapSort(numbers);
	}

	/**
	 * ヒープソート
	 * 
	 * @param numbers ソート対象のリスト
	 * @return swapカウント
	 */
	private int heapSort(List<Integer> numbers) {
		int swapCount = 0;
		int n = numbers.size();

		System.out.println("Start: " + numbers.toString());

		for (int i = n / 2 - 1; i >= 0; i--) {
			swapCount += heapify(numbers, n, i);
		}

		for (int i = n - 1; i > 0; i--) {
			int temp = numbers.get(0);
			numbers.set(0, numbers.get(i));
			numbers.set(i, temp);
			System.out.println("Sort: " + numbers.toString());
			swapCount++;

			swapCount += heapify(numbers, i, 0);
		}

		System.out.println("Finish: " + numbers.toString());
		return swapCount;
	}

	/**
	 * ヒープ
	 * 
	 * @param numbers
	 * @param n
	 * @param i
	 * @return swapCount
	 */
	private int heapify(List<Integer> numbers, int n, int i) {
		int swapCount = 0;
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && numbers.get(left) > numbers.get(largest)) {
			largest = left;
		}

		if (right < n && numbers.get(right) > numbers.get(largest)) {
			largest = right;
		}

		if (largest != i) {
			int swap = numbers.get(i);
			numbers.set(i, numbers.get(largest));
			numbers.set(largest, swap);
			System.out.println("Sort: " + numbers.toString());
			swapCount++;

			swapCount += heapify(numbers, n, largest);
		}

		return swapCount;
	}
}
