package org.qiyu.live.im.core.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.qiyu.live.im.core.server.common.ImMsg;
import org.qiyu.live.im.interfaces.ImMsgCodeEnum;

/**
 * @author chenH
 * @desc
 * @date 2023/12/07/ 20:28
 */

public class ImServerCoreHandler extends SimpleChannelInboundHandler {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(!(msg instanceof ImMsg)){ // 测试是否是消息类的实例
            throw new IllegalArgumentException("error msg, msg is :"+msg);
        }
        ImMsg imMsg = (ImMsg) msg;
        int code = imMsg.getCode();
        if(code == ImMsgCodeEnum.IM_BIZ_MSG.getCode()){

        }
        // 登录消息包，登录token认证
        // 登出消息包，正常断开im连接时发送
        // 业务消息包，最常用的消息类型
        // 心跳消息包，定时发送汇报
    }
}
