package org.qiyu.live.im.core.server.common;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.qiyu.live.im.constants.ImConstants;

import java.util.List;

/**
 * @author chenH
 * @desc 处理消息的解码过程
 * @date 2023/12/06/ 22:18
 */

public class ImMsgDecoder extends ByteToMessageDecoder {
    private final int BASE_LEN = 2+4+4;
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> out) throws Exception {
        // bytebuf内容的基本校验,长度校验,magic值校验
        if(byteBuf.readableBytes()>=BASE_LEN){
            if(byteBuf.readShort()!= ImConstants.DEFAULT_MAGIC){
                ctx.close();
                return;
            }
            int code = byteBuf.readInt();
            int len = byteBuf.readInt();
            // 确保byteBuf剩余长度是否足够
            if(byteBuf.readableBytes()<len){
                ctx.close();
                return;
            }
            byte[] body = new byte[len];
            byteBuf.readBytes(body);
            // 将bytebuf转换为immsg对象
            ImMsg inMsg = new ImMsg();
            inMsg.setCode(code);
            inMsg.setLen(len);
            inMsg.setMagic(ImConstants.DEFAULT_MAGIC);
            inMsg.setBody(body);
            out.add(inMsg);
        }
    }
}
