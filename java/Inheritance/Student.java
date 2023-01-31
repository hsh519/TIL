package Inheritance;

public class Student extends People{
    public int studentNo;

    public Student(String name, String ssn, int studentNo) {
        // People 클래스 생성자가 매개변수 name, ssn 가 있는 생성자기 때문에 super() 메서드를 이용해 명시적으로 호출
        super(name, ssn);
        this.studentNo = studentNo;
    }
}
