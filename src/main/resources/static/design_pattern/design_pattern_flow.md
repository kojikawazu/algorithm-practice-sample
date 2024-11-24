# フローチャートのステップ:

## 目的は何ですか？

- オブジェクトの生成を管理する → 生成に関するパターン（Creational Patterns）を使用
- オブジェクト間の関係や構造を整理する → 構造に関するパターン（Structural Patterns）を使用
- オブジェクトの動作や振る舞いを管理する → 振る舞いに関するパターン（Behavioral Patterns）を使用

## 1. 生成に関するパターン（Creational Patterns）

### どのようにオブジェクトを生成したいですか？

- オブジェクト生成プロセスを抽象化して柔軟にしたい → Factory Method パターン
- オブジェクトの生成過程を段階的にカスタマイズしたい → Builder パターン
- オブジェクトの生成に多様性を持たせ、特定のクラスを隠したい → Abstract Factory パターン
- インスタンスが一つであることを保証したい → Singleton パターン
- プロトタイプからインスタンスを複製したい → Prototype パターン

## 2. 構造に関するパターン（Structural Patterns）

### どのようにクラスやオブジェクトを組み合わせますか？

- 複数のオブジェクトをツリー構造で扱いたい → Composite パターン
- 異なるインターフェースを持つクラスをつなげたい → Adapter パターン
- オブジェクト同士の依存関係を減らしたい → Facade パターン
- オブジェクトを効率的に共有したい → Flyweight パターン
- 複数のインターフェースを一つにまとめたい → Facade パターン
- 機能を動的に追加・削除したい → Decorator パターン

## 3. 振る舞いに関するパターン（Behavioral Patterns）

### オブジェクトの振る舞いをどのように管理しますか？

- オブジェクトの状態に応じて振る舞いを変えたい → State パターン
- あるオブジェクトが他のオブジェクトにイベントを通知したい → Observer パターン
- 操作の順序を定義しつつサブクラスに詳細を任せたい → Template Method パターン
- 複数のオブジェクトにリクエストを渡したい → Chain of Responsibility パターン
- オブジェクト間の複雑な通信を整理したい → Mediator パターン
- 繰り返し処理を統一的に扱いたい → Iterator パターン
- 振る舞いを遅延させる、もしくは一度にまとめて実行したい → Command パターン
- 操作を取り消したい → Memento パターン

## フローチャートで考慮する代表的なデザインパターン:

- 生成に関するパターン（Creational Patterns）: Singleton, Factory Method, Builder
- 構造に関するパターン（Structural Patterns）: Adapter, Composite, Decorator, Facade, Flyweight
- 振る舞いに関するパターン（Behavioral Patterns）: Strategy, Observer, Command, State, Iterator
