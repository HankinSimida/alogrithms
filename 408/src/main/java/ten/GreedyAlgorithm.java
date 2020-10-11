package ten;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author hankin
 * @date 2020/10/11 10:37
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        // 创建电台，放入到map中
        HashMap<String, HashSet<String>> broadCasts = new HashMap<>();
        // 将各个电台放入到broadcasts
        initData(broadCasts);

        // allAreas 存放所有地区
        HashSet<String> allAreas = new HashSet<>();
        putData(allAreas);

        // 存放选择的电台集合
        ArrayList<String> selects = new ArrayList<>();

        // 临时集合
        HashSet<String> tempSet = new HashSet<>();

        // maxKey,覆盖最多
        String maxKey = null;


        while (allAreas.size() != 0) {
            maxKey = null;
            for (String key : broadCasts.keySet()) {
                tempSet.clear();
                HashSet<String> areas = broadCasts.get(key);
                tempSet.addAll(areas);

                // tempSet 与 allAreas 取交集并重新付给 tempSet
                tempSet.retainAll(allAreas);

                // 贪心算法的体现（每次覆盖的城市个数最多的那个） tempSet.size() > broadCasts.get(maxKey).size()
                if (tempSet.size() > 0 &&
                        (maxKey == null || tempSet.size() > broadCasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            if (maxKey != null) {
                selects.add(maxKey);
                allAreas.removeAll(broadCasts.get(maxKey));
            }
        }

        System.out.println(selects);
    }

    private static void putData(HashSet<String> allAreas) {
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");
    }

    private static void initData(HashMap<String, HashSet<String>> broadCasts) {
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadCasts.put("k1", hashSet1);
        broadCasts.put("k2", hashSet2);
        broadCasts.put("k3", hashSet3);
        broadCasts.put("k4", hashSet4);
        broadCasts.put("k5", hashSet5);
    }
}
