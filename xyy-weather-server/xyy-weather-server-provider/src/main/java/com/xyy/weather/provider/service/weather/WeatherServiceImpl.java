package com.xyy.weather.provider.service.weather;

import com.xyy.framework.common.helper.BeanHelper;
import com.xyy.weather.consumer.service.weather.WeatherService;
import com.xyy.weather.model.server.vo.CityWeatherVO;
import com.xyy.weather.provider.manager.weather.CityWeatherManager;
import org.springframework.web.bind.annotation.RestController;

;

/**
 * WeatherServiceImpl
 *
 * @author chentudong
 * @date 2019/11/30 21:00
 * @since 1.0
 */
@RestController
public class WeatherServiceImpl implements WeatherService
{
    private final CityWeatherManager cityWeatherManager;

    public WeatherServiceImpl(CityWeatherManager cityWeatherManager)
    {
        this.cityWeatherManager = cityWeatherManager;
    }

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
     * @return WeatherVO
     */
    @Override
    public CityWeatherVO save(Integer cityId, String humidity, Double pm25, Double pm10, String quality, Double temperature, String remark)
    {
        return BeanHelper.convert(cityWeatherManager.save(cityId, humidity, pm25, pm10, quality, temperature, remark), CityWeatherVO.class);
    }
}
