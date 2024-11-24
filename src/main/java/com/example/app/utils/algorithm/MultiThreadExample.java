package com.example.app.utils.algorithm;

/**
 * 並列アルゴリズム
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class MultiThreadExample {

	/**
	 * 複数のタスクを並列に実行することで、処理を効率的に進める方法を示しています。
	 * スレッドを使うことで、CPUリソースを最大限に活用し、複数のタスクを同時に処理することが可能になります。
	 * 
	 * [概要] - このプログラムでは、複数のタスク（スレッド）を並列に実行しています。 -
	 * 各タスクは1秒間の遅延をシミュレーションしており、全てのタスクが完了するまでメインスレッドが待機します。
	 */

	/**
	 * タスクを定義するクラス
	 */
	static class Task implements Runnable {
		private String name;

		/**
		 * コンストラクタ
		 * 
		 * @param name
		 */
		Task(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			System.out.println("タスク " + name + " を実行中... " + Thread.currentThread().getName());
			try {
				// タスクの処理（ここではシミュレーションのためにスリープ）
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("タスク " + name + " が完了しました。");
		}
	}

	/**
	 * main関数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// スレッドの作成と開始
		Thread thread1 = new Thread(new Task("A"));
		Thread thread2 = new Thread(new Task("B"));
		Thread thread3 = new Thread(new Task("C"));

		thread1.start();
		thread2.start();
		thread3.start();

		// メインスレッドが他のスレッドの完了を待機
		try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("すべてのタスクが完了しました。");
	}
}
