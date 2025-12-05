package Controller;

import DAO.MembershipPackageDAO;
import Model.MembershipPackage;
import java.util.UUID;

public class MembershipPackageController extends BaseController<MembershipPackage, String> {

    public MembershipPackageController() {
        super(new MembershipPackageDAO());
    }

    @Override
    public boolean create(MembershipPackage pkg) {

        if (pkg.getPackageId() == null || pkg.getPackageId().isEmpty()) {
            pkg.setPackageId(generateId());
        }

        if (pkg.getPackageName() == null || pkg.getPackageName().isBlank()) {
            throw new IllegalArgumentException("Tên gói tập không được để trống");
        }

        if (pkg.getPackagePrice() <= 0) {
            throw new IllegalArgumentException("Giá gói tập phải > 0");
        }

        if (pkg.getPackageDuration() <= 0) {
            throw new IllegalArgumentException("Thời hạn gói tập phải > 0");
        }
        
        return dao.Insert(pkg);
    }

    private String generateId() {
        return "PK-" + UUID.randomUUID().toString().toUpperCase();
    }
}
