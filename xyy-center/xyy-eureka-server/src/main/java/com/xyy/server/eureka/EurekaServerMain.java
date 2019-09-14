package com.xyy.server.eureka;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.concurrent.CountDownLatch;

/**
 * EurekaServerMain
 *
 * @author chentudong
 * @date 2019/9/14 20:18
 * @since 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerMain
{
    public static void main(String[] args) throws InterruptedException
    {
        SpringApplicationBuilder builder = new SpringApplicationBuilder();
        builder.sources(EurekaServerMain.class).web(WebApplicationType.SERVLET).bannerMode(Banner.Mode.OFF).run(args);
        CountDownLatch closeLatch = new CountDownLatch(1);
        closeLatch.await();
    }
}
