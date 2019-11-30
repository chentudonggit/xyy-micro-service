package com.xyy.weather.model.server.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 天气
 *
 * @author chentudong
 * @date 2019/11/17 17:43
 * @since 1.0
 */
public class CityWeatherVO implements Serializable
{
    private static final long serialVersionUID = 5610490576691657676L;
    /**
     * id
     */
    @JSONField(name= "id")
    private String id;

    /**
     * 城市id
     */
    @JSONField(name = "city_id")
    private Integer cityId;

    /**
     * 湿度
     */
   @JSONField(name="humidity")
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
   @JSONField(name="temperature")
    private Double temperature;

    /**
     * 备注
     */
   @JSONField(name="remark")
    private String remark;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Integer getCityId()
    {
        return cityId;
    }

    public void setCityId(Integer cityId)
    {
        this.cityId = cityId;
    }

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

    @Override
    public String toString()
    {
        return "WeatherVO{" +
                "id='" + id + '\'' +
                ", cityId=" + cityId +
                ", humidity='" + humidity + '\'' +
                ", pm25=" + pm25 +
                ", pm10=" + pm10 +
                ", quality='" + quality + '\'' +
                ", temperature=" + temperature +
                ", remark='" + remark + '\'' +
                '}';
    }
}
