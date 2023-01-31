package basicApi;

import java.util.Objects;

public class Student {
    public int sno;
    public String name;

    public Student(int sno) {
        this.sno = sno;
    }

    public Student(int sno, String name) {
        this.sno = sno;
        this.name = name;
    }

    @Override
    public int hashCode() {
        // sno, name 으로 해시코드 생성
        return Objects.hash(sno, name);
    }
}
