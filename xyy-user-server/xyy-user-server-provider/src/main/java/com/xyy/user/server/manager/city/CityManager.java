package com.xyy.user.server.manager.city;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyy.framework.common.utils.assertion.AssertUtils;
import com.xyy.user.server.domian.city.City;
import com.xyy.user.server.mapper.city.CityMapper;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * CityManager
 *
 * @author chentudong
 * @date 2019/11/16 22:01
 * @since 1.0
 */
@Component
public class CityManager extends ServiceImpl<CityMapper, City>
{
    /**
     * 保存/更新
     *
     * @param id       id
     * @param parentId parentId
     * @param cityCode cityCode
     * @param cityName cityName
     * @param remark   remark
     * @return City
     */
    public City save(Integer id, Integer parentId, String cityCode, String cityName, String remark)
    {
        AssertUtils.isNull(cityName, "cityName 不能为空");
        AssertUtils.isNull(cityCode, "cityCode 不能为空");
        //获取城市是否存在
        City city = baseMapper.selectOne(new QueryWrapper<City>().eq(City.CITY_NAME, cityName));
        if (Objects.nonNull(parentId))
        {
            isNullById(parentId);
        }
        int sort = getSort(parentId);
        if (Objects.nonNull(city))
        {
            if ((!city.getId().equals(id)))
            {
                AssertUtils.throwMessageToUser(cityName + ", 已存在请修改.");
            }
        } else if (Objects.nonNull(id))
        {
            city = isNullById(id);
            sort = city.getSort();
        } else
        {
            ++sort;
            city = new City();
        }
        city.setCityCode(cityCode);
        city.setCityName(cityName);
        city.setParentId(parentId);
        city.setRemark(remark);
        city.setSort(sort);
        saveOrUpdate(city);
        return city;
    }

    /**
     * 获取最后的排序
     *
     * @param parentId parentId
     * @return int
     */
    public int getSort(Integer parentId)
    {
        int sort = 0;
        parentId = Objects.isNull(parentId) ? 0 : parentId;
        //获取父级最后的 City
        City lastCity = findLastByParentId(parentId);
        if (Objects.nonNull(lastCity))
        {
            sort = lastCity.getSort();
        }
        return sort;
    }


    /**
     * mFindById
     *
     * @param id id
     * @return City
     */
    public City findById(Serializable id)
    {
        AssertUtils.isNull(id, "id 不能为空");
        return getById(id);
    }

    /**
     * 获取最后添加的城市
     *
     * @param parentId parentId
     * @return City
     */
    public City findLastByParentId(Integer parentId)
    {
        AssertUtils.isNull(parentId, "parentId 不能为空");
        IPage<City> page = baseMapper.selectPage(new Page<>(0, 10), new QueryWrapper<City>()
                .eq(City.PARENT_ID, parentId).eq(City.STATUS, 1).orderByDesc(City.SORT));
        List<City> records = page.getRecords();
        if (!records.isEmpty())
        {
            return records.get(0);
        }
        return null;
    }

    /**
     * 判断城市是否存在
     *
     * @param id id
     * @return City
     */
    public City isNullById(Serializable id)
    {
        City city = findById(id);
        AssertUtils.isNull(id, "id = " + id + "城市不存在，请核对。");
        return city;
    }
}
