package com.xyy.user.server.client.user;

import com.xyy.framework.common.web.constants.clients.eureka.EurekaServerType;
import com.xyy.user.server.service.user.UserService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户
 *
 * @author chentudong
 * @date 2019/9/15 12:05
 * @since 1.0
 */
@FeignClient(EurekaServerType.USER_SERVER)
public interface UserClient extends UserService
{
}
