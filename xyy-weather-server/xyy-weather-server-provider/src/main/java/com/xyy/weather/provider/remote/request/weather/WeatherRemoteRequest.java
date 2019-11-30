package com.xyy.weather.provider.remote.request.weather;

import com.alibaba.fastjson.JSON;
import com.xyy.framework.common.utils.assertion.AssertUtils;
import com.xyy.weather.provider.common.weather.parsing.ParsingDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

/**
 * WeatherRemoteRequest
 *
 * @author chentudong
 * @date 2019/11/30 14:50
 * @since 1.0
 */
@Component
public class WeatherRemoteRequest
{
    private final RestTemplate restTemplate;

    public WeatherRemoteRequest(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    /**
     * 远程获取天气
     * @param cityCode cityCode
     * @return ParsingDTO
     */
    public ParsingDTO findByCityCode(String cityCode)
    {
        AssertUtils.isNull(cityCode, "cityCode 不能为空");
        Object object = restTemplate.getForObject("http://t.weather.sojson.com/api/weather/city/" + cityCode, Object.class);
        if(Objects.nonNull(object))
        {
            return JSON.parseObject(JSON.toJSONString(object), ParsingDTO.class);
        }
        return null;
    }
}
