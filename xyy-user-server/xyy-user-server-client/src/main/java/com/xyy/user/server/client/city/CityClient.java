package com.xyy.user.server.client.city;

import com.xyy.framework.common.web.constants.clients.eureka.EurekaServerType;
import com.xyy.user.server.service.city.CityService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * CityClient
 *
 * @author chentudong
 * @date 2019/11/17 13:00
 * @since 1.0
 */
@FeignClient(EurekaServerType.USER_SERVER)
public interface CityClient extends CityService
{
}
