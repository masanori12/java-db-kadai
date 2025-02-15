package kadai_007;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Posts_Chapter07 {

	public static void main(String[] args) {

		Connection con = null;
		Statement statement = null;

		try {
			//データベースに接続
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/challenge_java",
					"root",
					"masadevi1218");

			System.out.println("データベース接続成功:" + con.toString());

			//SQLクエリを準備
			statement = con.createStatement();
			String sqli = """
					INSERT INTO posts (user_id, posted_at, post_content, likes) VALUES
					(1003, '2023-02-08', '昨日の夜は徹夜でした・・', 13),
					(1002, '2023-02-08', 'お疲れ様です！', 12),
					(1003, '2023-02-09', '今日も頑張ります！', 18),
					(1001, '2023-02-09', '無理は禁物ですよ！', 17),
					(1002, '2023-02-10', '明日から連休ですね！', 20);
					""";

			String sqlq = "SELECT * FROM posts WHERE user_id = 1002;";

			//SQLクエリを実行(レコードを追加)
			System.out.println("レコード追加を実行します");
			int rowCnt = statement.executeUpdate(sqli);
			System.out.println(rowCnt + "件のレコードが追加されました");

			System.out.println("ユーザーIDが1002のレコードを検索しました");

			//SQLクエリを実行(レコードを検索)
			ResultSet result = statement.executeQuery(sqlq);

			//SQLクエリの実行結果を抽出
			while (result.next()) {
				Date postedAt = result.getDate("posted_at");
				String postContent = result.getString("post_content");
				int likes = result.getInt("likes");
				System.out
						.println(result.getRow() + "件目:投稿日時=" + postedAt + "/投稿内容=" + postContent + "/いいね数=" + likes);
			}

		} catch (SQLException e) {
			System.out.println("エラー発生:" + e.getMessage());
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}

	}

}
