package com.xyy.user.server.domian.weather.city;

import com.baomidou.mybatisplus.annotation.*;
import com.xyy.framework.mybaites.plus.domain.base.BaseEntity;

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
     * 城市id
     */
    @TableField(value = "city_id", strategy = FieldStrategy.NOT_NULL)
    private Integer cityId;

    /**
     * 湿度
     */
    @TableField("humidity")
    private String humidity;

    /**
     *
     */
    @TableField("pm25")
    private Double pm25;

    /**
     *
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

    public static final String CITY_ID = "city_id";

    public String getId()
    {
        return id;
    }

    public Integer getCityId()
    {
        return cityId;
    }

    public String getHumidity()
    {
        return humidity;
    }

    public Double getPm25()
    {
        return pm25;
    }

    public Double getPm10()
    {
        return pm10;
    }

    public String getQuality()
    {
        return quality;
    }

    public Double getTemperature()
    {
        return temperature;
    }
}
