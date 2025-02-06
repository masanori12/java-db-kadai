package kadai_018;

public abstract class Kato_Chapter18 {
	public String familyName = "加藤"; //性を表す
	public String givenName; //名を表す
	public String address = "東京都中野区◯×"; //住所を表す

	//共通の紹介を出力する
	public void commonintroduce() {
		System.out.println("名前は" + this.familyName + givenName + "です");
		System.out.println("住所は" + this.address + "です");
	}

	//個別の紹介を出力する
	public abstract void eachIntroduce();

	public void execIntroduce() {
		commonintroduce();
		eachIntroduce();
	}

}
