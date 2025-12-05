package test;

import Controller.MembershipPackageController;
import Model.MembershipPackage;
import org.junit.jupiter.api.*;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MembershipPackageControllerTest {

    private static MembershipPackageController controller;
    private static String createdId;

    @BeforeAll
    static void setup() {
        controller = new MembershipPackageController();
    }

    @Test
    @Order(1)
    void testCreateSuccess() {
        MembershipPackage pkg = new MembershipPackage(
                null,                  
                "Gói Tập Test",
                30,
                499.0,
                "Gói dành cho unit test",
                false
        );

        boolean result = controller.create(pkg);

        Assertions.assertTrue(result, "❌ Create package failed!");

        createdId = pkg.getPackageId();  

        System.out.println("✔ Created Package ID = " + createdId);
    }

    @Test
    @Order(2)
    void testFindById() {
        MembershipPackage found = controller.get(createdId);

        Assertions.assertNotNull(found, "❌ Package not found!");
        Assertions.assertEquals(createdId, found.getPackageId());
    }

    @Test
    @Order(3)
    void testUpdateSuccess() {
        MembershipPackage pkg = controller.get(createdId);
        pkg.setPackageName("Gói Tập Updated");

        boolean result = controller.update(pkg);

        Assertions.assertTrue(result, "❌ Update failed!");
    }

    @Test
    @Order(4)
    void testDeleteSuccess() {
        boolean result = controller.delete(createdId);

        Assertions.assertTrue(result, "❌ Delete failed!");

        MembershipPackage deleted = controller.get(createdId);
        Assertions.assertNull(deleted, "❌ Deleted package still exists!");
    }

    // ❌ CÁC TEST VALIDATION
    @Test
    @Order(5)
    void testCreate_InvalidName() {
        MembershipPackage pkg = new MembershipPackage(
                null, "", 30, 500.0, "desc", false
        );

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> controller.create(pkg));
    }

    @Test
    @Order(6)
    void testCreate_InvalidPrice() {
        MembershipPackage pkg = new MembershipPackage(
                null, "Gói sai giá", 30, 0, "desc", false
        );

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> controller.create(pkg));
    }

    @Test
    @Order(7)
    void testCreate_InvalidDuration() {
        MembershipPackage pkg = new MembershipPackage(
                null, "Gói sai duration", -1, 500, "desc", false
        );

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> controller.create(pkg));
    }
}