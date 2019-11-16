package com.xyy.user.server.service.city;

import com.xyy.framework.common.builder.page.PageVO;
import com.xyy.framework.common.helper.BeanHelper;
import com.xyy.user.server.manager.city.CityManager;
import com.xyy.user.server.vo.city.CityVO;
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
     * @param cityCode 城市代码
     * @param cityName 城市名称
     * @param remark   备注
     * @return CityVO
     */
    @Override
    public CityVO save(Integer id, Integer parentId, String cityCode, String cityName, String remark)
    {
        return BeanHelper.convert(cityManager.save(id, parentId, cityCode, cityName, remark), CityVO.class);
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
        return null;
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
        return null;
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
        return null;
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
}
