package Controller;

import DAO.MemberDAO;
import Model.Member;

import java.util.UUID;
import java.util.regex.Pattern;

public class MemberController extends BaseController<Member, String> {

    private final MemberDAO memberDAO = new MemberDAO();

    public MemberController() {
        super(new MemberDAO());
    }

    @Override
    public boolean create(Member m) {
        if (m.getMemberId() == null || m.getMemberId().isBlank()) {
            m.setMemberId(generateId());
        }

        m.setSta(false);

        validate(m);

        return memberDAO.Insert(m);
    }

    @Override
    public boolean update(Member m) {
        validate(m);
        return memberDAO.Update(m);
    }

    private void validate(Member m) {

        if (m.getMemberName() == null || m.getMemberName().isBlank()) {
            throw new IllegalArgumentException("Tên hội viên không được để trống");
        }

        if (m.getMemberPhone() == null ||
                !Pattern.matches("\\d{9,11}", m.getMemberPhone())) {
            throw new IllegalArgumentException("Số điện thoại không hợp lệ (9–11 số)");
        }

        if (m.getMemberEmail() != null && !m.getMemberEmail().isBlank()) {
            if (!Pattern.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,6}$", m.getMemberEmail())) {
                throw new IllegalArgumentException("Email không hợp lệ");
            }
        }

        if (m.getMemberDOB() == null) {
            throw new IllegalArgumentException("Ngày sinh không được để trống");
        }
    }

    private String generateId() {
        return "MB-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
