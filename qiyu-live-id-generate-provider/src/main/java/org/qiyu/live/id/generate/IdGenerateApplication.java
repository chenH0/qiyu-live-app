package org.qiyu.live.id.generate;

import jakarta.annotation.Resource;
import org.apache.dubbo.common.utils.ConcurrentHashSet;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.qiyu.live.id.generate.service.IdGenerateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author idea
 * @Date: Created in 19:45 2023/5/25
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableDubbo
public class IdGenerateApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(IdGenerateApplication.class);

    @Resource
    private IdGenerateService idGenerateService;

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(IdGenerateApplication.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        HashSet<Long> idSet = new HashSet<>();
        for (int i = 0; i < 1300; i++) {
            Long id = idGenerateService.getSeqId(1);
            idSet.add(id);
        }
        System.out.println(idSet.size());
    }
}
