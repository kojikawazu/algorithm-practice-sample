package com.example.app.utils.sort;

import java.util.List;

/**
 * バブルソート
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class BubbleSort implements MySort {

	/**
	 * コンストラクタ
	 */
	public BubbleSort() {

	}

	@Override
	public int performSort(List<Integer> numbers) {
		if (numbers == null || numbers.size() <= 1) {
			return 0;
		}
		return this.bubbleSort(numbers);
	}

	/**
	 * バブルソート
	 * 
	 * @param numbers
	 * @return swapCount
	 */
	private int bubbleSort(List<Integer> numbers) {
		int swapCount = 0;
		int n = numbers.size();

		System.out.println("Start: " + numbers.toString());

		for (int i = 0; i < n - 1; i++) {
			boolean swapped = false;

			for (int j = 0; j < n - i - 1; j++) {
				if (numbers.get(j) > numbers.get(j + 1)) {
					int temp = numbers.get(j);
					numbers.set(j, numbers.get(j + 1));
					numbers.set(j + 1, temp);
					swapped = true;
					swapCount++;
					System.out.println("Sort: " + numbers.toString());
				}
			}

			if (!swapped) {
				break;
			}
		}

		System.out.println("Finish: " + numbers.toString());
		return swapCount;
	}
}
