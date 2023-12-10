package org.qiyu.live.im.core.server.handler.impl;

import io.netty.channel.ChannelHandlerContext;
import org.qiyu.live.im.core.server.common.ImMsg;
import org.qiyu.live.im.core.server.handler.SimpleHandler;

/**
 * @author chenH
 * @desc
 * @date 2023/12/07/ 21:46
 */

public class LogoutMsgHandler implements SimpleHandler {
    @Override
    public void handler(ChannelHandlerContext ctx, ImMsg msg) {
        System.out.println("logout:"+msg);
        ctx.writeAndFlush(msg);
    }
}
