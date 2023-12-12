package org.qiyu.live.common.interfaces.enums;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sfx
 * Date: 2023-10-01
 * Time: 20:35
 */
public enum CommonStatusEnum {
    NO_VALID(0, "无效"),
    VALID(1, "有效");
    Integer code;
    String desc;

    CommonStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}