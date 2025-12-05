package DAO;

import Model.Member;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO implements GenericDAO<Member, String> {

    @Override
    public boolean Insert(Member m) {
        String sql = "INSERT INTO Members " +
                     "(MemberId, MemberName, MemberPhone, MemberDOB, MemberEmail, MemberImage, Sta) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, m.getMemberId());
            ps.setString(2, m.getMemberName());
            ps.setString(3, m.getMemberPhone());
            ps.setDate(4, m.getMemberDOB());
            ps.setString(5, m.getMemberEmail());
            ps.setString(6, m.getMemberImage());
            ps.setBoolean(7, m.getSta()); // 0 = active

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Insert member fail: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean Update(Member m) {
        String sql = "UPDATE Members SET MemberName=?, MemberPhone=?, MemberDOB=?, " +
                     "MemberEmail=?, MemberImage=? WHERE MemberId=? AND Sta = 0";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, m.getMemberName());
            ps.setString(2, m.getMemberPhone());
            ps.setDate(3, m.getMemberDOB());
            ps.setString(4, m.getMemberEmail());
            ps.setString(5, m.getMemberImage());
            ps.setString(6, m.getMemberId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Update member fail: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean Delete(String id) {
        // xóa mềm
        String sql = "UPDATE Members SET Sta = 1 WHERE MemberId=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Delete member fail: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Member FindById(String id) {
        String sql = "SELECT * FROM Members WHERE MemberId=? AND Sta = 0";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extractMember(rs);
            }

        } catch (SQLException e) {
            System.out.println("Find member fail: " + e.getMessage());
        }

        return null;
    }
    
      public Member FindByPhone(String phone) {
        String sql = "SELECT * FROM Members WHERE MemberPhone=? AND Sta = 0";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, phone);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extractMember(rs);
            }

        } catch (SQLException e) {
            System.out.println("Find member fail: " + e.getMessage());
        }

        return null;
    }


    @Override
    public List<Member> FindAll() {
        List<Member> list = new ArrayList<>();
        String sql = "SELECT * FROM Members WHERE Sta = 0";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(extractMember(rs));
            }

        } catch (SQLException e) {
            System.out.println("❌ FIND ALL MEMBERS FAIL: " + e.getMessage());
        }

        return list;
    }

    // Helper method tách code cho sạch
    private Member extractMember(ResultSet rs) throws SQLException {
        return new Member(
                rs.getString("MemberId"),
                rs.getString("MemberName"),
                rs.getString("MemberPhone"),
                rs.getDate("MemberDOB"),
                rs.getString("MemberEmail"),
                rs.getString("MemberImage"),
                rs.getBoolean("Sta")
        );
    }
}
