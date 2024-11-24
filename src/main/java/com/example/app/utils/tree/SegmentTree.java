package com.example.app.utils.tree;

/**
 * セグメントツリー
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class SegmentTree {

	/**
	 * セグメントツリー (Segment Tree) を実装したものです。 セグメントツリーは、配列に対する範囲クエリ（例えば、範囲内の合計、最小値、最大値）と
	 * 更新クエリを効率的に処理するデータ構造です。
	 *
	 * この実装では、配列の範囲の合計の計算と、特定の要素の値の更新を行うことができます。
	 *
	 * [セグメントツリーの特徴] - セグメントツリーは、ある配列に対する特定の範囲クエリ（範囲内の和、最大値、最小値など）を
	 * 効率的に計算するために使われるデータ構造です。 - 配列の要素が更新されても、その変更を素早く反映できるように構築されており、 クエリや更新操作を
	 * O(log n) の時間で行うことができます。
	 *
	 * [計算量] - 構築: セグメントツリーの構築には、配列の各要素をノードに格納して、 木の高さに応じた中間ノードを作成するため、O(n)
	 * の時間がかかります。 - クエリ: 範囲に対する集計クエリは、木の高さに沿って探索し、 O(log n) の計算量で結果を求めることができます。 -
	 * 更新: 配列内の値を変更する場合、影響を受けるノードのみを 更新するため、O(log n) の計算量で処理可能です。
	 *
	 * [セグメントツリーを採用する場面] - 区間の合計を求める問題（Range Sum Query） - 配列内の特定の範囲 [L, R]
	 * における要素の合計を繰り返し求める必要がある。
	 *
	 * - 区間の最小値または最大値を求める問題（Range Minimum/Maximum Query） - 配列内の特定の範囲 [L, R]
	 * における最小値または最大値を効率的に求めたい。
	 *
	 * - 区間のGCD/LCMを求める問題（Range GCD/LCM Query） - 配列内の特定の範囲 [L, R]
	 * における**最大公約数（GCD）または 最小公倍数（LCM）**を効率的に求める必要がある場合。
	 *
	 * - 区間の加算と単一の値の取得（Range Update and Point Query） - 配列内のある範囲 [L, R]
	 * の要素に対して加算操作を行い、その後、特定の位置の値を取得する。
	 *
	 * - 区間内での条件を満たす要素のカウント（Range Count Query） -
	 * 配列の中で、ある特定の範囲内において、条件を満たす要素の数を数えたい場合。
	 *
	 * - 2Dセグメントツリーによる2次元区間クエリ - 2次元の平面において、特定の領域内の集計（例えば合計、最小値など）を効率的に求める必要がある場合
	 *
	 */

	int[] st; // セグメントツリーを格納する配列

	/**
	 * コンストラクタ
	 * 
	 * @param arr
	 * @param n
	 */
	SegmentTree(int[] arr, int n) {
		// ツリーの高さを計算
		int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));

		// ツリーの最大サイズ
		int max_size = 2 * (int) Math.pow(2, x) - 1;

		st = new int[max_size];

		// セグメントツリーを構築
		buildSegmentTree(arr, 0, n - 1, 0);
	}

	/**
	 * セグメントツリーを構築するメソッド
	 * 
	 * @param arr
	 * @param ss
	 * @param se
	 * @param si
	 * @return
	 */
	int buildSegmentTree(int[] arr, int ss, int se, int si) {
		// 葉ノードの場合
		if (ss == se) {
			st[si] = arr[ss];
			return arr[ss];
		}

		// 中間インデックスを計算
		int mid = getMid(ss, se);

		// 左右の子を再帰的に構築し、親に結果を格納
		st[si] = buildSegmentTree(arr, ss, mid, si * 2 + 1) + buildSegmentTree(arr, mid + 1, se, si * 2 + 2);
		return st[si];
	}

	/**
	 * 範囲の合計を取得するメソッド
	 * 
	 * @param n
	 * @param qs
	 * @param qe
	 * @return
	 */
	int getSum(int n, int qs, int qe) {
		// 入力の検証
		if (qs < 0 || qe > n - 1 || qs > qe) {
			System.out.println("無効な入力");
			return -1;
		}
		return getSumUtil(0, n - 1, qs, qe, 0);
	}

	/**
	 * 範囲の合計を計算するユーティリティメソッド
	 * 
	 * @param ss
	 * @param se
	 * @param qs
	 * @param qe
	 * @param si
	 * @return
	 */
	int getSumUtil(int ss, int se, int qs, int qe, int si) {
		// 完全に範囲内の場合
		if (qs <= ss && qe >= se)
			return st[si];

		// 完全に範囲外の場合
		if (se < qs || ss > qe)
			return 0;

		// 部分的に範囲内の場合
		int mid = getMid(ss, se);
		return getSumUtil(ss, mid, qs, qe, 2 * si + 1) + getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
	}

	/**
	 * 値の更新
	 * 
	 * @param arr
	 * @param n
	 * @param i
	 * @param new_val
	 */
	void updateValue(int[] arr, int n, int i, int new_val) {
		// 入力の検証
		if (i < 0 || i > n - 1) {
			System.out.println("無効な入力");
			return;
		}

		// 差分を計算
		int diff = new_val - arr[i];
		arr[i] = new_val;

		// セグメントツリーを更新
		updateValueUtil(0, n - 1, i, diff, 0);
	}

	/**
	 * セグメントツリーを更新するユーティリティメソッド
	 * 
	 * @param ss
	 * @param se
	 * @param i
	 * @param diff
	 * @param si
	 */
	void updateValueUtil(int ss, int se, int i, int diff, int si) {
		// 範囲外の場合
		if (i < ss || i > se)
			return;

		// ノードに差分を加算
		st[si] = st[si] + diff;

		// 葉ノードでない場合、子ノードも更新
		if (se != ss) {
			int mid = getMid(ss, se);
			updateValueUtil(ss, mid, i, diff, 2 * si + 1);
			updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
		}
	}

	/**
	 * 中間インデックスを計算するヘルパーメソッド
	 * 
	 * @param s
	 * @param e
	 * @return
	 */
	int getMid(int s, int e) {
		return s + (e - s) / 2;
	}

	/**
	 * main関数
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		int[] arr = { 1, 3, 5, 7, 9, 11 };
		int n = arr.length;
		SegmentTree tree = new SegmentTree(arr, n);

		// 範囲[1,3]の合計を取得
		System.out.println("範囲 [1, 3] の合計: " + tree.getSum(n, 1, 3));

		// 値の更新: arr[1] を10に変更
		tree.updateValue(arr, n, 1, 10);

		// 更新後の範囲[1,3]の合計を取得
		System.out.println("値の更新後、範囲 [1, 3] の合計: " + tree.getSum(n, 1, 3));
	}
}
