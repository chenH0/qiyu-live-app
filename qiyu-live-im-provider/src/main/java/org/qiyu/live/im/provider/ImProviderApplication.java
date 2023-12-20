package org.qiyu.live.im.provider;

import jakarta.annotation.Resource;
import org.qiyu.live.im.constants.AppIdEnum;
import org.qiyu.live.im.provider.service.ImTokenService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chenH
 * @desc
 * @date 2023/12/13/ 14:10
 */

@SpringBootApplication
public class ImProviderApplication implements CommandLineRunner {

    @Resource
    private ImTokenService imTokenService;

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ImProviderApplication.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run();
    }

    @Override
    public void run(String... args) throws Exception {
        long userId = 10921312L;
        String token = imTokenService.createImLoginToken(userId, AppIdEnum.QIYU_LIVE_BIZ.getCode());
        System.out.println("token is:"+token);
        Long userIdResult = imTokenService.getUserIdByToken(token);
        System.out.println("userIdResult is:"+userIdResult);
    }
}
