package com.xyy.user.server.vo.city;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * CityVO
 *
 * @author chentudong
 * @date 2019/11/16 21:36
 * @since 1.0
 */
public class CityVO implements Serializable
{
    private static final long serialVersionUID = -2719170201514326705L;

    /**
     * id
     */
    @JSONField(name = "id")
    private Integer id;

    /**
     * parentId
     */
    @JSONField(name = "parent_id")
    private Integer parentId;

    /**
     * postCode
     */
    @JSONField(name = "post_code")
    private String postCode;

    /**
     * cityCode
     */
    @JSONField(name = "city_code")
    private String cityCode;

    /**
     * 排序
     */
    @JSONField(name = "sort")
    private Integer sort;

    /**
     * name
     */
    @JSONField(name = "city_name")
    private String cityName;

    /**
     * childes
     */
    @JSONField(name = "children")
    private List<CityVO> children;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getParentId()
    {
        return parentId;
    }

    public void setParentId(Integer parentId)
    {
        this.parentId = parentId;
    }

    public String getPostCode()
    {
        return postCode;
    }

    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }

    public String getCityCode()
    {
        return cityCode;
    }

    public void setCityCode(String cityCode)
    {
        this.cityCode = cityCode;
    }

    public Integer getSort()
    {
        return sort;
    }

    public void setSort(Integer sort)
    {
        this.sort = sort;
    }

    public String getCityName()
    {
        return cityName;
    }

    public void setCityName(String cityName)
    {
        this.cityName = cityName;
    }

    public List<CityVO> getChildren()
    {
        return children;
    }

    public void setChildren(List<CityVO> children)
    {
        this.children = children;
    }
}
