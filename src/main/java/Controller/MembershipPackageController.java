/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.MembershipPackageDAO;
import Model.MembershipPackage;

/**
 *
 * @author Fuong
 */
public class MembershipPackageController extends BaseController<MembershipPackage, String>{
     public MembershipPackageController() {
        super(new MembershipPackageDAO());
    }
}