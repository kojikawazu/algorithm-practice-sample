package com.example.app.utils.sort;

import java.util.List;

/**
 * マージソート
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class MergeSort implements MySort {

	/**
	 * コンストラクタ
	 */
	public MergeSort() {

	}

	@Override
	public int performSort(List<Integer> numbers) {
		if (numbers == null || numbers.size() <= 1) {
			return 0;
		}

		System.out.println("Start: " + numbers.toString());
		int swapCount = mergeSort(numbers, 0, numbers.size() - 1);
		System.out.println("Finish: " + numbers.toString());

		return swapCount;
	}

	/**
	 * マージソート
	 * 
	 * @param numbers ソート対象のリスト
	 * @param left
	 * @param right
	 * @return swapカウント
	 */
	private int mergeSort(List<Integer> numbers, int left, int right) {
		int swapCount = 0;

		if (left < right) {
			int middle = (left + right) / 2;
			swapCount += mergeSort(numbers, left, middle);
			swapCount += mergeSort(numbers, middle + 1, right);
			swapCount += merge(numbers, left, middle, right);
		}

		return swapCount;
	}

	/**
	 * マージ
	 * 
	 * @param numbers ソート対象のリスト
	 * @param left
	 * @param middle
	 * @param right
	 * @return swapCount
	 */
	private int merge(List<Integer> numbers, int left, int middle, int right) {
		int swapCount = 0;
		int n1 = middle - left + 1;
		int n2 = right - middle;

		int[] leftArray = new int[n1];
		int[] rightArray = new int[n2];

		for (int i = 0; i < n1; ++i) {
			leftArray[i] = numbers.get(left + i);
		}
		for (int j = 0; j < n2; ++j) {
			rightArray[j] = numbers.get(middle + 1 + j);
		}

		int i = 0, j = 0;
		int k = left;

		while (i < n1 && j < n2) {
			if (leftArray[i] <= rightArray[j]) {
				numbers.set(k, leftArray[i]);
				System.out.println("Sort: " + numbers.toString());
				i++;
				swapCount++;
			} else {
				numbers.set(k, rightArray[j]);
				System.out.println("Sort: " + numbers.toString());
				j++;
				swapCount++;
			}
			k++;
		}

		while (i < n1) {
			numbers.set(k, leftArray[i]);
			i++;
			k++;
		}

		while (j < n2) {
			numbers.set(k, rightArray[j]);
			j++;
			k++;
		}

		return swapCount;
	}
}
