package org.qiyu.live.im.constants;

/**
 * @author chenH
 * @desc
 * @date 2023/12/13/ 19:35
 */

public enum AppIdEnum {
    QIYU_LIVE_BIZ(1, "旗鱼直播业务");

    int code;
    String desc;

    AppIdEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
