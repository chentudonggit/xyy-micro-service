package com.xyy.weather.client.weather;

import com.xyy.framework.common.web.constants.clients.eureka.EurekaServerType;
import com.xyy.weather.consumer.service.weather.WeatherService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * CityWeatherClient
 *
 * @author chentudong
 * @date 2019/12/1 15:23
 * @since 1.0
 */
@FeignClient(EurekaServerType.WEATHER_SERVER)
public interface CityWeatherClient extends WeatherService
{
}
