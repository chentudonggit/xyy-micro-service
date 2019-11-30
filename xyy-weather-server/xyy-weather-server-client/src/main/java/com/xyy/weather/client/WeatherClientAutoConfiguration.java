package com.xyy.weather.client;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * WeatherClientAutoConfiguration
 *
 * @author chentudong
 * @date 2019/11/30 22:28
 * @since 1.0
 */
@EnableFeignClients
@ComponentScan
@Configuration
public class WeatherClientAutoConfiguration
{
}
