package Test;

import util.DBConnection;
import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            System.out.println("✔ Kết nối thành công");
        } else {
            System.out.println("❌ Không thể kết nối");
        }
    }
}
