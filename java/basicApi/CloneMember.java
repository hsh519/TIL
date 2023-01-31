package basicApi;

public class CloneMember implements Cloneable { // 복제할 수 있음을 명시하기 위한 Cloneable 인터페이스 -> 정의된 메서드 없음
    public String id;
    public String name;
    public String password;
    public int age;
    public boolean adult;

    public CloneMember(String id, String name, String password, int age, boolean adult) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.adult = adult;
    }

    public CloneMember getCloneMember() {
        CloneMember member = null;

        try {
            // Cloneable 인터페이스 없이 clone 메서드 호출하면 CloneNotSupportedException 예외 발생
            // clone 메서드는 원본 객체의 필드값을 복사해서 새로운 객체 생성
            // clone 메서드의 리턴 타입은 Object 따라서 강제 타입 변환 필요
            member = (CloneMember) clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("얕은 복제 실패");
        }
        return member;
    }

    @Override
    public String toString() {
        return "CloneMember{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", adult=" + adult +
                '}';
    }
}
