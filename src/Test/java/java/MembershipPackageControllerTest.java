package Controller;

import Model.MembershipPackage;
import org.junit.jupiter.api.*;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MembershipPackageControllerTest {

    private static MembershipPackageController controller;

    @BeforeAll
    static void setup() {
        controller = new MembershipPackageController();
    }

    @Test
    @Order(1)
    void testCreate() {
        controller.delete("PK_TEST");

        MembershipPackage p = new MembershipPackage(
                "PK_TEST",
                "Gói test",
                30,
                500.0,
                "Dùng để test",
                false
        );

        boolean result = controller.create(p);
        Assertions.assertTrue(result, "Create package failed");
    }

    @Test
    @Order(2)
    void testFindById() {
        MembershipPackage p = controller.get("PK_TEST");

        Assertions.assertNotNull(p, "FindById should return data");
        Assertions.assertEquals("PK_TEST", p.getPackageId());
    }

    @Test
    @Order(3)
    void testUpdate() {
        MembershipPackage p = new MembershipPackage(
                "PK_TEST",
                "Gói test updated",
                45,
                700.0,
                "Updated",
                false
        );

        boolean result = controller.update(p);
        Assertions.assertTrue(result, "Update failed");

        MembershipPackage updated = controller.get("PK_TEST");
        Assertions.assertEquals("Gói test updated", updated.getPackageName());
    }

    @Test
    @Order(4)
    void testGetAll() {
        List<MembershipPackage> list = controller.getAll();
        Assertions.assertNotNull(list);
        Assertions.assertTrue(list.size() > 0, "List should not be empty");
    }

    @Test
    @Order(5)
    void testDelete() {
        boolean result = controller.delete("PK_TEST");
        Assertions.assertTrue(result, "Delete failed");
    }
}
