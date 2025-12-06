/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author LENOVO
 */
import Model.PTPackage;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PTPackageDAO {

    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=Gym;encrypt=false;";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "12345@";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    // Lấy toàn bộ gói PT (có thể lọc theo sta nếu muốn)
    public List<PTPackage> getAllPTPackages() {
        List<PTPackage> list = new ArrayList<>();
        String sql = "SELECT packageId, packageName, packageDuration, packagePrice, " +
                     "description, trainerId, sta FROM PTPackages";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                PTPackage pkg = new PTPackage();
                pkg.setPackageId(rs.getString("packageId"));
                pkg.setPackageName(rs.getString("packageName"));
                pkg.setPackageDuration(rs.getInt("packageDuration"));
                pkg.setPackagePrice(rs.getDouble("packagePrice"));
                pkg.setDescription(rs.getString("description"));
                pkg.setTrainerId(rs.getString("trainerId"));
                pkg.setSta(rs.getInt("sta"));

                list.add(pkg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Lấy 1 gói PT theo id
    public PTPackage getPTPackageById(String packageId) {
        String sql = "SELECT packageId, packageName, packageDuration, packagePrice, " +
                     "description, trainerId, sta FROM PTPackages WHERE packageId = ?";
        PTPackage pkg = null;

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, packageId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pkg = new PTPackage();
                    pkg.setPackageId(rs.getString("packageId"));
                    pkg.setPackageName(rs.getString("packageName"));
                    pkg.setPackageDuration(rs.getInt("packageDuration"));
                    pkg.setPackagePrice(rs.getDouble("packagePrice"));
                    pkg.setDescription(rs.getString("description"));
                    pkg.setTrainerId(rs.getString("trainerId"));
                    pkg.setSta(rs.getInt("sta"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pkg;
    }

    // Thêm gói PT
    public boolean insertPTPackage(PTPackage pkg) {
        String sql = "INSERT INTO PTPackages " +
                     "(packageId, packageName, packageDuration, packagePrice, description, trainerId, sta) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, pkg.getPackageId());
            ps.setString(2, pkg.getPackageName());
            ps.setInt(3, pkg.getPackageDuration());
            ps.setDouble(4, pkg.getPackagePrice());
            ps.setString(5, pkg.getDescription());
            ps.setString(6, pkg.getTrainerId());
            ps.setInt(7, pkg.getSta());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Cập nhật gói PT
    public boolean updatePTPackage(PTPackage pkg) {
        String sql = "UPDATE PTPackages SET " +
                     "packageName = ?, packageDuration = ?, packagePrice = ?, " +
                     "description = ?, trainerId = ?, sta = ? " +
                     "WHERE packageId = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, pkg.getPackageName());
            ps.setInt(2, pkg.getPackageDuration());
            ps.setDouble(3, pkg.getPackagePrice());
            ps.setString(4, pkg.getDescription());
            ps.setString(5, pkg.getTrainerId());
            ps.setInt(6, pkg.getSta());
            ps.setString(7, pkg.getPackageId());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xoá mềm (set sta = 0)
    public boolean softDeletePTPackage(String packageId) {
        String sql = "UPDATE PTPackages SET sta = 0 WHERE packageId = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, packageId);
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xoá hẳn (nếu m thích chơi mạnh tay)
    public boolean deletePTPackage(String packageId) {
        String sql = "DELETE FROM PTPackages WHERE packageId = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, packageId);
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

