package com.xyy.backend.server.controller.weather;

import com.xyy.framework.web.response.ResponseResult;
import com.xyy.weather.client.weather.CityWeatherClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * WeatherController
 *
 * @author chentudong
 * @date 2019/12/1 15:24
 * @since 1.0
 */
@RestController
@RequestMapping("weather")
public class WeatherController
{
    private final CityWeatherClient cityWeatherClient;

    public WeatherController(CityWeatherClient cityWeatherClient)
    {
        this.cityWeatherClient = cityWeatherClient;
    }

    /**
     * 获取城市天气
     * @param cityCode cityCode
     * @return ResponseResult
     */
    @GetMapping("findByCityCode")
    public ResponseResult findByCityCode(@RequestParam("cityCode") String cityCode)
    {
        return ResponseResult.data(cityWeatherClient.findByCityCode(cityCode));
    }
}
