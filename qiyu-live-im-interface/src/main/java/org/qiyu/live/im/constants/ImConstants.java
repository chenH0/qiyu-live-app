package org.qiyu.live.im.constants;

public class ImConstants {
    /**
     * 用于魔数校验
     */
    public static final short DEFAULT_MAGIC = 19231;

    /**
     * 默认的心跳间隔时间-->客户端每30s发送一次心跳,检查该用户是否存活
     */
    public static final Long DEFAULT_HEART_BEAT_GAP = 30L;
}