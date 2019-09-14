package com.xyy.user.server;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.concurrent.CountDownLatch;

/**
 *UserServerMain
 *
 * @author chentudong
 * @date 2019/9/14 22:59
 * @since 1.0
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class UserServerMain
{
    public static void main(String[] args) throws InterruptedException
    {
        SpringApplicationBuilder builder = new SpringApplicationBuilder();
        builder.sources(UserServerMain.class).web(WebApplicationType.SERVLET).bannerMode(Banner.Mode.OFF).run(args);
        CountDownLatch closeLatch = new CountDownLatch(1);
        closeLatch.await();
    }
}