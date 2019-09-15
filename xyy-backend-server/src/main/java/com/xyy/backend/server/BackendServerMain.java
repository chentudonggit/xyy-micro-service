package com.xyy.backend.server;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.concurrent.CountDownLatch;

/**
 * BackendServerMain
 *
 * @author chentudong
 * @date 2019/9/15 12:22
 * @since 1.0
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class BackendServerMain
{
    public static void main(String[] args) throws InterruptedException
    {
        SpringApplicationBuilder builder = new SpringApplicationBuilder();
        builder.sources(BackendServerMain.class).web(WebApplicationType.SERVLET).bannerMode(Banner.Mode.OFF).run(args);
        CountDownLatch closeLatch = new CountDownLatch(1);
        closeLatch.await();
    }
}
