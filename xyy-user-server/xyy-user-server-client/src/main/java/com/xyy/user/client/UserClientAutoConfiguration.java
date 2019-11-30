package com.xyy.user.client;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * UserClientAutoConfiguration
 *
 * @author chentudong
 * @date 2019/9/15 12:07
 * @since 1.0
 */
@EnableFeignClients
@ComponentScan
@Configuration
public class UserClientAutoConfiguration
{
}
