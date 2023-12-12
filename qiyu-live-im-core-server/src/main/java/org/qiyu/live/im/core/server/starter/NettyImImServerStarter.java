package org.qiyu.live.im.core.server.starter;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.qiyu.live.im.core.server.common.ImMsgDecoder;
import org.qiyu.live.im.core.server.common.ImMsgEncoder;
import org.qiyu.live.im.core.server.handler.ImServerCoreHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenH
 * @desc
 * @date 2023/12/9/ 15:02
 */

@Configuration
public class NettyImImServerStarter implements InitializingBean {
    private static final Logger LOG = LoggerFactory.getLogger(NettyImImServerStarter.class);
    // 指定监听端口
    @Value("${qiyu.im.port}")
    private int port;

    // 基于netty去启动一个java进程，绑定监听的端口
    public void startApplication() throws InterruptedException {
        // 处理accept事件
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        // 处理read/write事件
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workerGroup);
        bootstrap.channel(NioServerSocketChannel.class);
        bootstrap.childHandler(new ChannelInitializer<>() {
            @Override
            protected void initChannel(Channel channel) throws Exception {
                LOG.info("初始化连接渠道");
                // 设计消息体
                // 增加编解码器
                channel.pipeline().addLast(new ImMsgDecoder());
                channel.pipeline().addLast(new ImMsgEncoder());
                // 设置这个netty处理handler
                channel.pipeline().addLast(new ImServerCoreHandler());
            }
        });
        // 基于JVM的钩子函数去实现优雅的关闭
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }));

        ChannelFuture channelFuture = bootstrap.bind(port).sync();
        LOG.info("服务器启动成功"+port);
        // 这里会阻塞主线程，实现服务长期开启
        channelFuture.channel().closeFuture().sync();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Thread nettySeverThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    startApplication();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        nettySeverThread.setName("qiyu-live-im-server");
        nettySeverThread.start();
    }
}
