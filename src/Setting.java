import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Setting {
	// 全トランプ
	public static String[] trumpsAll;

	public static void opening() {
		// オープニング表示
		System.out.println("==========================================");
		System.out.println("                                トランプの ﾊﾞﾊﾞ抜きゲーム");
		System.out.println("                                   ＊コンピューター対戦＊");
		System.out.println("==========================================");
	}

	/** エンディング */
	public static void ending(boolean playerWin) {
	    System.out.println("        ゲーム終了");
	    if (playerWin) {
	    	System.out.println("============================");
	        System.out.println("    おめでとうございます");
	        System.out.println("    あなたの勝ちです");
	        System.out.println("============================");
	    } else {
	    	System.out.println("============================");
	        System.out.println("    残念");
	        System.out.println("    あなたの負けです");
	        System.out.println("============================");
	    }
	}

	public static String[] makeTrumps() {
		List<String> trumps = new ArrayList<>(Arrays.asList(
				"♠ A", "♠ 2", "♠ 3", "♠ 4", "♠ 5", "♠ 6",
				"♠ 7", "♠ 8", "♠ 9", "♠ 10", "♠ J", "♠ Q", "♠ K",
				"♢ A", "♢ 2", "♢ 3", "♢ 4", "♢ 5", "♢ 6", "♢ 7",
				"♢ 8", "♢ 9", "♢ 10", "♢ J", "♢ Q", "♢ K",
				"♣ A", "♣ 2", "♣ 3", "♣ 4", "♣ 5", "♣ 6", "♣ 7",
				"♣ 8", "♣ 9", "♣ 10", "♣ J", "♣ Q", "♣ K",
				"♡ A", "♡ 2", "♡ 3", "♡ 4", "♡ 5", "♡ 6", "♡ 7",
				"♡ 8", "♡ 9", "♡ 10", "♡ J", "♡ Q", "♡ K",
				"Joker"));

		// シャッフルする前の確認用表示
		//printArray(trumps, "No Shuffle");
		// シャッフル1回目の確認用表示
		Collections.shuffle(trumps);
		//ArrayListをString配列に変換する
		String[] trumpsAll = trumps.toArray(new String[0]);
		return trumpsAll;

	}

	// 53枚のトランプを用意してシャッフルする
	public static void setTrumps() {
		// トランプを生成する
		trumpsAll = makeTrumps();
		// トランプを配る
		Method.distribute(trumpsAll);
		// 表示する
		System.out.println("       ＊トランプを配ります ＊");

		// エンター待ち
		System.out.println("                          　　　　                 PUSH ENTER");
		Method.enter();

		// 配った手札を表示
		PrintSystem.showPlayer(MainGame.player);
		PrintSystem.showCom(MainGame.com);

		// エンター待ち
		System.out.println("                          　　　　                 PUSH ENTER");
		Method.enter();

		// コンピューターが二枚揃っているトランプを判定
		System.out.println("");
		System.out.println("相手のトランプ　　ペアーを捨てます");
		System.out.println("");

		// コンピューターが二枚揃っているトランプをnullに変換
		Method.discardPair(MainGame.com);

		// エンター待ち
		System.out.println("                          　　　　                 PUSH ENTER");
		Method.enter();


		// 配列にトランプを入れる
		MainGame.com =Method.adjust(MainGame.com);//  javaの参照が理由で戻り値が必要
		System.out.println("");
		// resultの中身を見る
		System.out.println("    相手の残りのトランプは、" + Method.getSize(MainGame.com) + "　枚です");

		// エンター待ち
		System.out.println("                          　　　　                 PUSH ENTER");
		Method.enter();

		// プレイヤーが二枚揃っているトランプを判定
		System.out.println("");
		System.out.println("あなたのトランプ　　ペアーを捨てます");
		System.out.println("");
		// ペアーをnullに変換
		Method.discardPair(MainGame.player);
		// nullを省いて元に戻す
		MainGame.player = Method.adjust(MainGame.player);//  javaの参照が理由で戻り値が必要

		// エンター待ち
		System.out.println("                          　　　　                 PUSH ENTER");
		Method.enter();

		// resultの中身を見る
		System.out.println("    あなたの手札　" + Method.getSize(MainGame.player) + "　枚");
		// プレイヤーの表示
		System.out.println("-----------------------------------------");
		Method.sort(MainGame.player);
		PrintSystem.showArr(MainGame.player);
		System.out.println("-----------------------------------------");
		// 配列にトランプを入れる
		MainGame.player = Method.adjust(MainGame.player);//  javaの参照が理由で戻り値が必要
		System.out.println();
		// コンピューターの手持ち枚数を表示
		System.out.println("    相手の手札   "+ Method.getSize(MainGame.com) + "　枚");
		// コンピューターの手札背面表示
		System.out.println("----------------------------------------");
		PrintSystem.showListInvisible(MainGame.com);
		System.out.println("----------------------------------------");
	}


}
