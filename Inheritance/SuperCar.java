package Inheritance;

public class SuperCar extends Car {
    @Override
    public void speedUp() {
        speed += 10;
    }
    /*
    에러
    @Override
    public void stop() {
        System.out.println("스포츠카를 멈춤");
        speed = 0;
    }*/
}
