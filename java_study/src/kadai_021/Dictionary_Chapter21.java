package kadai_021;

import java.util.HashMap;

public class Dictionary_Chapter21 {

	HashMap<String, String> map = new HashMap<String, String>();

	public void tuika() {

		map.put("apple", "りんご");
		map.put("peach", "桃");
		map.put("banana", "バナナ");
		map.put("lemon", "レモン");
		map.put("pear", "梨");
		map.put("kiwi", "キウィ");
		map.put("strawberry", "いちご");
		map.put("grape", "ぶどう");
		map.put("muscat", "マスカット");
		map.put("cherry", "さくらんぼ");
	}

	public void seach(String word) {
		if (map.get(word) == null) {
			System.out.println(word + "は辞書に存在しません");
		} else {
			System.out.println(word + "の意味は" + map.get(word));
		}
	}

}
