package com.xyy.weather.consumer.service.weather;

import com.xyy.weather.model.server.vo.CityWeatherVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * WeatherService
 *
 * @author chentudong
 * @date 2019/11/30 15:03
 * @since 1.0
 */
@RequestMapping("weatherService")
public interface WeatherService
{
    /**
     * 保存
     *
     * @param cityId      cityId
     * @param humidity    humidity
     * @param pm25        pm25
     * @param pm10        pm10
     * @param quality     quality
     * @param temperature temperature
     * @param remark      remark
     * @return CityWeatherVO
     */
    @RequestMapping("save")
    CityWeatherVO save(@RequestParam("cityId") Integer cityId,
                       @RequestParam("humidity") String humidity,
                       @RequestParam("pm25") Double pm25,
                       @RequestParam("pm10") Double pm10,
                       @RequestParam("quality") String quality,
                       @RequestParam("temperature") Double temperature,
                       @RequestParam("remark") String remark);
}
