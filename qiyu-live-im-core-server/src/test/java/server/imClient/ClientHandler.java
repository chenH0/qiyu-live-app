package server.imClient;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.qiyu.live.im.core.server.common.ImMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chenH
 * @desc
 * @date 2023/12/08/ 16:44
 */

public class ClientHandler extends ChannelInboundHandlerAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(ClientHandler.class);
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ImMsg imMsg = (ImMsg) msg;
        LOG.info("服务端响应数据：result is"+ imMsg);
    }
}
