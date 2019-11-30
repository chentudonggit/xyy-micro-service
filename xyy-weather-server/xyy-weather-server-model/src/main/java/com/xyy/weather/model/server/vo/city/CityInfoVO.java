package com.xyy.weather.model.server.vo.city;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * CityInfoVO
 *
 * @author chentudong
 * @date 2019/11/30 13:50
 * @since 1.0
 */
public class CityInfoVO implements Serializable
{
    private static final long serialVersionUID = 4820719316037492714L;

    /**
     *
     */
    @JSONField(name = "city")
    private String cityName;

    /**
     * cityKey
     */
    @JSONField(name = "citykey")
    private String cityKey;

    /**
     * parent
     */
    @JSONField(name = "parent")
    private String parent;

    private String updateTime;
}
