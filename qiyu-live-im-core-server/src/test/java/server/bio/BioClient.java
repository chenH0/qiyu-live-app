package server.bio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sfx
 * Date: 2023-10-05
 * Time: 23:28
 */
public class BioClient {
    private static final Logger LOG = LoggerFactory.getLogger(BioClient.class);

    public static void main(String[] args) throws IOException, InterruptedException {
        AtomicInteger connectCount = new AtomicInteger(0);
        // 连接bio server
        CountDownLatch count = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Socket socket = new Socket();
                        count.await();
                        socket.connect(new InetSocketAddress(9090));
                        LOG.info("连接完成"+connectCount.getAndIncrement());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }
        count.countDown();
        Thread.sleep(1000);
    }
}