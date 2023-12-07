package org.qiyu.live.im.core.server.handler;

import io.netty.channel.ChannelHandlerContext;

/**
 * @author chenH
 * @desc 消息抽象类
 * @date 2023/12/07/ 20:28
 */

public interface SimpleHandler {
    void handler(ChannelHandlerContext ctx, Object msg);
}
