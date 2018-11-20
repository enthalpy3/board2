package file;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

public class FileDao extends CommonDao {

	/*
	 * 파일 업로드
	 */
	public int uploadFile(String fileName, String fileReal) {
		String query = "INSERT INTO file VALUES(?,?,?,0)";
		PreparedStatement pstmt = null;
		int res = 0;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, fileName);
			pstmt.setString(2, fileReal);
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			pstmt.setTimestamp(4, ts);
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}

	public int hit(String fileReal) {
		String query = "UPDATE file SET downloadCount = downloadcount + 1 " + "WHERE fileReal = ?";
		PreparedStatement pstmt = null;
		int res = 0;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, fileReal);
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}

	// 업로드된 파일 리스트 형식으로 만든다.
	public ArrayList<FileDTOInfo> getList(){
		String query = "SELECT * FROM FILE";
		ArrayList<FileDTOInfo> list = new ArrayList<FileDTOInfo>();
		PreparedStatement pstmt = null;
		int res = 0;
		openConnection();;
		try {
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			res = pstmt.executeUpdate();
			while(rs.next()) {
				FileDTOInfo file = new FileDTOInfo(rs.getString(1), rs.getString(2), rs.getInt(4));
				list.add(file);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
