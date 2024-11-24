package com.example.app.utils.sort;

import java.util.List;

/**
 * クイックソート
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class QuickSort implements MySort {

	/**
	 * コンストラクタ
	 */
	public QuickSort() {

	}

	@Override
	public int performSort(List<Integer> numbers) {
		if (numbers == null || numbers.size() <= 1) {
			return 0;
		}

		System.out.println("Start: " + numbers.toString());
		int swapCount = quickSort(numbers, 0, numbers.size() - 1);
		System.out.println("Fisish: " + numbers.toString());

		return swapCount;
	}

	/**
	 * クイックソート
	 * 
	 * @param numbers
	 * @param low
	 * @param high
	 * @return swapカウント
	 */
	private int quickSort(List<Integer> numbers, int low, int high) {
		int swapCount = 0;

		if (low < high) {
			int pivotIndex = partition(numbers, low, high);
			swapCount += pivotIndex;
			swapCount += quickSort(numbers, low, pivotIndex - 1);
			swapCount += quickSort(numbers, pivotIndex + 1, high);
		}

		return swapCount;
	}

	/**
	 * パーティション
	 * 
	 * @param numbers
	 * @param low
	 * @param high
	 * @return swapカウント
	 */
	private int partition(List<Integer> numbers, int low, int high) {
		int pivot = numbers.get(high);
		int i = (low - 1);

		for (int j = low; j < high; j++) {
			if (numbers.get(j) <= pivot) {
				i++;
				swap(numbers, i, j);
			}
		}

		swap(numbers, i + 1, high);
		return i + 1;
	}

	/**
	 * スワップ
	 * 
	 * @param numbers
	 * @param i
	 * @param j
	 */
	private void swap(List<Integer> numbers, int i, int j) {
		int temp = numbers.get(i);
		numbers.set(i, numbers.get(j));
		numbers.set(j, temp);
		System.out.println("Sort: " + numbers.toString());
	}
}
