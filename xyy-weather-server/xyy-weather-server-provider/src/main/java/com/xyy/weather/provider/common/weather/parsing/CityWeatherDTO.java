package com.xyy.weather.provider.common.weather.parsing;

import com.alibaba.fastjson.annotation.JSONField;
import com.xyy.weather.provider.common.weather.parsing.forecast.CityForecastDTO;

import java.io.Serializable;
import java.util.List;

/**
 * CityWeatherDTO
 *
 * @author chentudong
 * @date 2019/11/30 14:22
 * @since 1.0
 */
public class CityWeatherDTO implements Serializable
{
    private static final long serialVersionUID = -8189790390076738745L;

    /**
     * 湿度
     */
    @JSONField(name="shidu")
    private String humidity;

    /**
     * pm25
     */
    @JSONField(name="pm25")
    private Double pm25;

    /**
     * pm10
     */
    @JSONField(name="pm10")
    private Double pm10;

    /**
     * 质量
     */
    @JSONField(name="quality")
    private String quality;

    /**
     * 温度
     */
    @JSONField(name="wendu")
    private Double temperature;

    /**
     * 备注
     */
    @JSONField(name="ganmao")
    private String remark;

    /**
     * 昨天
     */
    @JSONField(name="yesterday")
    private CityForecastDTO yesterday;

    /**
     * 未来
     */
    @JSONField(name="forecast")
    private List<CityForecastDTO> forecasts;

    public String getHumidity()
    {
        return humidity;
    }

    public void setHumidity(String humidity)
    {
        this.humidity = humidity;
    }

    public Double getPm25()
    {
        return pm25;
    }

    public void setPm25(Double pm25)
    {
        this.pm25 = pm25;
    }

    public Double getPm10()
    {
        return pm10;
    }

    public void setPm10(Double pm10)
    {
        this.pm10 = pm10;
    }

    public String getQuality()
    {
        return quality;
    }

    public void setQuality(String quality)
    {
        this.quality = quality;
    }

    public Double getTemperature()
    {
        return temperature;
    }

    public void setTemperature(Double temperature)
    {
        this.temperature = temperature;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public CityForecastDTO getYesterday()
    {
        return yesterday;
    }

    public void setYesterday(CityForecastDTO yesterday)
    {
        this.yesterday = yesterday;
    }

    public List<CityForecastDTO> getForecasts()
    {
        return forecasts;
    }

    public void setForecasts(List<CityForecastDTO> forecasts)
    {
        this.forecasts = forecasts;
    }
}
