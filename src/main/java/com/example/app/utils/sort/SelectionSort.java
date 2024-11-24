package com.example.app.utils.sort;

import java.util.List;

/**
 * 選択ソート
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class SelectionSort implements MySort {

	/**
	 * コンストラクタ
	 */
	public SelectionSort() {

	}

	@Override
	public int performSort(List<Integer> numbers) {
		if (numbers == null || numbers.size() <= 1) {
			return 0;
		}

		return this.selectionSort(numbers);
	}

	/**
	 * 選択ソート
	 * 
	 * @param numbers ソート対象のリスト
	 * @return swapカウント
	 */
	private int selectionSort(List<Integer> numbers) {
		int swapCount = 0;
		int n = numbers.size();

		System.out.println("Start: " + numbers.toString());

		for (int i = 0; i < n - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < n; j++) {
				if (numbers.get(j) < numbers.get(minIdx)) {
					minIdx = j;
				}
			}

			if (minIdx != i) {
				int temp = numbers.get(i);
				numbers.set(i, numbers.get(minIdx));
				numbers.set(minIdx, temp);
				System.out.println("Sort: " + numbers.toString());
				swapCount++;
			}
		}

		System.out.println("Finish: " + numbers.toString());
		return swapCount;
	}
}
