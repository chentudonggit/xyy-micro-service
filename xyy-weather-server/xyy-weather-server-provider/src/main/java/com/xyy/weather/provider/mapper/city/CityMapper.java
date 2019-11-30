package com.xyy.weather.provider.mapper.city;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xyy.weather.provider.domain.city.City;

import java.util.List;

/**
 * CityMapper
 *
 * @author chentudong
 * @date 2019/11/16 22:03
 * @since 1.0
 */
public interface CityMapper extends BaseMapper<City>
{
    /**
     * 获取 cityCode
     *
     * @return List<String>
     */
    List<City> findCityCodeNotNull();
}
