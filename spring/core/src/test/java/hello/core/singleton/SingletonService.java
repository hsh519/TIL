package hello.core.singleton;

public class SingletonService {
    // 싱글톤 패턴
    // 싱글톤 객체를 하나만 생성에 넣어놓는다
    private static final SingletonService instance = new SingletonService();
    // 객체를 호출할 때는 getInstance 메서드로만 가능하다
    public static SingletonService getInstance() {
        return instance;
    }
    // 외부에서 생성하는 것을 방지하기 위해 생성자 private
    private SingletonService() {

    }
    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
