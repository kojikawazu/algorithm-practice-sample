package com.example.app.controller.sort;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.entity.SortRequest;
import com.example.app.entity.SortResponse;
import com.example.app.utils.sort.BubbleSort;
import com.example.app.utils.sort.BucketSort;
import com.example.app.utils.sort.CountingSort;
import com.example.app.utils.sort.HeapSort;
import com.example.app.utils.sort.InsertionSort;
import com.example.app.utils.sort.MergeSort;
import com.example.app.utils.sort.QuickSort;
import com.example.app.utils.sort.RadixSort;
import com.example.app.utils.sort.SelectionSort;
import com.example.app.utils.sort.ShellSort;

/**
 * ソートコントローラ
 * @since 2024/11/24
 * @author koji kawazu
 */
@RestController
@RequestMapping("/api/sort")
public class SortController {

	/**
	 * ソートリクエスト
	 * @param algorithm
	 * @param request
	 * @return レスポンスデータ
	 */
	@GetMapping("/{algorithm}")
	public ResponseEntity<SortResponse> sortRequest(@PathVariable String algorithm,
			@RequestBody SortRequest request) {
		List<Integer> numbers = new ArrayList<>(request.getNumbers());
		SortResponse response = new SortResponse();
		long startTime = System.currentTimeMillis();
		int swaps = 0;

		switch (algorithm.toLowerCase()) {
		case "bubble":
			BubbleSort bubble = new BubbleSort();
			swaps = bubble.performSort(numbers);
			response.setSwapCount(swaps);
			break;
		case "bucket":
			BucketSort bucket = new BucketSort();
			swaps = bucket.performSort(numbers);
			response.setSwapCount(swaps);
			break;
		case "counting":
			CountingSort counting = new CountingSort();
			swaps = counting.performSort(numbers);
			response.setSwapCount(swaps);
			break;
		case "heap":
			HeapSort heap = new HeapSort();
			swaps = heap.performSort(numbers);
			response.setSwapCount(swaps);
			break;
		case "insertion":
			InsertionSort insertion = new InsertionSort();
			swaps = insertion.performSort(numbers);
			response.setSwapCount(swaps);
			break;
		case "merge":
			MergeSort merge = new MergeSort();
			swaps = merge.performSort(numbers);
			response.setSwapCount(swaps);
			break;
		case "quick":
			QuickSort quick = new QuickSort();
			swaps = quick.performSort(numbers);
			response.setSwapCount(swaps);
			break;
		case "radix":
			RadixSort radix = new RadixSort();
			swaps = radix.performSort(numbers);
			response.setSwapCount(swaps);
			break;
		case "selection":
			SelectionSort selection = new SelectionSort();
			swaps = selection.performSort(numbers);
			response.setSwapCount(swaps);
			break;
		case "shell":
			ShellSort shell = new ShellSort();
			swaps = shell.performSort(numbers);
			response.setSwapCount(swaps);
			break;
		default:
			return ResponseEntity.badRequest().body(new SortResponse());
		}

		long endTime = System.currentTimeMillis();
		response.setSortedNumbers(numbers);
		response.setExecutionTimeMs(endTime - startTime);

		return ResponseEntity.ok(response);
	}
}
