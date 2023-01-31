package basicApi;

public class Member {
    public String id;

    public Member(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Member) {
            Member member = (Member) obj;
            if(id.equals(member.id)) { // 기존 equals 메서드 -> String 객체를 비교하기 때문
               return true;
            }
        }
        return false;
    }
}
