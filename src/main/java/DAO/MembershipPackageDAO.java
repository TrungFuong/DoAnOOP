/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.MembershipPackage;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Fuong
 */
public class MembershipPackageDAO implements GenericDAO<MembershipPackage, String> {

    @Override
    public boolean Insert(MembershipPackage p) {
        String sql = "INSERT INTO MembershipPackages (PackageId, PackageName, PackageDuration, PackagePrice, PackageDescription, Sta) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getPackageId());
            ps.setString(2, p.getPackageName());
            ps.setInt(3, p.getPackageDuration());
            ps.setDouble(4, p.getPackagePrice());
            ps.setString(5, p.getPackageDescription());
            ps.setBoolean(6, false);
            
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("INSERT ERROR: " + e.getMessage());
            return false;
        }
    }
    
    @Override
    public boolean Update(MembershipPackage p) {
        String sql = "UPDATE MembershipPackages SET PackageName=?, PackageDuration=?, PackagePrice=?, PackageDescription=? WHERE PackageId=?";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getPackageName());
            ps.setInt(2, p.getPackageDuration());
            ps.setDouble(3, p.getPackagePrice());
            ps.setString(4, p.getPackageDescription());
            ps.setString(5, p.getPackageId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean Delete(String id) {
        String sql = "UPDATE MembershipPackages SET Sta = 1 WHERE PackageId=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public MembershipPackage FindById(String id) {
        String sql = "SELECT * FROM MembershipPackages WHERE PackageId=? AND Sta=0";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new MembershipPackage(
                        rs.getString("PackageId"),
                        rs.getString("PackageName"),
                        rs.getInt("PackageDuration"),
                        rs.getDouble("PackagePrice"),
                        rs.getString("PackageDescription"),
                        rs.getBoolean("Sta")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<MembershipPackage> FindAll() {
        List<MembershipPackage> list = new ArrayList<>();
        String sql = "SELECT * FROM MembershipPackages WHERE Sta=0";

        try (Connection conn = DBConnection.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                MembershipPackage p = new MembershipPackage(
                        rs.getString("PackageId"),
                        rs.getString("PackageName"),
                        rs.getInt("PackageDuration"),
                        rs.getDouble("PackagePrice"),
                        rs.getString("PackageDescription"),
                        rs.getBoolean("Sta")
                );
                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}
