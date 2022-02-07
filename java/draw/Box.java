package draw;

import java.util.ArrayList;
import java.util.List;

/**
 * Boxクラスはボックスガチャにおける「ボックス」を表します。
 * このクラスのインスタンスは何箱目のボックスガチャなのかを示すボックスナンバー、ガチャチケットのリストをその属性として持っています。
 * インスタンスを操作するメソッドを提供します。
 * @author C0119054
 *
 */

public class Box {
	/** ボックスナンバー*/
	private int num;
	/** ガチャチケットのリスト*/
	private List<Token> list;

	/**
	 * ボックスのインスタンスを生成します。
	 * ただし、ボックスナンバーの設定は行いません。
	 * 使わないでください。
	 * @deprecated
	 */
	public Box() {
	}

	/**
	 * ボックスナンバーを持つボックスのインスタンスを生成します。
	 * 1箱あたりのガチャチケットの枚数をボックスごとに設定し、ガチャチケットのリストを生成します。
	 * @param num ボックスナンバー
	 * @throws NegativeNumberException ボックスナンバーが0以下であった時、エラー文が表示されます。
	 */
	public Box(int num) throws NegativeNumberException {
		this.num = num;
		this.list = new ArrayList<>();
		if (num < 1) {
			String message = "1以上の整数を入力してください";
			throw new NegativeNumberException(message);
		} else {
			for (int i = 0; i < num; i++) {
				if (i == 0) {
					this.list.add(new Token(1600));
				} else if (0 < i && i < 4) {
					this.list.add(new Token(2400));
				} else if (4 <= i && i < 45) {
					this.list.add(new Token(2000));
				} else if (45 <= i && i < 80) {
					this.list.add(new Token(10000));
				} else {
					this.list.add(new Token(15000));
				}
			}
		}
	}

	/**
	 * このインスタンスが持つボックスナンバーを返します。
	 * @return ボックスナンバー
	 */
	public int getNum() {
		return this.num;
	}

	/**
	 * このインスタンスのボックスナンバーを変更します。
	 * @param num ボックスナンバー
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * このインスタンが持つガチャチケットのリストを返します。
	 * @return ガチャチケットのリスト
	 */
	public List<Token> getTokens() {
		return this.list;
	}

	/**
	 * このインスタンスのガチャチケットのリストを変更します。
	 * @param list ガチャチケットのリスト
	 */
	public void setTokens(List<Token> list) {
		this.list = list;
	}

	/**
	 * このインスタンスが持つガチャチケットのリストに格納されているガチャチケットの合計を返します。
	 * @return ガチャチケットの合計
	 */
	public int sumToken() {
		int total = 0;
		for (int i = 0; i < getNum(); i++) {
			total += this.list.get(i).getToken();
		}

		return total;
	}

	/**
	 * このインスタンスが持つボックスナンバー、全ガチャチケットの合計を適切な形でString型に変えて返します。
	 * @return String型で適切な形に整えたインスタンスが持つ値
	 */
	@Override
	public String toString() {
		return "目標 " + String.format("%n", "") + getNum() + "箱｜戦貨" + sumToken() + "枚";
	}

}
