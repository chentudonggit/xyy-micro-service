package com.xyy.weather.provider.common.weather.parsing;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 解析天气接口返回的数据
 *
 * @author chentudong
 * @date 2019/11/30 13:42
 * @since 1.0
 */
public class ParsingDTO implements Serializable
{
    private static final long serialVersionUID = 1735439309038543217L;

    /**
     * cityInfo
     */
    @JSONField(name = "cityInfo")
    private CityInfoDTO city;

    /**
     * cityWeather
     */
    @JSONField(name = "data")
    private CityWeatherDTO cityWeather;

    public CityInfoDTO getCity()
    {
        return city;
    }

    public void setCity(CityInfoDTO city)
    {
        this.city = city;
    }

    public CityWeatherDTO getCityWeather()
    {
        return cityWeather;
    }

    public void setCityWeather(CityWeatherDTO cityWeather)
    {
        this.cityWeather = cityWeather;
    }
}
