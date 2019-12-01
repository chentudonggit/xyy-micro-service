package com.xyy.weather.model.vo.weather;

import com.alibaba.fastjson.annotation.JSONField;
import com.xyy.weather.model.vo.city.CityVO;

import java.io.Serializable;

/**
 * ParsingVO
 *
 * @author chentudong
 * @date 2019/12/1 14:09
 * @since 1.0
 */
public class ParsingVO implements Serializable
{
    private static final long serialVersionUID = -1804302891399160492L;

    /**
     * 城市
     */
    @JSONField(name = "city_info")
    private CityVO city;

    /**
     * cityWeather
     */
    @JSONField(name = "data")
    private CityWeatherVO cityWeather;

    public CityVO getCity()
    {
        return city;
    }

    public void setCity(CityVO city)
    {
        this.city = city;
    }

    public CityWeatherVO getCityWeather()
    {
        return cityWeather;
    }

    public void setCityWeather(CityWeatherVO cityWeather)
    {
        this.cityWeather = cityWeather;
    }
}
