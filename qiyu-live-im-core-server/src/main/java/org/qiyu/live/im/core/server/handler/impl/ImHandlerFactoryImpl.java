package org.qiyu.live.im.core.server.handler.impl;

import io.netty.channel.ChannelHandlerContext;
import org.qiyu.live.im.core.server.common.ImMsg;
import org.qiyu.live.im.core.server.handler.ImHandlerFactory;
import org.qiyu.live.im.core.server.handler.SimpleHandler;
import org.qiyu.live.im.interfaces.ImMsgCodeEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenH
 * @desc
 * @date 2023/12/07/ 22:26
 */

public class ImHandlerFactoryImpl implements ImHandlerFactory {

    private static Map<Integer, SimpleHandler> simpleHandlerMap = new HashMap<>();

    static {
        // 登录消息包，登录token认证
        // 登出消息包，正常断开im连接时发送
        // 业务消息包，最常用的消息类型
        // 心跳消息包，定时发送汇报
        simpleHandlerMap.put(ImMsgCodeEnum.IM_LOGIN_MSG.getCode(), new LoginMsgHandler());
        simpleHandlerMap.put(ImMsgCodeEnum.IM_LOGOUT_MSG.getCode(), new LogoutMsgHandler());
        simpleHandlerMap.put(ImMsgCodeEnum.IM_BIZ_MSG.getCode(), new BizMsgHandler());
        simpleHandlerMap.put(ImMsgCodeEnum.IM_HEARTBEAR_MSG.getCode(), new HeartBeatImMsgHandler());
    }

    @Override
    public void doMessageHandler(ChannelHandlerContext ctx, ImMsg msg) {
        SimpleHandler simpleHandler = simpleHandlerMap.get(msg.getCode());
        if (simpleHandler==null) {
            throw new IllegalArgumentException("msg code is error, code is:"+msg.getCode());
        }
        simpleHandler.handler(ctx, msg);
    }
}
