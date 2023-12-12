package org.qiyu.live.common.interfaces.topic;

public class ImCoreServerProviderTopicNames {
    /**
     * 接收im系统发送的业务消息
     */
    public static final String QIYU_LIVE_IM_BIZ_MSG_TOPIC = "qiyu_live_im_biz_msg_topic";

    /**
     * 发送im的ack消息
     */
    public static final String QIYU_LIVE_IM_ACK_MSG_TOPIC = "qiyu_live_im_ack_msg_topic";

    /**
     * 用户初次登录im服务发送mq
     */
    public static final String IM_ONLINE_TOPIC = "im_online_topic";

    /**
     * 用户断开im服务发送mq
     */
    public static final String IM_OFFLINE_TOPIC = "im_offline_topic";

    /**
     * 发送礼物的topic
     */
    public static final String SEND_GIFT_TOPIC = "qiyu_live_send_gift_topic";
}