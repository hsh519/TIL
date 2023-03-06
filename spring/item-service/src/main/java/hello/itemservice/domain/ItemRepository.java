package hello.itemservice.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository // 컴포넌트 스캔 대상
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>();
    private static long sequence = 0L;

    // 아이템 저장
    public Item save(Item item) {
        item.setId(sequence);
        store.put(item.getId(), item);
        sequence++;

        return item;
    }

    // 아이디를 통해 아이템 조회
    public Item findById(Long id) {
        return store.get(id);
    }

    // 모든 아이템 조회
    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    // 아이템 정보 수정
    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
        findItem.setOpen(updateParam.getOpen());
        findItem.setRegions(updateParam.getRegions());
        findItem.setItemtype(updateParam.getItemtype());
        findItem.setDeliveryCode(updateParam.getDeliveryCode());
    }

    // 모든 아이템 삭제
    public void clearStore() {
        store.clear();
    }
}
