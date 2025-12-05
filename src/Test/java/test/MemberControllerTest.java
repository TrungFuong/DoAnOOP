package test;

import Controller.MemberController;
import Model.Member;
import org.junit.jupiter.api.*;

import java.sql.Date;
import java.time.LocalDate;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MemberControllerTest {

    private static MemberController controller;
    private static String createdMemberId;

    @BeforeAll
    static void setup() {
        controller = new MemberController();
    }

    @Test
    @Order(1)
    void testCreateMemberSuccess() {
        Member m = new Member();
        m.setMemberName("Nguyen Van A");
        m.setMemberPhone("0987654321");
        m.setMemberDOB(Date.valueOf(LocalDate.of(2000, 1, 1)));
        m.setMemberEmail("test@example.com");
        m.setMemberImage("avatar.png");

        boolean result = controller.create(m);

        Assertions.assertTrue(result, "Create member failed");
        createdMemberId = m.getMemberId();

        System.out.println("Created MemberId = " + createdMemberId);
    }

    @Test
    @Order(2)
    void testCreateMemberMissingName() {
        Member m = new Member();
        m.setMemberPhone("0987654321");
        m.setMemberDOB(Date.valueOf("2002-04-01"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controller.create(m);
        });
    }

    @Test
    @Order(3)
    void testCreateMemberInvalidPhone() {
        Member m = new Member();
        m.setMemberName("Nguyen B");
        m.setMemberPhone("123"); // sai định dạng
        m.setMemberDOB(Date.valueOf("2001-03-05"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controller.create(m);
        });
    }

    @Test
    @Order(4)
    void testCreateMemberInvalidEmail() {
        Member m = new Member();
        m.setMemberName("Test C");
        m.setMemberPhone("0988888888");
        m.setMemberDOB(Date.valueOf("2003-06-01"));
        m.setMemberEmail("not-an-email");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controller.create(m);
        });
    }

    @Test
    @Order(5)
    void testFindById() {
        Member found = controller.get(createdMemberId);
        Assertions.assertNotNull(found, "Member should exist in DB");
        Assertions.assertEquals("Nguyen Van A", found.getMemberName());
    }

    @Test
    @Order(6)
    void testUpdateMember() {
        Member m = controller.get(createdMemberId);
        m.setMemberName("Updated Name");

        boolean updated = controller.update(m);
        Assertions.assertTrue(updated);

        Member updatedMember = controller.get(createdMemberId);
        Assertions.assertEquals("Updated Name", updatedMember.getMemberName());
    }

    @Test
    @Order(7)
    void testDeleteMember() {
        boolean deleted = controller.delete(createdMemberId);
        Assertions.assertTrue(deleted);

        Member found = controller.get(createdMemberId);
        Assertions.assertNull(found, "Member should be soft-deleted");
    }
}
