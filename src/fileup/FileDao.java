package fileup;



import java.sql.PreparedStatement;
import java.sql.Timestamp;

public class FileDao extends CommonDao {



	/*
	 * 파일 업로드
	 */
	public int uploadFile(String fileName, String fileReal) {
		String query = "INSERT INTO fileup VALUES(?,?,?)";
		PreparedStatement pstmt = null;
		int res = 0;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, fileName);
			pstmt.setString(2, fileReal);
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			pstmt.setTimestamp(3, ts);
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}

	/*
	 * 파일 삭제
	 */
	public int removeMember(String id) {
		PreparedStatement pstmt = null;
		String query = "DELETE FROM member WHERE id=?";
		int res = 0;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}
}
