package com.xyy.weather.provider.service.city;

import com.xyy.framework.common.builder.page.PageVO;
import com.xyy.framework.common.helper.BeanHelper;
import com.xyy.weather.consumer.service.city.CityService;
import com.xyy.weather.model.vo.city.CityVO;
import com.xyy.weather.provider.manager.city.CityManager;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * CityServiceImpl
 *
 * @author chentudong
 * @date 2019/11/16 21:58
 * @since 1.0
 */
@RestController
public class CityServiceImpl implements CityService
{
    private final CityManager cityManager;

    public CityServiceImpl(CityManager cityManager)
    {
        this.cityManager = cityManager;
    }

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
    @Override
    public CityVO save(Integer id, Integer parentId, Integer sort, String cityCode, String postCode, String cityName, String remark)
    {
        return BeanHelper.convert(cityManager.save(id, parentId, sort, cityCode, postCode, cityName, remark), CityVO.class);
    }

    /**
     * id 获取 CityVO
     *
     * @param id id
     * @return CityVO
     */
    @Override
    public CityVO findById(Integer id)
    {
        return BeanHelper.convert(cityManager.findById(id), CityVO.class);
    }

    /**
     * id获取所有的 CityVO
     *
     * @param id id
     * @return List<CityVO>
     */
    @Override
    public List<CityVO> findAllById(Integer id)
    {
        return BeanHelper.convert(cityManager.findAllByParentId(id), CityVO.class);
    }

    /**
     * 分页获取
     *
     * @param page page
     * @param size size
     * @return PageVO<CityVO>
     */
    @Override
    public PageVO<CityVO> findAll(Integer page, Integer size)
    {
        return cityManager.findPage(page, size);
    }

    /**
     * findAll
     *
     * @return List<CityVO>
     */
    @Override
    public List<CityVO> findAll()
    {
        return cityManager.findAll();
    }

    /**
     * 分页获取
     *
     * @param id   id
     * @param page page
     * @param size size
     * @return PageVO<CityVO>
     */
    @Override
    public PageVO<CityVO> findPageById(Integer id, Integer page, Integer size)
    {
        return cityManager.findPageById(id, page, size);
    }

    /**
     * 获取父级最后添加的城市
     *
     * @param parentId parentId
     * @return CityVO
     */
    @Override
    public CityVO findLastByParentId(Integer parentId)
    {
        return BeanHelper.convert(cityManager.findLastByParentId(parentId), CityVO.class);
    }

    /**
     * 更新
     *
     * @param cites cites
     * @return Integer
     */
    @Override
    public Integer updateAll(CityVO[] cites)
    {
        return cityManager.updateAll(cites);
    }
}
