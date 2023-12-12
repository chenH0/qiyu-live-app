package org.qiyu.live.common.interfaces.vo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sfx
 * Date: 2023-10-24
 * Time: 23:43
 */
public class PageWrapper<T> {
    private List<T> list;
    private boolean hasNext;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    @Override
    public String toString() {
        return "PageWrapper{" +
                "list=" + list +
                ", hasNext=" + hasNext +
                '}';
    }
}