package com.example.app.utils.sort;

import java.util.Collections;
import java.util.List;

/**
 * カウントソート
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class CountingSort implements MySort {

	/**
	 * コンストラクタ
	 */
	public CountingSort() {

	}

	@Override
	public int performSort(List<Integer> numbers) {
		if (numbers == null || numbers.size() <= 1) {
			return 0;
		}
		return this.countingSort(numbers);
	}

	/**
	 * カウントソート
	 * 
	 * @param numbers ソート対象のリスト
	 * @return swapカウント
	 */
	private int countingSort(List<Integer> numbers) {
		int max = Collections.max(numbers);
		int[] countArray = new int[max + 1];
		int swapCount = 0;

		System.out.println("Start: " + numbers.toString());

		for (int number : numbers) {
			countArray[number]++;
		}

		int index = 0;
		for (int i = 0; i < countArray.length; i++) {
			while (countArray[i] > 0) {
				numbers.set(index++, i);
				System.out.println("Sort: " + numbers.toString());
				countArray[i]--;
				swapCount++;
			}
		}

		System.out.println("Finish: " + numbers.toString());
		return swapCount;
	}
}
