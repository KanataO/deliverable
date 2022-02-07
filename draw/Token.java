package draw;

/**
 * Tokenクラスは「ガチャチケット」を表します。
 * このクラスのインスタンスは枚数をその属性として持ち、それを操作するメソッドを提供します。
 * @author C0119054
 *
 */
public class Token {
	/** 枚数*/
	private int token;

	/**
	 * ガチャチケットのインスタンスを生成します。
	 * ただし、枚数の設定は行いません。
	 * 使わないでください。
	 * @deprecated
	 */
	public Token() {
	}

	/**
	 * 枚数を持つガチャチケットのインスタンスを生成します。
	 * @param token 枚数
	 */
	public Token(int token) {
		this.token = token;
	}

	/**
	 * このインスタンスが持つ枚数を返します。
	 * @return 枚数
	 */
	public int getToken() {
		return this.token;
	}

	/**
	 * このインスタンスの枚数を変更します。
	 * @param token 枚数
	 */
	public void setToken(int token) {
		if (token < 0) {
			token = 0;
		}
		this.token = token;
	}

}
