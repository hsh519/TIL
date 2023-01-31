package basicApi;


import java.util.Arrays;

public class DeepCloneMember implements Cloneable {
    public String name;
    public int age;
    public int[] scores;
    public Car car;

    public DeepCloneMember(String name, int age, int[] scores, Car car) {
        this.name = name;
        this.age = age;
        this.scores = scores;
        this.car = car;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 얕은 복제는 필드값을 복사해서 새 객체를 생성. 따라서 참조값일 경우 같은 객체를 원본 객체, 복제 객체 둘다 바라보게 된다
        // 깊은 복제는 참조 객체도 함꼐 복사해서 새 객체를 생성. 따라서 복제 객체, 원본 객체는 본인들이 참조하는 객체를 바라보게 된다. 깊은 복제는 clone 메서드 재정의 필요
        DeepCloneMember cloned = (DeepCloneMember) super.clone();
        cloned.scores = Arrays.copyOf(this.scores, this.scores.length); // 배열 복사후 주소값 저장
        cloned.car = new Car(this.car.model); // 같은 모델을 가진 새 객체의 주소값 저장

        return cloned;
    }

    public DeepCloneMember getMember() {
        DeepCloneMember cloned = null;
        try{
            cloned = (DeepCloneMember) clone();
        } catch(CloneNotSupportedException e) {
            System.out.println("깊은 복제 실패");
        }
        return cloned;
    }

    @Override
    public String toString() {
        return "DeepCloneMember{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", scores=" + Arrays.toString(scores) +
                ", car=" + car.model +
                '}';
    }
}
