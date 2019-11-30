package com.xyy.user.server.manager.city;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyy.framework.common.builder.page.PageVO;
import com.xyy.framework.common.helper.BeanHelper;
import com.xyy.framework.common.utils.assertion.AssertUtils;
import com.xyy.user.server.domian.city.City;
import com.xyy.user.server.mapper.city.CityMapper;
import com.xyy.user.server.vo.city.CityVO;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
     * 保存
     *
     * @param id       id
     * @param parentId 父级id
     * @param sort     sort
     * @param cityCode cityCode
     * @param postCode 城市代码
     * @param cityName 城市名称
     * @param remark   备注
     * @return CityVO
     */
    public City save(Integer id, Integer parentId, Integer sort, String cityCode, String postCode, String cityName, String remark)
    {
        AssertUtils.isNull(cityName, "cityName 不能为空");
        AssertUtils.isNull(postCode, "postCode 不能为空");
        //获取城市是否存在
        City city = baseMapper.selectOne(new QueryWrapper<City>().eq(City.CITY_NAME, cityName));
        if (Objects.nonNull(parentId))
        {
            isNullById(parentId);
        }

        if (Objects.nonNull(city))
        {
            if ((!city.getId().equals(id)))
            {
                AssertUtils.throwMessageToUser(cityName + ", 已存在请修改.");
            }
        } else if (Objects.nonNull(id))
        {
            city = isNullById(id);
            sort = Objects.isNull(sort) ? city.getSort() : sort;
        } else
        {
            sort = getSort(parentId);
            ++sort;
            city = new City();
        }
        city.setPostCode(postCode);
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
        IPage<City> page = baseMapper.selectPage(new Page<>(1, 2), new QueryWrapper<City>()
                .eq(City.PARENT_ID, parentId).orderByDesc(City.SORT));
        List<City> records = page.getRecords();
        if (!records.isEmpty())
        {
            return records.get(0);
        }
        return null;
    }

    /**
     * 父级获取所有第二级节点
     *
     * @param parentId parentId
     * @return List<City>
     */
    public List<City> findAllByParentId(Integer parentId)
    {
        AssertUtils.isNull(parentId, "parentId 不能为空");
        return baseMapper.selectList(new QueryWrapper<City>()
                .eq(City.PARENT_ID, parentId).orderByAsc(City.SORT));
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

    /**
     * 获取所有的
     *
     * @param page page
     * @param size size
     * @return PageVO<CityVO>
     */
    public PageVO<CityVO> findPage(Integer page, Integer size)
    {
        //获取所有的一级
        page = Objects.nonNull(page) ? page : 0;
        size = Objects.nonNull(size) ? size : 10;
        IPage<City> cityPage = baseMapper.selectPage(new Page<>(page, size), new QueryWrapper<City>()
                .eq(City.PARENT_ID, 0).orderByAsc(City.CREATE_TIME));
        PageVO<CityVO> result = BeanHelper.convert(cityPage, CityVO.class);
        Collection<CityVO> data = result.getData();
        for (CityVO city : data)
        {
            setChild(city, city.getId());
        }
        return result;
    }

    /**
     * 封装所有的子类
     *
     * @param city     city
     * @param parentId parentId
     */
    public void setChild(CityVO city, Integer parentId)
    {
        AssertUtils.isNull(city, "city 不能为空");
        List<CityVO> childes = city.getChildren();
        if (Objects.isNull(childes))
        {
            childes = new ArrayList<>();
            city.setChildren(childes);
        }
        Collection<City> cities = findAllByParentId(parentId);
        List<CityVO> list = BeanHelper.convert(cities, CityVO.class);
        childes.addAll(list);
        if (!list.isEmpty())
        {
            for (CityVO cityVO : list)
            {
                setChild(cityVO, cityVO.getId());
            }
        }
    }

    /**
     * 查询id 的所有的子节点， 不包括下一级
     *
     * @param id   id
     * @param page page
     * @param size size
     * @return PageVO<CityVO
     */
    public PageVO<CityVO> findPageById(Integer id, Integer page, Integer size)
    {
        AssertUtils.isNull(id, "id 不能为空");
        page = Objects.nonNull(page) ? page : 0;
        size = Objects.nonNull(size) ? size : 10;
        IPage<City> cityPage = baseMapper.selectPage(new Page<>(page, size), new QueryWrapper<City>()
                .eq(City.PARENT_ID, id).orderByDesc(City.SORT));
        return BeanHelper.convert(cityPage, CityVO.class);
    }

    /**
     * findAll
     *
     * @return List<CityVO>
     */
    public List<CityVO> findAll()
    {
        List<City> cities = baseMapper.selectList(new QueryWrapper<>());
        List<CityVO> result = new ArrayList<>();
        List<CityVO> convert = BeanHelper.convert(cities, CityVO.class);
        //归类
        for (CityVO city : convert)
        {
            Integer parentId = city.getParentId();
            if (parentId == 0)
            {
                city.setChildren(childrenNode(city.getId(), convert));
                result.add(city);
            }
        }
        return result;
    }

    /**
     * 子节点
     *
     * @param id  父节点
     * @param all all
     * @return List<CategoryVO>
     */
    private List<CityVO> childrenNode(Integer id, List<CityVO> all)
    {
        List<CityVO> childrens = new ArrayList<>();
        for (CityVO children : all)
        {
            if (id.equals(children.getParentId()))
            {
                children.setChildren(childrenNode(children.getId(), all));
                childrens.add(children);
            }
        }
        return childrens;
    }

    /**
     * 更新
     *
     * @param cites cites
     * @return Integer
     */
    public Integer updateAll(CityVO[] cites)
    {
        AssertUtils.isNull(cites, "cites 不能为空");
        int result = 0;
        for (CityVO cite : cites)
        {
            List<City> citys = baseMapper.selectList(new QueryWrapper<City>().eq(City.CITY_NAME, cite.getCityName()));
            if (citys.size() == 1)
            {
                City city = citys.get(0);
                city.setCityCode(cite.getCityCode());
                if (updateById(city))
                {
                    result++;
                }
            }
        }
        return result;
    }
}
