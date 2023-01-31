package Interface;

public interface Parent {
    default void defMethod() {
        System.out.println("디폴트 메서드");
    }
}
