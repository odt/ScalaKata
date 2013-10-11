# participants

オリジナルお題です。

次のようなリストが与えられたとき、各日の参加者のリストを作りなさい。
(`find . -maxdepth 2 -mindepth 2 | grep -v .git | grep -v README.md | sort` で生成。フォーマットエラーは考慮する必要なし)

    ./13_10_08_KarateChop/234furuya
    ./13_10_08_KarateChop/akausagi
    ./13_10_08_KarateChop/cohei
    ./13_10_08_KarateChop/joker1007
    ./13_10_08_KarateChop/naga41
    ./13_10_08_KarateChop/saturday06
    ./13_10_09_next_palindrome/cohei
    ./13_10_09_next_palindrome/joker1007

## 期待する動作

    val participants = new Participants(fileList) // fileList は上の文字列
    participants.onDate(Date(2013,10,9)) should equal ("cohei", "joker1007")

Date は java.util.Date をつかっても、 jodatime 等をつかっても、自分で case class を書いてもいいです。
上は case class を想定。

## オプション1

時間があまった人用。

日 => 参加者の Map を作ってください。

## オプション2

過去の全参加者を参考に、ある日に参加していない人をリストしてください。

## オプション3

名前にエイリアスを登録できるようにしてください。
alias は別のオブジェクトとして構成し、コンストラクタに渡す形でもいいです。

```scala
participants.alias("tomy", "tomykaira") // tomy という名前の参加者は tomykaira として扱われる
```

## オプション4

フォーマットエラーに対応してください。
エラーがあったら、どこがおかしいかをわかりやすく通知してください。

## オプション5

時間があまって暇でしょうがない人用。

結果をもとに、このリポジトリの wiki を自動更新するプログラムを作成してください。
