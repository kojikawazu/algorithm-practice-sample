package com.example.app.entity;

import java.util.List;

import lombok.Data;

/**
 * ソートリクエストデータ
 * @since 2024/11/24
 * @author koji kawazu
 */
@Data
public class SortRequest {
	private List<Integer> numbers;
}
