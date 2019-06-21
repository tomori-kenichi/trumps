import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Method {


	/** ランダムな数を取得 */
	public static int randamPull(String[] array) {
		return (int)(Math.random() * getSize(array) + 1);
	}

	/** 配列から一枚カードを引く */
	public static String oneCardPull02(String[] array, int number) {
		String card = null;
		int index =  number - 1;
			while(0 <= index && index < array.length) {
				if(0 > index && index > array.length) {
					card = array[index];
					System.out.println("   引いたカードは " + array[index]);
					array[index] = null;
					continue;
				}
			}

			System.out.println("   そんなカードはありません。");
			return card;
	}

	/** 配列から一枚カードを引く */
	public static String oneCardPull(String[] array, int number) {
		String card = null;
		int index =  number - 1;
		if(0 <= index && index < array.length) {
			card = array[index];
			System.out.println("   引いたカードは " + array[index]);
			array[index] = null;
		}else {
			System.out.println("   そんなカードはありません。");
		}
		return card;
	}

	/* コンピューター(または、プレイヤー)から引いてきたトランプを
	 * プレイヤー(または、コンピューター)の手札に入れるメソッド
	 */
	public static String[] mixArray(String[] array, String cardPull) {
		String[] mixArray = new String[array.length + 1];
		for (int i = 0; i < array.length; i++) {
			mixArray[i] = array[i];
			mixArray[mixArray.length - 1] = cardPull;
		}
		return mixArray;
	}

	/** 配列の同じ文字をnullにするメソッド */
	public static void discardPair(String[] comOrPlayer) {//   捨てる　ペアー
		for (int i = 0; i < comOrPlayer.length; i++) {
			for (int j = i + 1; j < comOrPlayer.length; j++) {
				if (null == comOrPlayer[i]) {
					break;
				}
				if (null == comOrPlayer[j]) {
					continue;
				}
				// 末尾番号のトランプのペアーをnullに変換
				if (strEndNum(comOrPlayer[i]).equals(strEndNum(comOrPlayer[j]))) {
					System.out.println("    　　" + comOrPlayer[i] + " と " + comOrPlayer[j]);
					comOrPlayer[i] = null;
					comOrPlayer[j] = null;
				}
			}
		}
	}

	/** ソート */
	public static void sort(String[] trump) {
		for (int i = 0; i < trump.length; i++) {
			for (int j = i; j < trump.length; j++) {
				String iEndNum = strEndNum(trump[i]);
				int iNum = rankToNumber(iEndNum);
				String jEndNum = strEndNum(trump[j]);
				int jNum = rankToNumber(jEndNum);
				if(iNum > jNum) {
					String tmp = trump[i];
					trump[i] = trump[j];
					trump[j] = tmp;
				}
			}
		}
	}

	/** ランクを数字に変換 */
	public static int rankToNumber(String rank) {
		switch (rank) {
		case "A":
			return 1;
		case "0":
			return 10;
		case "J":
			return 11;
		case "Q":
			return 12;
		case "K":
			return 13;
		case "r":
			return 14;
		default:
			return Integer.parseInt(rank);
		}
	}


	/** トランプカードの末尾番号を識別するメソッド */
	public static String strEndNum(String s) {//  末尾番号
		return s.substring(s.length() - 1);// 識別を始める文字
	}

	/** nullを省いて配列を詰めた新しい配列を返すメソッド */
	public static String[] adjust(String[] arr) {//   abujust == 調節します
		int size = getSize(arr);
		String[] result = new String[size];//    result == 結果
		int index = 0;
		for (String s : arr) {
			if (null != s) {
				result[index] = s;
				index += 1;
			}
		}
		return result;
	}

	/** nullを省いた要素の数を取得するメソッド */
	public static int getSize(String[] arr) {
		int size = 0;
		for (String s : arr) {
			if (null != s) {
				size += 1;
			}
		}
		return size;
	}

	/** トランプをプレイヤーとコンピューターに配る */
	public static void distribute(String[] trumpAll) {//   配る
		int p = 0;// プレイヤー配列のindex番号
		int c = 0;// コンピューター配列のindex番号
		for (int i = 0; i < trumpAll.length; i++) {
			if (i % 2 == 0) {//   偶数をプレイヤーに配る
				MainGame.player[p] = trumpAll[i];
				p++;
			} else {
				// コンピューターに配られたトランプ
				MainGame.com[c] = trumpAll[i]; //  奇数をコンピューターに配る
				c++;
			}
		}
	}

	/** 配列をシャッフルした新しい配列を返す */
    public static String[] shuffle(String[] arr) {
        List<String> list = Arrays.asList(arr);
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }


	/** enter待ち */
	public static void enter() {
		// Scanner使った方
		new Scanner(System.in).nextLine();
	}
}
