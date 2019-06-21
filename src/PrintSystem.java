
public class PrintSystem {

	/**
		 * プレイヤーとコンピューターの手札を表示
		 * コンピューターの手札は塗りつぶしてインデックスのみも表示
		 */
		public static void showPlayer(String[] player) {
			System.out.println();
			// コンピューターの手札を表示
			System.out.println("--------------------------------------------------");
			System.out.println("      相手の手札");
			MainGame.com = Method.adjust(MainGame.com);
			PrintSystem.showListInvisible5(MainGame.com);
			System.out.println("--------------------------------------------------");
		}

		public static void showCom(String[] com) {
			// プレイヤーの手札を表示
			System.out.println("--------------------------------------------------");
			System.out.println("      あなたの手札");
			MainGame.player = Method.adjust(MainGame.player);
			PrintSystem.showArray5(MainGame.player);
			System.out.println("--------------------------------------------------");
		}

	/** 配列を表示するメソッド */
	public static void showArr(String[] arr) {
		for (String s : arr) {
			System.out.print(s + " , ");
		}
		System.out.println();
	}

	/** 何枚目表示でリストを表示 */
	public static void showListInvisible(String[] computer) {
		for(int i = 0; i < computer.length; i++) {
			System.out.print((i + 1 )+ "枚目 , ");
		}
		System.out.println();
	}

	/** 何枚目表示でリストを表示（５枚目で改行）*/
	public static void showListInvisible5(String[] computer) {
		int count = 0;
		for (int i = 0; i < computer.length; i++) {
			if (i < 10) {
				System.out.print((i + 1 )+ "枚目 , ");
			} else {
				System.out.print((i + 1) + "枚目 , ");
			}
			count++;
			if (count % 5 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	/** 配列を5個ずつ横に並べて表示 */
	public static void showArray5(String[] s) {
		int count = 0; // 表示した回数
		// 配列を全表示していく
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i] + " , ");
			count += 1;
			// 5個表示してたら改行
			if (count % 5 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	  /** 配列の最後の要素ならコンマを付けず表示 */
    private static void printArray(int[] n) {
        for(int i = 0; i < n.length; i++) {
            if(i == n.length - 1) {
                System.out.println(n[i]);
            } else {
                System.out.print(n[i]+" , ");
            }
        }
    }
}
