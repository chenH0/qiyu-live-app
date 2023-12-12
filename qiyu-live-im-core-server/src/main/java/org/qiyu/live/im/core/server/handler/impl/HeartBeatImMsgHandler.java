package org.qiyu.live.im.core.server.handler.impl;

import io.netty.channel.ChannelHandlerContext;
import org.qiyu.live.im.core.server.common.ImMsg;
import org.qiyu.live.im.core.server.handler.SimpleHandler;
import org.springframework.stereotype.Component;

/**
 * @author chenH
 * @desc
 * @date 2023/12/07/ 22:11
 */

public class HeartBeatImMsgHandler implements SimpleHandler {
    @Override
    public void handler(ChannelHandlerContext ctx, ImMsg msg) {
        System.out.println("heart:"+msg);
        ctx.writeAndFlush(msg);
    }
}
