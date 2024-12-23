# アルゴリズム選択のフローチャート例

1. データのタイプを確認する

- 配列？
  - はい → 2へ
  - いいえ（例えばグラフや木構造）→ 3へ

2. 配列の操作を確認する

- 部分合計や部分問題を扱う？
  - 連続する部分問題 → **「スライディングウィンドウ法」**を検討 → 終了
  - 連続しない組み合わせ → **「ハッシュマップ」**を検討 → 終了
  - 部分問題が最適解を求める場合 → **「動的計画法 (DP)」**を検討 → 終了
  - いいえ → 次へ

- 特定の値を探す？
  - ソートされている → **「二分探索」**を検討 → 終了
  - ソートされていない→
   - 要素の数が少ない場合（小さいデータセット） → **「線形探索」**を検討 → 終了
   - 要素の数が多く、頻繁な検索が必要な場合 → **「ハッシュマップ」**を検討 → 終了
  - いいえ → 次へ

- 最大・最小の値を求める？
  - 例えば k 番目に大きい要素を求める →
   - 配列のサイズが大きく、効率的に選びたい場合 → **「最小ヒープ」**を検討 → 終了
   - クイックに選びたい場合（特に平均的に高速な処理を求める場合） → **「クイックセレクト」**を検討 → 終了
  - 最大の1つまたは複数の要素を求める → **「線形探索」**を検討 → 終了
  - いいえ → 次へ

- 配列をソートする？
  - サイズが大きい →
   - 安定なソートが必要な場合 → **「マージソート」**を検討 → 終了
   - 平均的に高速なソートを求める場合 → **「クイックソート」**を検討 → 終了
  - サイズが小さい →
   - 配列の順序がある程度整っている場合 → **「挿入ソート」**を検討 → 終了
   - 配列が無作為な順序で、シンプルな実装を好む場合 → **「選択ソート」**を検討 → 終了
   - 配列がほとんど整っており、シンプルな比較が適している場合 → **「バブルソート」**を検討 → 終了
  - いいえ → 次へ

- 増加部分列の長さや最適な部分構造を持つ問題か？
  - はい → **「動的計画法 (DP)」**を検討 → 終了
  - いいえ → 次へ

- 部分集合を求めたい？
  - 部分問題が存在し、最適解を求める（例：ナップサック問題）→ **「動的計画法 (DP)」**を検討 → 終了
  - 単純に部分集合を列挙したい（例：全ての部分集合の列挙） → **「バックトラッキング」**を検討 → 終了
  - いいえ → 3へ進む

3. データ構造が木やグラフか確認する

- 木構造？
  - はい → 4へ
  - いいえ（グラフ構造）→ 5へ

4. 木構造の操作を確認する

- 最大深さや特定のノードの深さを求める？
  - はい → **「深さ優先探索 (DFS)」**を検討 → 終了
  - いいえ → 次へ

- 幅優先でノードを列挙したい？
  - はい → **「幅優先探索 (BFS)」**を検討 → 終了
  - いいえ → 次へ

- 木を平衡に保ちたい？
  - はい →
   - 検索が頻繁で、挿入・削除の頻度がそれほど高くない場合 → **「AVLツリー」**を検討 → 終了
   - 挿入・削除の操作が多く、全体的なバランスを重視する場合 → **「Red-Black Tree」**を検討 → 終了
  - いいえ → 次へ

- ソートされたデータを木にしたい？
  - はい → **「バランスの取れた二分探索木を再帰的に構築」**を検討 → 終了
  - 平衡な木構造が必要 →
   - 検索速度が重要で、挿入や削除の頻度が少ない場合 → **「AVLツリー」**を検討 → 終了
   - 挿入や削除の頻度が高い場合 → **「Red-Black Tree」**を検討 → 終了
  - いいえ → 次へ

- 葉ノードの深さがすべて同じか確認したい？
  - はい →
   - 木のすべてのノードを一度に探索したい場合 → **「深さ優先探索 (DFS)」**を検討 → 終了
   - 最短経路で葉ノードまでの深さを確認したい場合 → **「幅優先探索 (BFS)」**を検討 → 終了
  - いいえ → 5へ

5. グラフ構造の操作を確認する

- 2つのノード間の接続を確認する？
  - はい →
   - 最短経路で接続を確認したい場合 → **「幅優先探索 (BFS)」**を検討 → 終了
   - 特定のルートを深く探索しながら確認したい場合 → **「深さ優先探索 (DFS)」**を検討 → 終了
  - いいえ → 次へ

- 最短経路を求める？
  - 重み付きグラフ →
   - 負の重みがない場合 → **「ダイクストラ法」**を検討 → 終了
   - 負の重みがある場合 → **「ベルマンフォード法」**を検討 → 終了
  - 無向グラフで全体の最小コストを求めたい → **「クラスカル法」**を検討 → 終了
  - いいえ → 次へ

- 全てのノードを訪問する最短経路を求める（TSP問題）？
  - ノード数が少ない → **「動的計画法 (DP) とビットマスク」**を検討 （ビットマスクは効率的にサブセットを管理するための手法） → 終了
  - ノード数が多い → **「分枝限定法」**を検討 → 終了
  - いいえ → 次へ

- サイクルを検出したい？
  - はい → **「深さ優先探索 (DFS)」**を検討 → 終了
  - いいえ → 6へ

6. 動的計画法の必要性を確認する

- 最適な部分構造を持つ問題か？（部分問題の解決を使って全体を解く）
  - はい → **「動的計画法 (DP)」**を検討 → 終了
  - いいえ → 次へ

- 部分集合を求めたい？
  - はい → **「バックトラッキング」**を検討 → 終了
  - いいえ → 終了