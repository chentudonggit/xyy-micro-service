package com.xyy.weather.provider.manager.weather;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyy.framework.common.builder.page.PageVO;
import com.xyy.framework.common.helper.BeanHelper;
import com.xyy.framework.common.utils.AssertUtils;
import com.xyy.framework.common.utils.format.DateFormatUtils;
import com.xyy.weather.model.server.vo.CityWeatherVO;
import com.xyy.weather.provider.domain.city.City;
import com.xyy.weather.provider.domain.weather.CityWeather;
import com.xyy.weather.provider.manager.city.CityManager;
import com.xyy.weather.provider.mapper.weather.CityWeatherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * WeatherManager
 *
 * @author chentudong
 * @date 2019/11/30 21:05
 * @since 1.0
 */
@Component
public class CityWeatherManager extends ServiceImpl<CityWeatherMapper, CityWeather>
{
    @Autowired
    private CityManager cityManager;

    /**
     * 保存
     *
     * @param cityId      cityId
     * @param humidity    humidity
     * @param pm25        pm25
     * @param pm10        pm10
     * @param quality     quality
     * @param temperature temperature
     * @param remark      remark
     * @return CityWeather
     */
    public CityWeather save(Integer cityId, String humidity, Double pm25, Double pm10, String quality, Double temperature, String remark)
    {
        AssertUtils.isNull(pm25, "pm25 不能为空");
        AssertUtils.isNull(pm10, "pm10 不能为空");
        AssertUtils.isNull(humidity, "humidity 不能为空");
        City city = cityManager.isNullById(cityId);
        int nowSort = findLastSortWithinRangeIsNow(cityId, DateFormatUtils.setMinute(new Date(), 5).getTime());
        return null;
    }

    /**
     * 分页获取
     *
     * @param cityId cityId
     * @param page   page
     * @param size   size
     * @return PageVO<CityWeatherVO>
     */
    public PageVO<CityWeatherVO> findPageByCityId(String cityId, Integer page, Integer size)
    {
        AssertUtils.isNull(cityId, "cityId 不能为空");
        page = AssertUtils.isNull(page, 0);
        size = AssertUtils.isNull(size, 10);
        IPage<CityWeather> weatherPage = baseMapper.selectPage(new Page<>(page, size), new QueryWrapper<CityWeather>()
                .eq(CityWeather.CITY_ID, cityId).orderByDesc(CityWeather.SORT));
        return BeanHelper.convert(weatherPage, CityWeatherVO.class);
    }

    /**
     * 获取最后一个
     *
     * @param cityId cityId
     * @return CityWeather
     */
    public CityWeather findLast(Integer cityId)
    {
        AssertUtils.isNull(cityId, "cityId 不能为空");
        IPage<CityWeather> weatherPage = baseMapper.selectPage(new Page<>(0, 1), new QueryWrapper<CityWeather>()
                .eq(CityWeather.CITY_ID, cityId).orderByDesc(CityWeather.SORT));
        List<CityWeather> records = weatherPage.getRecords();
        if (records.isEmpty())
        {
            return null;
        }
        return records.get(0);
    }

    /**
     * 获取最后添加的 sort
     *
     * @param cityId cityId
     * @return int
     */
    public int findLastSort(Integer cityId)
    {
        CityWeather cityWeather = findLast(cityId);
        if (Objects.nonNull(cityWeather))
        {
            return cityWeather.getSort();
        }
        return 0;
    }

    /**
     * 获取最后添加的 sort， 如果时间
     *
     * @param cityId cityId
     * @param now    now
     * @return int
     */
    public int findLastSortWithinRangeIsNow(Integer cityId, long now)
    {
        CityWeather cityWeather = findLast(cityId);
        if (Objects.nonNull(cityWeather))
        {
            Date updateTime = cityWeather.getUpdateTime();
            if(now <= updateTime.getTime())
            {
                AssertUtils.msgUser("抱歉！您的操作过于频繁，请10分钟后重试，谢谢谅解。");
            }
            return cityWeather.getSort();
        }
        return 0;
    }
}
