package com.example.app.utils.sort;

import java.util.List;

/**
 * シェルソート
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class ShellSort implements MySort {

	/**
	 * コンストラクタ
	 */
	public ShellSort() {

	}

	@Override
	public int performSort(List<Integer> numbers) {
		if (numbers == null || numbers.size() <= 1) {
			return 0;
		}
		return this.shellSort(numbers);
	}

	/**
	 * シェルソート
	 * 
	 * @param numbers ソート対象のリスト
	 * @return swapカウント
	 */
	private int shellSort(List<Integer> numbers) {
		int n = numbers.size();
		int swapCount = 0;

		System.out.println("Start: " + numbers.toString());

		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i++) {
				int temp = numbers.get(i);
				int j;
				for (j = i; j >= gap && numbers.get(j - gap) > temp; j -= gap) {
					numbers.set(j, numbers.get(j - gap));
					System.out.println("Sort: " + numbers.toString());
					swapCount++;
				}
				numbers.set(j, temp);
			}
		}

		System.out.println("Finish: " + numbers.toString());
		return swapCount;
	}
}
