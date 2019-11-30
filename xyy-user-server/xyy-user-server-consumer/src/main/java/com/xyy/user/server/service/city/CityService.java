package com.xyy.user.server.service.city;

import com.xyy.framework.common.builder.page.PageVO;
import com.xyy.user.server.vo.city.CityVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * CityService
 *
 * @author chentudong
 * @date 2019/11/16 21:35
 * @since 1.0
 */
@RequestMapping("cityService")
public interface CityService
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
    @RequestMapping("save")
    CityVO save(@RequestParam("id") Integer id,
                @RequestParam("parentId") Integer parentId,
                @RequestParam("sort") Integer sort,
                @RequestParam("cityCode") String cityCode,
                @RequestParam("postCode") String postCode,
                @RequestParam("cityName") String cityName,
                @RequestParam("remark") String remark);


    /**
     * id 获取 CityVO
     *
     * @param id id
     * @return CityVO
     */
    @RequestMapping("findById")
    CityVO findById(@RequestParam("id") Integer id);

    /**
     * id获取所有的 CityVO
     *
     * @param id id
     * @return List<CityVO>
     */
    @RequestMapping("findAllById")
    List<CityVO> findAllById(@RequestParam("id") Integer id);

    /**
     * 分页获取
     *
     * @param page page
     * @param size size
     * @return PageVO<CityVO>
     */
    @RequestMapping("findAllPage")
    PageVO<CityVO> findAll(@RequestParam("page") Integer page,
                           @RequestParam("size") Integer size);

    /**
     * findAll
     *
     * @return List<CityVO>
     */
    @RequestMapping("findAll")
    List<CityVO> findAll();

    /**
     * 分页获取
     *
     * @param id   id
     * @param page page
     * @param size size
     * @return PageVO<CityVO>
     */
    @RequestMapping("findPageById")
    PageVO<CityVO> findPageById(@RequestParam("id") Integer id,
                                @RequestParam("page") Integer page,
                                @RequestParam("size") Integer size);

    /**
     * 获取父级最后添加的城市
     *
     * @param parentId parentId
     * @return CityVO
     */
    @RequestMapping("findLastByParentId")
    CityVO findLastByParentId(@RequestParam("parentId") Integer parentId);

    /**
     * 更新
     *
     * @param cites cites
     * @return Integer
     */
    @RequestMapping("updateAll")
    Integer updateAll(@RequestBody CityVO[] cites);
}
