import Interface.Vehicle;
import Interface.Bus;
import Interface.Taxi;

public class Exception {
    public static void main(String[] args) {
       example5();
        example6();
        example7();
        example8();
    }
    /*
    에러와 예외

    에러와 예외 모두 발생하면 그 즉시 프로그램이 종료된다.
    컴퓨터 하드웨어의 오동작 혹은 고장으로 인해서 실행 오류가 발생하는 것 -> 에러
    JVM 실행에 문제가 생긴것이기 때문에 JVM 위에 실행되는 프로그램을 아무리 잘 만들어도 에러는 발생한다. 따라서 에러는 개발자가 해결할 방법이 없다.
    개발자의 잘못된 코딩, 사용자의 잘못된 조작으로 인해서 실행 오류가 발생하는 것 -> 예외
    예외는 예외 처리를 통해서 프로그램이 종료되지 않고 정상 실행 상태를 유지할 수 있다.

    일반예외와 실행예외

    일반예외는 컴파일하는 과정에서 예외가 필요한지 검사하는 예외를 말한다.
    즉, 일반예외는 개발자에게 예외가 발생한다고 알려줘 예외 처리를 하도록 유도한다.
    실행예외는 컴파일하는 과정에서 예외가 필요한지 검사하지 않는 예외를 말한다.
    그렇기 때문에 프로그램을 실행하고 프로그램이 예외때문에 종료되고 나서야 해당 예외가 발생한다는 것을 알게된다.
    따라서 코드를 작성하면서 이러한 예외가 발생할 수 있겠다 하는 것을 알아차리는 것이 가장 중요하다.
    */
    public static void example1() {
        /*
         실행 예외 - NullPointerException
         객체 참조를 하지 않는 참조 변수에 도트 연산자(.)를 사용해 접근할 때 발생한다.
         */
        String data = null;
        System.out.println(data.toString()); // NullPointerException
    }
    public static void example2() {
        /*
         실행 예외 - ArrayIndexOutOfBoundsException
         배열에서 인덱스 범위를 초과하여 사용할 경우 발생한다.
         */
        int[] arr = new int[3];
        arr[3] = 1; // ArrayIndexOutOfBoundsException
    }
    public static void example3() {
        /*
         실행 예외 - NumberFormatException
         숫자로 변환할 수 없는 문자를 숫자로 변환할 경우 발생한다.
         */
        String s = "a113";
        int i = Integer.parseInt(s); // NumberFormatException
    }
    public static void example4() {
        /*
         실행 예외 - ClassCastException
         클래스, 인터페이 타입 변환을 할 때 변환되지 않는 타입으로 강제 타입 변환할 경우 발생한다.
         */
        Vehicle v = new Bus();
        Bus b = (Bus) v;
        Taxi t = (Taxi) v; // ClassCastException
    }
    public static void example5() {
        /*
        일반예외의 예외처리
        인텔리제이는 일반 예외가 발생할 가능성이 있는 코드를 빨간줄로 표시하여 알려준다. 따라서 해당 코드에서 발생하는 예외에 대해 예외 처리하면 된다.
        예외처리를 할때는 try~catch~finally 블록을 작성해준다.
        try 블록에는 예외가 발생할 수 있는 코드를 작성해주고, catch 블록에는 try 블록에서 발생할 것 같은 예외에 대해서 처리 코드를 작성해준다.
        finally 블록은 옵션으로 생략이 가능하다. 예외 발생에 상관없이 항상 실행할 코드를 작성해준다.
        예외가 발생하지 않으면 try 블록의 코드를 다 실행하고 catch 블록의 코드는 넘기고 바로 finally 블록의 코드를 실행한다.
        예외가 발생하면 그 즉시 실행을 멈추고 catch 블록의 코드를 실행하고 finally 블록의 코드를 실행한다.
        */
        try{
            Class clazz = Class.forName("noClass"); // ClassNotFoundException
        } catch(ClassNotFoundException e) {
            System.out.println("클래스가 존재하지 않습니다.");
        }
    }
    public static void example6() {
        /*
        실행예외의 예외처리
        실행예외는 따로 알려주지 않기 때문에 개발자가 알아서 발생할 예외를 잘 처리해야 한다.
        예외처리는 일반 예외를 처리하는 방법과 동일하다.(try~catch~finally 블록)
        */
        try {
            int[] arr = new int[3];
            arr[3] = 3;
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("인덱스 범위를 넘었습니다.");
            return;
        }

        try {
            String s = "a112";
            int i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("숫자로 변환할 수가 없어요.");
        } finally {
            System.out.println("다시 실행해주세요.");
        }
    }
    public static void example7() {
        /*
        다중 catch 블록
        try 블록의 코드에서 많은 예외가 발생할 경우 다중 catch 블록을 작성한다.
        예외가 발생하면 그 즉시 실행을 중단하고 해당 예외에 대한 처리를 하는 catch 블록을 찾아서 예외처리하기 때문에 다중 catch 블록이라 할지라도 하나의 catch 블록만 실행된다.
        */
        try {
            int[] arr = new int[3];
            arr[3] = 3;

            String s = "a112";
            int i = Integer.parseInt(s);

        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("인덱스 범위를 넘었습니다.");
        } catch (NumberFormatException e) {
            System.out.println("숫자로 변환할 수가 없어요.");
        } finally {
            System.out.println("다시 실행해주세요.");
        }
    }
    public static void example8() {
        /*
        catch 블록의 순서
        여러개의 catch 블록을 작성할 때 주의할 점은 하위 예외 클래스부터 작성해야한다는 것이다.
        예외가 발생하면 상단의 catch 블록부터 예외 처리를 할 수 있나 찾게되는데
        상위 예외 클래스부터 작성하게 되면 어떤 예외가 발생하든 항상 상위 예외 클래스의 catch 블록이 실행된다. (이유는 하위 에외 클래스는 상위 예외 클래스를 상속했기 떄문이다.)
        따라서 정확한 예외 처리가 어렵다.
        */
        try {
            int[] arr = new int[3];
            arr[3] = 3;

            String s = "a112";
            int i = Integer.parseInt(s);

        }
//        catch(java.lang.Exception e) {
//            System.out.println("catch문 순서의 중요성");
//        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("인덱스 범위를 넘었습니다.");
        } catch (NumberFormatException e) {
            System.out.println("숫자로 변환할 수가 없어요.");
        }  finally {
            System.out.println("다시 실행해주세요.");
        }
    }
    public static void example9() {
        /*
        멀티 catch 블록
        하나의 catch 블록에 여러 예외를 처리하고 싶다면 처리하고 싶은 예외를 |로 연결하면 된다.
        */
        try {
            int[] arr = new int[3];
            arr[3] = 3;

            String s = "a112";
            int i = Integer.parseInt(s);

        } catch(ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("인덱스를 넘어섰거나 숫자로 변환할 수 없습니다.");
        } finally {
            System.out.println("다시 실행해주세요.");
        }
    }
}
