package com.xyy.weather.provider;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.CountDownLatch;

/**
 * WeatherServerMain
 *
 * @author chentudong
 * @date 2019/11/30 22:26
 * @since 1.0
 */
@SpringBootApplication
@EnableFeignClients
@EnableScheduling
@EnableDiscoveryClient
public class WeatherServerMain
{
    public static void main(String[] args) throws InterruptedException
    {
        SpringApplicationBuilder builder = new SpringApplicationBuilder();
        builder.sources(WeatherServerMain.class).web(WebApplicationType.SERVLET).bannerMode(Banner.Mode.OFF).run(args);
        CountDownLatch closeLatch = new CountDownLatch(1);
        closeLatch.await();
    }
}
