/**
 * トランプのﾊﾞﾊﾞ抜きゲームです
 * ルールは、トランプと同じです
 * カードの代わりに文字のみで表示します。
 * コンピュータ対戦のみです。
 */

public class Main {
	public static void main(String[] args){
		// オープニング表示
		Setting.opening();
		// カードの間配り等準備
		Setting.setTrumps();
		// カードを引き合うメイン部分
		boolean win = MainGame.gameMain();
		// エンディング表示
		Setting.ending(win);
	}
}
