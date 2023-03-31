package LV2;

import java.util.*;

public class _1차_캐시 {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        int answer = 5;
        Queue<String> cache = new LinkedList<>();
        for (int i=0; i<cities.length; i++) {
            String city = cities[i].toUpperCase();
            if (i == 0) {
                cache.offer(city);
                continue;
            }
            if (cache.contains(city)) {
                cache.remove(city);
                cache.offer(city);
                answer += 1;
            } else {
                if (cache.size() == cacheSize) {
                    cache.poll();
                }
                cache.offer(city);
                answer += 5;
            }
        }
        return answer;
    }
}
