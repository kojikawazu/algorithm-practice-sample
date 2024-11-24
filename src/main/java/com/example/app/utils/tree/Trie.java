package com.example.app.utils.tree;

/**
 * トライ木
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class Trie {

	/**
	 * トライ木は文字列の効率的な挿入と検索に特化したデータ構造で、辞書のように使うことができます。 特に、単語の存在確認や接頭辞検索などが効率的に行えます。
	 *
	 * [トライ木 (Trie) の特徴] - 各ノードはアルファベット文字を持つことができるため、文字列の各文字ごとに進んでいき、最終的に単語の終端を示します。
	 * 挿入、検索操作は平均的に O(m) の時間で行われます (m は文字列の長さ)
	 *
	 * - このトライ木ではアルファベット小文字 (a～z) のみを扱っています。
	 *
	 * [コード全体の概要] - TrieNode クラスはトライ木のノードを表し、子ノードを保持します。 - 単語の挿入と単語の検索が実装されています。
	 *
	 * [計算量] - m は操作対象の文字列の長さです。 - 検索、挿入、削除のすべての操作で、トライ木では文字列の各文字に対してノードをたどるため、 計算量は
	 * O(m) となります。 - 計算量は文字列の長さに依存するため、特に長さが短い文字列に対する操作は非常に効率的です。
	 *
	 * [トライ木を採用する場面] - 辞書の単語検索（Word Dictionary Search） -
	 * 辞書として与えられた文字列の集合に対して、特定の文字列が存在するかを効率的に検索する。
	 *
	 * - オートコンプリート機能の実装（Autocomplete System） -
	 * ユーザーが入力中の文字列に基づいて、それを前方一致するすべての候補を返すオートコンプリート機能を実装する。
	 *
	 * - 単語の挿入と削除（Insert and Delete Words） - 文字列の集合に対して、単語を動的に追加・削除する機能が必要な場合。
	 *
	 * - 前方一致を使ったカウント（Count Words Starting with a Prefix） -
	 * 与えられた接頭辞で始まる単語の数を数える必要がある場合。
	 *
	 * - ワイルドカード検索（Word Search with Wildcards） - 文字列中に**ワイルドカード文字（例えば
	 * .）**が含まれている場合、それを任意の文字と一致させて検索する。
	 *
	 * - 文字列集合から最も長い接頭辞を見つける（Longest Common Prefix） - 与えられた文字列の集合から最も長い共通接頭辞を見つける。
	 */

	/**
	 * トライ木のノード
	 */
	static class TrieNode {
		TrieNode[] children = new TrieNode[26];
		boolean isEndOfWord;

		TrieNode() {
			isEndOfWord = false;
			for (int i = 0; i < 26; i++)
				children[i] = null;
		}
	}

	/**
	 * 最上部
	 */
	static TrieNode root;

	/**
	 * 単語の挿入
	 * 
	 * @param key
	 */
	public static void insert(String key) {
		int level;
		int length = key.length();
		int index;

		TrieNode pCrawl = root;

		for (level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';
			if (pCrawl.children[index] == null)
				pCrawl.children[index] = new TrieNode();

			pCrawl = pCrawl.children[index];
		}

		// 終端ノードをマーク
		pCrawl.isEndOfWord = true;
	}

	/**
	 * 単語の検索
	 * 
	 * @param key
	 * @return
	 */
	public static boolean search(String key) {
		int level;
		int length = key.length();
		int index;
		TrieNode pCrawl = root;

		for (level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';

			if (pCrawl.children[index] == null)
				return false;

			pCrawl = pCrawl.children[index];
		}

		return (pCrawl != null && pCrawl.isEndOfWord);
	}

	/**
	 * main関数
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		String[] keys = { "the", "a", "there", "answer", "any", "by", "bye", "their" };

		root = new TrieNode();

		// トライ木に単語を挿入
		for (int i = 0; i < keys.length; i++)
			insert(keys[i]);

		// 検索テスト
		if (search("the"))
			System.out.println("単語 'the' は存在します。");
		else
			System.out.println("単語 'the' は存在しません。");

		if (search("these"))
			System.out.println("単語 'these' は存在します。");
		else
			System.out.println("単語 'these' は存在しません。");
	}
}
