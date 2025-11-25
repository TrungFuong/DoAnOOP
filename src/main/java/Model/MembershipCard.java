package Model;

public class MembershipCard {
    private String cardId;
    private String memberId;
    private int sta; // trạng thái thẻ

    public MembershipCard() {}

    public MembershipCard(String cardId, String memberId, int sta) {
        this.cardId = cardId;
        this.memberId = memberId;
        this.sta = sta;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public int getSta() {
        return sta;
    }

    public void setSta(int sta) {
        this.sta = sta;
    }
}
