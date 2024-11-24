package com.example.app.utils.algorithm;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * ForkJoinサンプル タスク分割平行処理
 *
 * @since 2024/11/24
 * @author koji kawazu
 */
public class ForkJoinExample {

	/**
	 * ForkJoinPoolを使って大きな配列の合計を効率的に計算するプログラム。
	 * ForkJoinフレームワークは、並列処理を簡単に実行できるJavaの標準なツール
	 * 大きなタスク小さなタスクに分割して並列に実行することでパフォーマンスを向上させる。
	 *
	 * [ForkJoinフレームワーク] - ForkJoinフレームワークは、大きなタスクを再帰的に小さなタスクに分割し、それを並列に実行するためのものです。
	 * - このプログラムでは、非常に大きな配列の合計値を求めるというタスクを並列に実行するために、
	 * ForkJoinPoolとRecursiveTaskを使っています。
	 *
	 * [ForkJoinを採用する場面] - 配列の合計を効率的に求める - 非常に大きな整数配列の合計を効率的に計算せよ - 数値解析や集計の最適化 -
	 * 数百万件のデータを並列に処理し、特定の条件に一致する数の集計を行う - パフォーマンス比較を問う問題 -
	 * シングルスレッドと並列処理で、大きなデータセットの合計を計算するプログラムを作成し、 それぞれのパフォーマンスを比較せよ
	 */

	/**
	 * 再帰的なタスク定義
	 */
	static class SumTask extends RecursiveTask<Long> {
		private static final int THRESHOLD = 10000;
		private int[] numbers;
		private int start;
		private int end;

		/**
		 * コンストラクタ
		 * 
		 * @param numbers
		 * @param start
		 * @param end
		 */
		SumTask(int[] numbers, int start, int end) {
			this.numbers = numbers;
			this.start = start;
			this.end = end;
		}

		@Override
		protected Long compute() {
			int length = end - start;
			if (length <= THRESHOLD) {
				// タスクが小さければ順次処理
				long sum = 0;
				for (int i = start; i < end; i++) {
					sum += numbers[i];
				}
				return sum;
			} else {
				// タスクを分割して再帰的に処理
				int mid = start + length / 2;
				SumTask leftTask = new SumTask(numbers, start, mid);
				SumTask rightTask = new SumTask(numbers, mid, end);

				// タスクを非同期で実行
				leftTask.fork();
				long rightResult = rightTask.compute();
				long leftResult = leftTask.join();

				// 結果を統合
				return leftResult + rightResult;
			}
		}
	}

	/**
	 * main関数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 大きな配列を作成
		int n = 100_000_000;
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = 1;
		}

		// フォーク/ジョインプールを作成
		ForkJoinPool forkJoinPool = new ForkJoinPool();

		// タスクを実行
		long startTime = System.currentTimeMillis();
		long total = forkJoinPool.invoke(new SumTask(numbers, 0, numbers.length));
		long endTime = System.currentTimeMillis();

		System.out.println("合計: " + total);
		System.out.println("処理時間: " + (endTime - startTime) + " ms");
	}
}
