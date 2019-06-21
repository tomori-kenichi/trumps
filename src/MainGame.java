 import java.util.Scanner;

public class MainGame {

	/** プレイヤーの配列手札宣言 */
	public static String[] player = new String[27];
	/** コンピューターの配列手相宣言 */
	public static String[] com = new String[27];
	/** あなたの入力した数 */
	public static int playerNum;
	  /** カードを引き合うゲームメイン部分 */
    public static boolean gameMain() {
        while (true) {
            playerGame02();
            if (MainGame.player.length == 0) {
                return true;
            }
            computerGame();
            if (MainGame.com.length == 0) {
                return false;
            }
        }
    }

	/** プレイヤーがコンピューターからトランプを取る */
	public static void playerGame() {
		System.out.println();
		System.out.println("あなたの番です");
		System.out.println("                             カードを一枚取ってください");
		int playerNum = new Scanner(System.in).nextInt();
		// 入力した数のトランプをコンピューターから一枚取得
		String cardPull = Method.oneCardPull(MainGame.com, playerNum);
		// 取得したコンピューターのトランプをプレイヤーの配列に代入
		MainGame.player = Method.mixArray(MainGame.player, cardPull);
		// 二枚手札が揃っていれば捨てる
		System.out.println("");
		System.out.print("  ペアーを捨てます　");
		Method.discardPair(MainGame.player);
		System.out.println("");
		MainGame.player = Method.adjust(MainGame.player);//  javaの参照が理由で戻り値が必要
		System.out.println("");
		System.out.println("あなたの手札");
		// プレイヤーのトランプの全絵柄番号を表示
		Method.adjust(MainGame.player);
		// 配列を表示
		System.out.println("---------------------------------------------------");
		Method.sort(player);
		PrintSystem.showArr(MainGame.player);
		System.out.println("---------------------------------------------------");
		System.out.println("                                                   PUSH ENTER");
		Method.enter();
	}

	/** プレイヤーがコンピューターからトランプを取る */
	public static void playerGame02() {
		System.out.println();
		System.out.println("あなたの番です");
		System.out.println("                             カードを一枚取ってください");

		int playerNum;
		while (true) {
			playerNum = new Scanner(System.in).nextInt();
			if(0 < playerNum && playerNum <= com.length) {
				break;
			}else {
				System.out.println("そんなカードはありません");
				System.out.println("                            カードを一枚取ってください");
			}
		}

		// 入力した数のトランプをコンピューターから一枚取得
		String cardPull = Method.oneCardPull(MainGame.com, playerNum);
		// 取得したコンピューターのトランプをプレイヤーの配列に代入
		MainGame.player = Method.mixArray(MainGame.player, cardPull);
		// 二枚手札が揃っていれば捨てる
		System.out.println("");
		System.out.print("  ペアーを捨てます　");
		Method.discardPair(MainGame.player);
		System.out.println("");
		MainGame.player = Method.adjust(MainGame.player);//  javaの参照が理由で戻り値が必要
		System.out.println("");
		System.out.println("あなたの手札");
		// プレイヤーのトランプの全絵柄番号を表示
		Method.adjust(MainGame.player);
		// 配列を表示
		System.out.println("---------------------------------------------------");
		Method.sort(player);
		PrintSystem.showArr(MainGame.player);
		System.out.println("---------------------------------------------------");
		System.out.println("                                                   PUSH ENTER");
		Method.enter();
	}

	/** コンピューターがプレイヤーからトランプを取る */
	public static void computerGame() {
		System.out.println();
		System.out.println("　相手の番です");
		System.out.println();
		// コンピューターが数を入力
		int comNum = Method.randamPull(MainGame.player);
		// 入力した数のトランプをプレイヤーから取得
		System.out.print("    相手が");
		String cardPull = Method.oneCardPull(MainGame.player, comNum);
		MainGame.com = Method.adjust(MainGame.com);
		// 取得したプレイヤーのトランプをコンピューターの配列に代入
		MainGame.com = Method.mixArray(MainGame.com, cardPull);
		// 二枚手札が揃っていれば捨てる
		System.out.println("");
		System.out.print("  ペアーを捨てます　");
		Method.discardPair(MainGame.com);
		System.out.println("");
		MainGame.com = Method.adjust(MainGame.com);//  javaの参照が理由で戻り値が必要
		System.out.println("");
		System.out.println("　相手の手札");
		// コンピューターのトランプの全絵柄番号を表示
		Method.adjust(MainGame.com);
		// コンピューターのトランプをシャッフルします
		MainGame.com = Method.shuffle(MainGame.com);
		// 配列を表示
		System.out.println("-----------------------------------------------------");
		Method.sort(com);
		PrintSystem.showListInvisible(com);
		System.out.println("-----------------------------------------------------");

	}

}
