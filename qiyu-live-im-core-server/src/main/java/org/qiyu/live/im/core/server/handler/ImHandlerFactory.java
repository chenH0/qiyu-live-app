package org.qiyu.live.im.core.server.handler;

import io.netty.channel.ChannelHandlerContext;
import org.qiyu.live.im.core.server.common.ImMsg;

/**
 * @author chenH
 * @desc 按照imMsg的code去筛选
 * @date 2023/12/07/ 22:23
 */

public interface ImHandlerFactory {
    void doMessageHandler(ChannelHandlerContext ctx, ImMsg msg);
}
