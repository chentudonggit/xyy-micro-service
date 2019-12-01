package com.xyy.weather.provider.manager.weather.forecast;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyy.framework.common.utils.assertion.AssertUtils;
import com.xyy.weather.model.enums.DayTypeEnum;
import com.xyy.weather.provider.domain.weather.forecast.CityForecast;
import com.xyy.weather.provider.manager.city.CityManager;
import com.xyy.weather.provider.mapper.weather.forecast.CityForecastMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * CityForecastManager
 *
 * @author chentudong
 * @date 2019/12/1 11:54
 * @since 1.0
 */
@Component
public class CityForecastManager extends ServiceImpl<CityForecastMapper, CityForecast>
{
    @Autowired
    private CityManager cityManager;

    /**
     * 保存
     *
     * @param weatherId    weatherId
     * @param cityId       cityId
     * @param high         high
     * @param low          low
     * @param week         week
     * @param sunrise      sunrise
     * @param sunset       sunset
     * @param winDirection winDirection
     * @param windPower    windPower
     * @param type         type
     * @param aqi          aqi
     * @param ymd          ymd
     * @param notice       notice
     * @param sort         sort
     * @param dayType      dayType
     * @return CityForecast
     */
    public CityForecast save(String weatherId, Integer cityId, String high, String low, String week, String sunrise, String sunset,
                             String winDirection, String windPower, String type, Integer aqi, Date ymd, String notice, Integer sort, Integer dayType)
    {
        AssertUtils.isNull(cityId, "cityId 不能为空");
        AssertUtils.isNull(sort, "sort 不能为空");
        sort = getSort(sort, weatherId);
        AssertUtils.isNull(DayTypeEnum.value(dayType), "dayType = " + dayType + ", 类型不符合请联系管理员。");
        cityManager.isNullById(cityId);
        CityForecast cityForecast = new CityForecast(weatherId, cityId,  high,  low,  week,  sunrise,  sunset,
                 winDirection,  windPower,  type,  aqi,  ymd,  notice,  sort,  (findLastBatch(cityId)+1), dayType);
        cityForecast.insert();
        return cityForecast;
    }

    /**
     * 获取最后的batch
     *
     * @param cityId cityId
     * @return int
     */
    public int findLastBatch(Integer cityId)
    {
        AssertUtils.isNull(cityId, "cityId 不能为空");
        List<CityForecast> forecasts = baseMapper.selectList(new QueryWrapper<CityForecast>().eq(CityForecast.CITY_ID, cityId)
                .orderByDesc(CityForecast.BATCH).last(" limit 1 "));

        if (forecasts.isEmpty())
        {
            return 0;
        } else
        {
            return forecasts.get(0).getBatch();
        }
    }

    /**
     * 获取最后Sort
     *
     * @param weatherId weatherId
     * @return int
     */
    public int findLastSort(String weatherId)
    {
        AssertUtils.isNull(weatherId, "weatherId 不能为空");
        List<CityForecast> forecasts = baseMapper.selectList(new QueryWrapper<CityForecast>().eq(CityForecast.WEATHER_ID, weatherId)
                .orderByDesc(CityForecast.SORT).last(" limit 1 "));
        if (forecasts.isEmpty())
        {
            return 0;
        } else
        {
            return forecasts.get(0).getSort();
        }
    }

    /**
     * 获取sort
     *
     * @param sort      sort
     * @param weatherId weatherId
     * @return int
     */
    public int getSort(int sort, String weatherId)
    {
        if (sort <= 0)
        {
            return 1;
        }
        if (sort == 1)
        {
            return ++sort;
        }
        int lastSort = findLastSort(weatherId);
        //2 1
        //1 == 1
        sort -= 1;
        if (sort == lastSort)
        {
            return ++sort;
        } else
        {
            return ++lastSort;
        }
    }
}
