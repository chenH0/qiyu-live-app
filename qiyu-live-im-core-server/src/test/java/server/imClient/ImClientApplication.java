package server.imClient;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.qiyu.live.im.core.server.common.ImMsg;
import org.qiyu.live.im.core.server.common.ImMsgDecoder;
import org.qiyu.live.im.core.server.common.ImMsgEncoder;
import org.qiyu.live.im.constants.ImMsgCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chenH
 * @desc
 * @date 2023/12/08/ 16:29
 */

public class ImClientApplication {
    private static final Logger LOG = LoggerFactory.getLogger(ImClientApplication.class);

    private void startConnection(String address, int port) throws InterruptedException {
        EventLoopGroup clientGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(clientGroup);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                LOG.info("初始化连接建立");
                ch.pipeline().addLast(new ImMsgEncoder());
                ch.pipeline().addLast(new ImMsgDecoder());
                ch.pipeline().addLast(new ClientHandler());
            }
        });
        ChannelFuture channelFuture = bootstrap.connect(address, port).sync();
        Channel channel = channelFuture.channel();
        for(int i = 0; i<100; i++){
            channel.writeAndFlush(ImMsg.build(ImMsgCodeEnum.IM_LOGIN_MSG.getCode(), "login"));
            channel.writeAndFlush(ImMsg.build(ImMsgCodeEnum.IM_LOGOUT_MSG.getCode(), "logout"));
            channel.writeAndFlush(ImMsg.build(ImMsgCodeEnum.IM_BIZ_MSG.getCode(), "biz"));
            channel.writeAndFlush(ImMsg.build(ImMsgCodeEnum.IM_HEARTBEAR_MSG.getCode(), "heart"));
            Thread.sleep(3000);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ImClientApplication client = new ImClientApplication();
        client.startConnection("localhost", 9090);
    }
}
