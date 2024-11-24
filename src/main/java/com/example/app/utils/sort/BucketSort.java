package com.example.app.utils.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * バケットソート
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class BucketSort implements MySort {

	/**
	 * コンストラクタ
	 */
	public BucketSort() {

	}

	@Override
	public int performSort(List<Integer> numbers) {
		if (numbers == null || numbers.size() <= 1) {
			return 0;
		}
		return this.bucketSort(numbers);
	}

	/**
	 * バケットソート
	 * 
	 * @param numbers
	 * @return
	 */
	private int bucketSort(List<Integer> numbers) {
		int max = Collections.max(numbers);
		int bucketCount = max / 10 + 1;
		List<List<Integer>> buckets = new ArrayList<>(bucketCount);
		int swapCount = 0;

		System.out.println("Start: " + numbers.toString());

		for (int i = 0; i < bucketCount; i++) {
			buckets.add(new LinkedList<>());
		}

		for (int number : numbers) {
			int bucketIndex = number / 10;
			buckets.get(bucketIndex).add(number);
		}

		numbers.clear();
		for (List<Integer> bucket : buckets) {
			Collections.sort(bucket);
			numbers.addAll(bucket);
			System.out.println("Sort: " + numbers.toString());
			swapCount += bucket.size();
		}

		System.out.println("Finish: " + numbers.toString());
		return swapCount;
	}
}
