package kadai_010;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Scores_Chapter10 {

	public static void main(String[] args) {

		Connection con = null;
		Statement statement = null;

		try {
			//データベース接続
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/challenge_java",
					"root",
					"masadevi1218");

			System.out.println("データベース接続成功:" + con.toString());

			//SQLクエリの準備
			statement = con.createStatement();
			String sqlu = "UPDATE scores SET score_math = 95, score_english = 80 WHERE id = 5;";

			String sqls = "SELECT * FROM scores ORDER BY score_math DESC, score_english DESC;";

			//SQLクエリを実行(レコードの更新)
			System.out.println("レコード更新を実行します");
			int rowCnt = statement.executeUpdate(sqlu);
			System.out.println(rowCnt + "件のレコードが更新されました");

			//SQLクエリの実行(取得したデータの並び替え)
			System.out.println("数学・英語の点数が高い順に並べ替えました");
			ResultSet result = statement.executeQuery(sqls);

			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				int math = result.getInt("score_math");
				int english = result.getInt("score_english");
				System.out.println(result.getRow() + "件目ID:=" + id + "/氏名=" + name + "/数学=" + math + "/英語=" + english);
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
