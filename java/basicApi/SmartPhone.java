package basicApi;

public class SmartPhone {
    public String company;
    public String os;

    public SmartPhone(String company, String os) {
        this.company = company;
        this.os = os;
    }

    @Override
    public String toString() { // 재정의한 toString 메서드. 원래는 '클래스명@16진수해시코드' 를 리턴
        return "SmartPhone{" +
                "company='" + company + '\'' +
                ", os='" + os + '\'' +
                '}';
    }
}
