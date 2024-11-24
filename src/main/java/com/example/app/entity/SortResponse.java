package com.example.app.entity;

import java.util.List;

import lombok.Data;

/**
 * ソートレスポンス
 * @since 2024/11/24
 * @author koji kawazu
 */
@Data
public class SortResponse {
	private List<Integer> sortedNumbers;
	private long executionTimeMs;
	private int swapCount;
}
