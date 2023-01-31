package basicApi;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    // Comparator<T> 인터페이스에 compare 메서드 정의되있어 재정의
    // T는 비교할 객체 타입. 즉, Student 타입을 비교
    @Override
    public int compare(Student a, Student b) {
        if(a.sno < b.sno) { return -1; }
        else if (a.sno > b.sno) { return 1; }
        else { return 0; }
    }
}
