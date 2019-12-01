package com.xyy.weather.provider.domain.weather;

import com.baomidou.mybatisplus.annotation.*;
import com.xyy.framework.mybaites.plus.domain.base.BaseEntity;

import java.io.Serializable;

/**
 * 城市天气
 *
 * @author chentudong
 * @date 2019/11/17 17:43
 * @since 1.0
 */
@TableName("tb_city_weather")
public class CityWeather extends BaseEntity<CityWeather>
{
    private static final long serialVersionUID = 5610490576691657676L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 排序
     */
    @TableId(value = "sort")
    private Integer sort;

    /**
     * 城市id
     */
    @TableField(value = "city_id", strategy = FieldStrategy.NOT_NULL)
    private Integer cityId;

    /**
     * 城市父id
     */
    @TableField(value = "parent_city_id", strategy = FieldStrategy.NOT_NULL)
    private Integer parentCityId;

    /**
     * 湿度
     */
    @TableField("humidity")
    private String humidity;

    /**
     * pm25
     */
    @TableField("pm25")
    private Double pm25;

    /**
     * pm10
     */
    @TableField("pm10")
    private Double pm10;

    /**
     * 质量
     */
    @TableField("quality")
    private String quality;

    /**
     * 温度
     */
    @TableField("temperature")
    private Double temperature;

    public CityWeather()
    {
    }

    public CityWeather(Integer sort, Integer cityId, Integer parentCityId, String humidity, Double pm25, Double pm10,
                       String quality, Double temperature, String remark)
    {
        this.sort = sort;
        this.cityId = cityId;
        this.parentCityId = parentCityId;
        this.humidity = humidity;
        this.pm25 = pm25;
        this.pm10 = pm10;
        this.quality = quality;
        this.temperature = temperature;
        this.remark = remark;
    }

    public static final String CITY_ID = "city_id";
    public static final String PARENT_CITY_ID = "parent_city_id";
    public static final String PM25 = "pm25";
    public static final String PM10 = "pm10";
    public static final String SORT = "sort";

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Integer getSort()
    {
        return sort;
    }

    public void setSort(Integer sort)
    {
        this.sort = sort;
    }

    public Integer getCityId()
    {
        return cityId;
    }

    public void setCityId(Integer cityId)
    {
        this.cityId = cityId;
    }

    public Integer getParentCityId()
    {
        return parentCityId;
    }

    public void setParentCityId(Integer parentCityId)
    {
        this.parentCityId = parentCityId;
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

    @Override
    protected Serializable pkVal()
    {
        return id;
    }
}
