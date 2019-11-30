package com.xyy.weather.provider.domain.weather.forecast;

import com.baomidou.mybatisplus.annotation.*;
import com.xyy.framework.mybaites.plus.domain.base.BaseEntity;

import java.util.Date;

/**
 * 预测
 *
 * @author chentudong
 * @date 2019/11/17 18:11
 * @since 1.0
 */
@TableName("tb_city_forecast")
public class CityForecast extends BaseEntity<CityForecast>
{
    private static final long serialVersionUID = -1816895198225223496L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 天气id
     */
    @TableId(value = "weather_id", type = IdType.UUID)
    private String weatherId;

    /**
     * 城市id
     */
    @TableField(value = "city_id", strategy = FieldStrategy.NOT_NULL)
    private Integer cityId;

    /**
     * 高温
     */
    @TableField("high")
    private String high;

    /**
     * 低温
     */
    @TableField("low")
    private String low;

    /**
     * 星期
     */
    @TableField("week")
    private String week;

    /**
     * 日出
     */
    @TableField("sunrise")
    private String sunrise;

    /**
     * 日落
     */
    @TableField("sunset")
    private String sunset;

    /**
     * 风向
     */
    @TableField("win_direction")
    private String winDirection;

    /***
     * 风力等级
     */
    @TableField("wind_power")
    private String windPower;

    /**
     * 类型
     */
    @TableField("type")
    private String type;


    /**
     * 天气指数
     */
    @TableField("aqi")
    private Integer aqi;

    /**
     * ymd
     */
    @TableField("ymd")
    private Date ymd;

    /**
     * 注意
     */
    @TableField("notice")
    private String notice;

    public static final String WEATHER_ID = "weather_id";
    public static final String CITY_ID = "city_id";
    public static final String HIGH = "high";
    public static final String LOW = "low";
    public static final String YMD = "ymd";
    public static final String WEEK = "week";
    public static final String SUNRISE = "sunrise";
    public static final String SUNSET = "sunset";
    public static final String AQI = "aqi";
    public static final String TYPE = "type";

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getWeatherId()
    {
        return weatherId;
    }

    public void setWeatherId(String weatherId)
    {
        this.weatherId = weatherId;
    }

    public Integer getCityId()
    {
        return cityId;
    }

    public void setCityId(Integer cityId)
    {
        this.cityId = cityId;
    }

    public String getHigh()
    {
        return high;
    }

    public void setHigh(String high)
    {
        this.high = high;
    }

    public String getLow()
    {
        return low;
    }

    public void setLow(String low)
    {
        this.low = low;
    }

    public String getWeek()
    {
        return week;
    }

    public void setWeek(String week)
    {
        this.week = week;
    }

    public String getSunrise()
    {
        return sunrise;
    }

    public void setSunrise(String sunrise)
    {
        this.sunrise = sunrise;
    }

    public String getSunset()
    {
        return sunset;
    }

    public void setSunset(String sunset)
    {
        this.sunset = sunset;
    }

    public String getWinDirection()
    {
        return winDirection;
    }

    public void setWinDirection(String winDirection)
    {
        this.winDirection = winDirection;
    }

    public String getWindPower()
    {
        return windPower;
    }

    public void setWindPower(String windPower)
    {
        this.windPower = windPower;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Integer getAqi()
    {
        return aqi;
    }

    public void setAqi(Integer aqi)
    {
        this.aqi = aqi;
    }

    public Date getYmd()
    {
        return ymd;
    }

    public void setYmd(Date ymd)
    {
        this.ymd = ymd;
    }

    public String getNotice()
    {
        return notice;
    }

    public void setNotice(String notice)
    {
        this.notice = notice;
    }
}
