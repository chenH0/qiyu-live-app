package org.qiyu.live.im.core.server.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import jakarta.annotation.Resource;
import org.qiyu.live.im.core.server.common.ImMsg;
import org.qiyu.live.im.core.server.handler.impl.ImHandlerFactoryImpl;
import org.springframework.stereotype.Component;

/**
 * @author chenH
 * @desc im消息统一handler入口
 * @date 2023/12/07/ 20:28
 */

//@Component
//@ChannelHandler.Sharable
public class ImServerCoreHandler extends SimpleChannelInboundHandler {
    private ImHandlerFactory imHandlerFactory = new ImHandlerFactoryImpl();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(!(msg instanceof ImMsg)){ // 测试是否是消息类的实例
            throw new IllegalArgumentException("error msg, msg is :"+msg);
        }
        ImMsg imMsg = (ImMsg) msg;
        imHandlerFactory.doMessageHandler(ctx, imMsg);
    }
}
