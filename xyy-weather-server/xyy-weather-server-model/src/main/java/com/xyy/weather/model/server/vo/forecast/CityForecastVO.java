package com.xyy.weather.model.server.vo.forecast;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * 预测
 *
 * @author chentudong
 * @date 2019/11/17 18:11
 * @since 1.0
 */ 
public class CityForecastVO implements Serializable
{
    private static final long serialVersionUID = -1816895198225223496L;

    /**
     * id
     */
    @JSONField(name = "id")
    private Integer id;

    /**
     * 天气id
     */
    @JSONField(name = "weather_id")
    private String weatherId;

    /**
     * 城市id
     */
    @JSONField(name = "city_id")
    private Integer cityId;

    /**
     * 高温
     */
    @JSONField(name="high")
    private String high;

    /**
     * 低温
     */
    @JSONField(name="low")
    private String low;

    /**
     * 星期
     */
    @JSONField(name="week")
    private String week;

    /**
     * 日出
     */
    @JSONField(name="sunrise")
    private String sunrise;

    /**
     * 日落
     */
    @JSONField(name="sunset")
    private String sunset;

    /**
     * 风向
     */
    @JSONField(name="win_direction")
    private String winDirection;

    /***
     * 风力等级
     */
    @JSONField(name="wind_power")
    private String windPower;

    /**
     * 类型
     */
    @JSONField(name="type")
    private String type;


    /**
     * 天气指数
     */
    @JSONField(name="aqi")
    private Integer aqi;

    /**
     * ymd
     */
    @JSONField(name="ymd")
    private Date ymd;

    /**
     * 注意
     */
    @JSONField(name="notice")
    private String notice;

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
