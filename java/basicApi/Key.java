package basicApi;

public class Key {
    public int number;

    public Key(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Key) {
            Key key = (Key) obj;
            if(key.number == this.number) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() { // hashCode 메서드 재정의 -> 리턴값을 해시코드에서 number 필드값으로 변경
        return this.number;
    }
}
