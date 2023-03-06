package hello.itemservice.domain;
public enum ItemType {
    BOOK("도서"),
    FOOD("식품"),
    ETC("기타");

    private String description;

    ItemType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
