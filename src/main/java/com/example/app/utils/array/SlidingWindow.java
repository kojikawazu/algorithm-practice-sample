package com.example.app.utils.array;

/**
 * スライディングウィンドウ法
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class SlidingWindow {

	/**
	 * [スライディングウィンドウ法 (Sliding Window Technique)]
	 * スライディングウィンドウ法は、配列や文字列内の連続する要素（部分配列や部分文字列）を扱うときに、
	 * 特定の条件を満たす最適な部分（例えば、最大または最小）を効率的に探すために使います。
	 *
	 * [スライディングウィンドウ法の特徴] - ウィンドウ（連続する要素の範囲）を動かしながら条件を満たす部分配列を探します。 -
	 * 可変サイズウィンドウと固定サイズウィンドウの2種類があります。 - 固定サイズウィンドウ:
	 * ウィンドウのサイズを固定して、それを配列全体にスライドさせていく。 - 可変サイズウィンドウ: 条件に応じてウィンドウのサイズを動的に変更します。
	 *
	 * [利点] - スライディングウィンドウ法を使用することで、重複する計算を避け、計算量を O(n) に削減することができます。
	 * 通常のネストされたループでのアプローチと比較して、効率的に最適な部分配列を見つけることが可能です。
	 *
	 * [ツーポインタ法とスライディングウィンドウ法の違い] -
	 * ツーポインタ法は、主に二つのポインタを使って特定の条件を満たすペアや部分を探すときに使用します。ポインタは両端から開始したり、特定の条件に基づいてそれぞれの方向に動かします。
	 * -
	 * スライディングウィンドウ法は、ウィンドウの開始位置と終了位置をポインタで管理し、ウィンドウのサイズを動的に変更しながら特定の条件を満たす最適な連続部分を探索するために使用します。
	 *
	 * [計算量] 計算量は O(n) です。各要素は最大で2回しか訪れない。
	 *
	 * [例] - 部分配列の和や特定の長さの和を扱う問題 - 気温の記録から、過去 k 日間の平均気温が最大になるような連続した k 日間を求める。
	 *
	 * - ターゲットを超える最小部分配列 - クレジットカードの支払い履歴から、一定以上の金額に達する最短の購入履歴を探す。
	 *
	 * - 特定の条件を満たす最長または最短の部分文字列 - 文章の中から、特定のキーワードすべてを含む最短の文を探す。
	 *
	 * - 文字列のアナグラム検出 - 単語パズルの中から、指定された単語の並び替えで作れる部分文字列を探す。
	 *
	 * - 二つのポインタを用いた「最大/最小」探索 - 在庫管理システムで、ある製品が特定の在庫レベルを超えない日数を効率的に求める。
	 *
	 * - カウントや頻度に関する問題 - ユーザーの行動ログから、特定のイベントが k 回だけ異なるような最長の連続イベント列を見つける。
	 *
	 * - 競技プログラミングやアルゴリズムの最適化 - LeetCode や AtCoder
	 * の問題で、時間制約を満たす必要がある場合に、重複する計算を省くことで効率化します。
	 */

	/**
	 * スライディングウィンドウ・ツーポインタ法 指定されたターゲット値を達成する最小の部分配列の長さを求める
	 * 
	 * @param s    部分配列の合計が目標とする整数
	 * @param nums 対象となる整数の配列
	 * @return 最小部分配列の長さ、条件を満たすものがない場合は 0
	 */
	public int minSubArrayLen(int s, int[] nums) {
		int n = nums.length;
		int minLen = Integer.MAX_VALUE;
		int sum = 0;
		int left = 0;

		for (int right = 0; right < n; right++) {
			sum += nums[right];
			// System.out.println("sum: " + sum);
			// System.out.println("n: " + n);
			// System.out.println("sum >= s: " + (sum >= s));

			while (sum >= s) {
				minLen = Math.min(minLen, right - left + 1);
				sum -= nums[left];
				left++;
			}

			// System.out.println("minLen: " + minLen);
		}

		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}

	/**
	 * main関数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SlidingWindow slidingWindow = new SlidingWindow();
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		int target = 7;
		int result = slidingWindow.minSubArrayLen(target, nums);
		System.out.println("最小のウィンドウサイズ: " + result);
	}
}
