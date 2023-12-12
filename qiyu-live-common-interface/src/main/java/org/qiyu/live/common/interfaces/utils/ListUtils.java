package org.qiyu.live.common.interfaces.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sfx
 * Date: 2023-11-12
 * Time: 19:39
 */
public class ListUtils<T> {

    public static <T> List<List<T>> subLists(List<T> list, int subNum) {
        List<List<T>> res = new ArrayList<>();
        //将list拆分成多个小的list 每个list保证有subNum个元素,最后一个list除外
        int startIndex;
        int endIndex = 0;
        List<T> subList;
        // 25 / 4
        int subListTimes = list.size() / subNum;
        for (int i = 0; i < subListTimes; ++i) {
            startIndex = endIndex;//0  10
            endIndex = startIndex + subNum;// 10
            if (subListTimes == i + 1) {
                subList = list.subList(startIndex, list.size());
                res.add(subList);
                break;
            } else {
                subList = list.subList(startIndex, endIndex);
                res.add(subList);
            }
        }
        return res;
    }

}
