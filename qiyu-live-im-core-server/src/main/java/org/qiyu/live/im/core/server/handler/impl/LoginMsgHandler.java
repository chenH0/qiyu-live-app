package org.qiyu.live.im.core.server.handler.impl;

import io.netty.channel.ChannelHandlerContext;
import org.qiyu.live.im.core.server.common.ImMsg;
import org.qiyu.live.im.core.server.handler.SimpleHandler;
import org.springframework.stereotype.Component;

/**
 * @author chenH
 * @desc 登录消息处理逻辑统一收拢到这个类
 * @date 2023/12/07/ 21:35
 */

public class LoginMsgHandler implements SimpleHandler {
    @Override
    public void handler(ChannelHandlerContext ctx, ImMsg msg) {
        System.out.println("login:"+msg);
        ctx.writeAndFlush(msg);
    }
}
