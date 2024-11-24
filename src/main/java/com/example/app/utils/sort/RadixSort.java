package com.example.app.utils.sort;

import java.util.Collections;
import java.util.List;

/**
 * 基数ソート
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class RadixSort implements MySort {

	/**
	 * コンストラクタ
	 */
	public RadixSort() {

	}

	@Override
	public int performSort(List<Integer> numbers) {
		if (numbers == null || numbers.size() <= 1) {
			return 0;
		}
		return this.radixSort(numbers);
	}

	/**
	 * 基数ソート
	 * 
	 * @param numbers ソート対象のリスト
	 * @return swapカウント
	 */
	private int radixSort(List<Integer> numbers) {
		int max = Collections.max(numbers);
		int swapCount = 0;

		System.out.println("Start: " + numbers.toString());

		for (int exp = 1; max / exp > 0; exp *= 10) {
			swapCount += countSortByDigit(numbers, exp);
		}

		System.out.println("Finish: " + numbers.toString());
		return swapCount;
	}

	/**
	 * 
	 * @param numbers
	 * @param exp
	 * @return swapCount
	 */
	private int countSortByDigit(List<Integer> numbers, int exp) {
		int n = numbers.size();
		int[] output = new int[n];
		int[] count = new int[10];
		int swapCount = 0;

		for (int i = 0; i < n; i++) {
			count[(numbers.get(i) / exp) % 10]++;
		}

		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}

		for (int i = n - 1; i >= 0; i--) {
			output[count[(numbers.get(i) / exp) % 10] - 1] = numbers.get(i);
			count[(numbers.get(i) / exp) % 10]--;
			swapCount++;
		}

		for (int i = 0; i < n; i++) {
			numbers.set(i, output[i]);
			System.out.println("Sort: " + numbers.toString());
		}

		return swapCount;
	}
}
