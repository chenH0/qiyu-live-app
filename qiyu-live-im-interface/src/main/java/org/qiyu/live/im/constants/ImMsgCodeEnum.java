package org.qiyu.live.im.constants;

/**
 * @author chenH
 * @desc 消息包状态枚举
 * @date 2023/12/06/ 22:46
 */

public enum ImMsgCodeEnum {
    IM_LOGIN_MSG(1001, "登录im消息包"),
    IM_LOGOUT_MSG(1002, "登出im消息包"),
    IM_BIZ_MSG(1003, "常规业务消息包"),
    IM_HEARTBEAR_MSG(1004, "心跳检测消息包");
    private int code;
    private String desc;

    ImMsgCodeEnum(int code, String desc) {
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
