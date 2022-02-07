package draw;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.function.IntFunction;

/**
 * Tokencalcクラスは「ボックスガチャ計算機」を表します。
 * Boxクラス、Scheduleクラス、Tokenクラスを用いて、目標達成に必要なガチャチケットの枚数や周回回数の目安を計算するmainメソッドを提供します。
 * @see Box
 * @see Schedule
 * @see Token
 * @author C0119054
 *
 */
public class Tokencalc {

	/**
	 * キーボード入力で受け取った条件を元に、計算結果をコンソールに表示します。
	 * Suchedule()の引数に、自分が参加する予定のイベントの一日目の日付を入力してください。
	 * @param args mainメソッドを動かすための変数
	 * @throws Exception 入力されたボックスナンバーが0以下であった時、エラー文が表示されます。
	 * @see NegativeNumberException
	 */
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("目標箱数を入力");
		int target = scanner.nextInt();
		Box bf = new Box(target);
		System.out.println(bf);

		Schedule light2204 = new Schedule(2022, 4, 21);
		DateFormat df = new SimpleDateFormat("yyyy年MM月dd日(E)");
		int fullday = 1000 * 60 * 60 * 24;
		long todaydiffer = light2204.getTodaydiffer();
		long day1differ = light2204.getDay1differ();
		long prediffer = light2204.getPrediffer();
		long interdiffer = light2204.getInterdiffer();
		long mbdiffer = light2204.getMBdiffer();
		long bystart = (day1differ - todaydiffer) / fullday;
		long bypreliminary = (prediffer - todaydiffer) / fullday + 1;
		long byinterval = (interdiffer - todaydiffer) / fullday + 1;
		long bymain = (mbdiffer - todaydiffer) / fullday + 1;

		if (bystart > 0 || bymain <= 0) {
			if (bystart > 0) {
				System.out.println("次の古戦場は" + df.format(light2204.getDay1()) + "から！！");
				System.out.println("装備を整えて準備しよう");
			} else {
				System.out.println("古戦場お疲れ様でした！次回も目標達成しよう！");
			}
			System.out.println("次回はいつまでに終わらせる？｜該当する数字を入力");
			System.out.println("予選終了まで:0｜インターバル終了まで:1｜本戦終了まで:2");
			int deadline = scanner.nextInt();
			if (deadline == 0) {
				System.out.println("1日あたり" + (int) Math.ceil(bf.sumToken() / 2) + "枚 : "
						+ (int) Math.ceil((bf.sumToken() / 66) / 2) + "回");
			} else if (deadline == 1) {
				System.out.println("1日あたり" + (int) Math.ceil(bf.sumToken() / 3) + "枚 : "
						+ (int) Math.ceil((bf.sumToken() / 66) / 3) + "回");
			} else if (deadline == 2) {
				System.out.println("1日あたり" + (int) Math.ceil(bf.sumToken() / 7) + "枚 : "
						+ (int) Math.ceil((bf.sumToken() / 66) / 7) + "回");
			} else {
				System.out.println("0・1・2の内どれかを入力してください");
			}
			scanner.close();
			System.exit(0);
		} else {

			System.out.println("現在の戦貨数を入力");

			int now = scanner.nextInt();

			IntFunction<Integer> remainder = sum -> sum - now;

			int rest = (int) remainder.apply(bf.sumToken());
			int repeat = (int) Math.ceil(rest / 66);

			if (rest <= 0) {
				System.out.println("周回完了！！");
			} else {
				System.out.println("残り" + rest + "枚 : 後" + repeat + "回で周回完了！！");
			}

			System.out.println("いつまでに終わらせる？｜該当する数字を入力");
			System.out.println("予選終了まで:0｜インターバル終了まで:1｜本戦終了まで:2");

			int deadline = scanner.nextInt();

			if (deadline == 0) {
				if (bypreliminary <= 0) {
					System.out.println("目標時間過ぎてますので頑張って周回してください");
				} else {
					System.out.println("1日あたり" + (int) Math.ceil(rest / bypreliminary) + "枚 : "
							+ (int) Math.ceil(repeat / bypreliminary) + "回");
				}
			} else if (deadline == 1) {
				if (byinterval <= 0) {
					System.out.println("目標時間過ぎてますので頑張って周回してください");
				} else {
					System.out.println("1日あたり" + (int) Math.ceil(rest / byinterval) + "枚 : "
							+ (int) Math.ceil(repeat / byinterval) + "回");
				}
			} else if (deadline == 2) {
				System.out.println("1日あたり" + (int) Math.ceil(rest / bymain) + "枚 : "
						+ (int) Math.ceil(repeat / bymain) + "回");
			} else {
				System.out.println("0・1・2の内どれかを入力してください");
			}
			scanner.close();
		}

	}

}
