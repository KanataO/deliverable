package draw;

/**
 * NegativeNumberExceptionクラスは、Boxのボックスナンバーに0以下の数字が入力されたときに表示するメッセージを表します。
 * @author C0119054
 *
 */
public class NegativeNumberException extends Exception {

	public NegativeNumberException(String message) {
		super(message);
	}

}
