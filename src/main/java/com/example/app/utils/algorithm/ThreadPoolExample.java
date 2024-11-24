package com.example.app.utils.algorithm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * スレッドプール
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class ThreadPoolExample {

	/**
	 * 複数のタスクを並列に処理する例です。 スレッドプールを使うことで、複数のスレッドの作成や管理を自動化し、効率的にタスクを処理することができます。
	 * このコードは、ExecutorServiceを使って固定サイズのスレッドプールを作成し、10個のタスクを並列に処理しています。
	 * 
	 * [概要] - スレッドプールを使って、10個のタスクを効率的に並列処理しています。 -
	 * スレッドプールは事前に定義した数のスレッドを再利用することで、スレッドの作成と破棄にかかるオーバーヘッドを削減します。
	 * 
	 */

	/**
	 * タスク
	 */
	static class Task implements Runnable {
		private int taskId;

		/**
		 * コンストラクタ
		 * 
		 * @param id
		 */
		Task(int id) {
			this.taskId = id;
		}

		@Override
		public void run() {
			System.out.println("タスク " + taskId + " をスレッド " + Thread.currentThread().getName() + " が実行中...");
			try {
				Thread.sleep(500); // タスクの処理をシミュレート
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("タスク " + taskId + " が完了しました。");
		}
	}

	/**
	 * main関数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// スレッドプールを作成（固定サイズ）
		ExecutorService executor = Executors.newFixedThreadPool(3);

		// 10個のタスクをスレッドプールに提出
		for (int i = 1; i <= 10; i++) {
			executor.execute(new Task(i));
		}

		// スレッドプールをシャットダウン
		executor.shutdown();
	}
}
