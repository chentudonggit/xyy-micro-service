package com.xyy.weather.provider.common.weather.parsing;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * CityInfo
 *
 * @author chentudong
 * @date 2019/11/30 14:09
 * @since 1.0
 */
public class CityInfoDTO implements Serializable
{
    private static final long serialVersionUID = -5820043350803583248L;
    /**
     * cityName
     */
    @JSONField(name = "city")
    private String cityName;

    /**
     * cityCode
     */
    @JSONField(name = "citykey")
    private String cityCode;

    /**
     * parentName
     */
    @JSONField(name = "parent")
    private String parentName;

    /**
     * updateTime
     */
    @JSONField(name = "updateTime")
    private String updateTime;


    public String getCityName()
    {
        return cityName;
    }

    public void setCityName(String cityName)
    {
        this.cityName = cityName;
    }

    public String getCityCode()
    {
        return cityCode;
    }

    public void setCityCode(String cityCode)
    {
        this.cityCode = cityCode;
    }

    public String getParentName()
    {
        return parentName;
    }

    public void setParentName(String parentName)
    {
        this.parentName = parentName;
    }

    public String getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(String updateTime)
    {
        this.updateTime = updateTime;
    }
}
