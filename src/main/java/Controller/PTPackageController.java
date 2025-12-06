/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author LENOVO
 */
import DAO.PTPackageDAO;
import Model.PTPackage;
import java.util.UUID;
import java.util.List;

public class PTPackageController {

    private PTPackageDAO ptPackageDAO;

    public PTPackageController() {
        this.ptPackageDAO = new PTPackageDAO();
    }

    public List<PTPackage> getAllPTPackages() {
        return ptPackageDAO.getAllPTPackages();
    }

    public PTPackage getPTPackageById(String packageId) {
        return ptPackageDAO.getPTPackageById(packageId);
    }

    public boolean createPTPackage(String packageId,
                                   String packageName,
                                   int packageDuration,
                                   double packagePrice,
                                   String description,
                                   String trainerId,
                                   int sta) {
        PTPackage pkg = new PTPackage(
                packageId,
                packageName,
                packageDuration,
                packagePrice,
                description,
                trainerId,
                sta
        );
        return ptPackageDAO.insertPTPackage(pkg);
    }

    public boolean updatePTPackage(String packageId,
                                   String packageName,
                                   int packageDuration,
                                   double packagePrice,
                                   String description,
                                   String trainerId,
                                   int sta) {
        PTPackage pkg = new PTPackage(
                packageId,
                packageName,
                packageDuration,
                packagePrice,
                description,
                trainerId,
                sta
        );
        return ptPackageDAO.updatePTPackage(pkg);
    }

    public boolean softDeletePTPackage(String packageId) {
        return ptPackageDAO.softDeletePTPackage(packageId);
    }

    public boolean deletePTPackage(String packageId) {
        return ptPackageDAO.deletePTPackage(packageId);
    }
}
