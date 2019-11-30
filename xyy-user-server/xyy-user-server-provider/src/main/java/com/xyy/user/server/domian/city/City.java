package com.xyy.user.server.domian.city;

import com.baomidou.mybatisplus.annotation.*;
import com.xyy.framework.mybaites.plus.domain.base.BaseEntity;

import java.io.Serializable;

/**
 * 城市
 *
 * @author chentudong
 * @date 2019/11/16 21:20
 * @since 1.0
 */
@TableName("tb_city")
public class City extends BaseEntity<City>
{
    private static final long serialVersionUID = 7676625814525533828L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * parentId
     */
    @TableField(value = "parent_id")
    private Integer parentId;

    /**
     * 排序
     */
    @TableField(value = "sort", condition = "int(20) default 0 ")
    private Integer sort;

    /**
     * cityCode
     */
    @TableField(value = "city_code")
    private String cityCode;

    /**
     * cityCode
     */
    @TableField(value = "post_code", strategy = FieldStrategy.NOT_NULL)
    private String postCode;

    /**
     * name
     */
    @TableField(value = "city_name", strategy = FieldStrategy.NOT_NULL)
    private String cityName;

    public static final String PARENT_ID = "parent_id";
    public static final String CITY_CODE = "city_code";
    public static final String POST_CODE = "post_code";
    public static final String CITY_NAME = "city_name";
    public static final String SORT = "sort";

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

    public Integer getSort()
    {
        return sort;
    }

    public void setSort(Integer sort)
    {
        this.sort = sort;
    }

    public String getCityCode()
    {
        return cityCode;
    }

    public void setCityCode(String cityCode)
    {
        this.cityCode = cityCode;
    }

    public String getPostCode()
    {
        return postCode;
    }

    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }

    public String getCityName()
    {
        return cityName;
    }

    public void setCityName(String cityName)
    {
        this.cityName = cityName;
    }

    @Override
    protected Serializable pkVal()
    {
        return id;
    }
}
