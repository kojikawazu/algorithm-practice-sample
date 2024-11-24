package com.example.app.utils.algorithm;

import java.util.Arrays;
import java.util.List;

/**
 * 並列ストリーム
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class ParallelStreamExample {

	/**
	 * リスト内の要素を並列に処理する例です。 並列ストリームは、コレクション内のデータを複数のスレッドで並列に処理することで、
	 * 処理時間を短縮し、パフォーマンスを向上させるための手段です。
	 * 
	 * [概要] - **並列ストリーム（Parallel Stream）**を使うことで、リストの各要素を複数のスレッドで並列に処理します。 -
	 * parallelStream() を使用すると、Javaが内部的に複数のスレッドを使用して要素を処理するため、
	 * 全体の処理時間を短縮することが期待できます。
	 */

	/**
	 * main関数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> names = Arrays.asList("佐藤", "鈴木", "高橋", "田中", "伊藤");

		// 並列ストリームでデータを処理
		names.parallelStream().forEach(name -> {
			System.out.println("名前: " + name + " を処理中... スレッド " + Thread.currentThread().getName());
			try {
				Thread.sleep(500); // 処理をシミュレート
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		System.out.println("すべての名前の処理が完了しました。");
	}
}
