package com.xyy.user.server.domian.city;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 城市
 *
 * @author chentudong
 * @date 2019/11/16 21:20
 * @since 1.0
 */
@TableName("tb_city")
public class City extends Model<City> implements Serializable
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
     * status
     */
    @TableLogic
    @TableField(value = "status", condition = "int(5) default 0 ", fill = FieldFill.INSERT)
    private Integer status;

    /**
     * 排序
     */
    @TableField(value = "sort", condition = "int(20) default 0 ")
    private Integer sort;

    /**
     * cityCode
     */
    @TableField(value = "city_code", strategy = FieldStrategy.NOT_NULL)
    private String cityCode;

    /**
     * name
     */
    @TableField(value = "city_name", strategy = FieldStrategy.NOT_NULL)
    private String cityName;

    /**
     * remark
     */
    @TableField("remark")
    private String remark;

    /**
     * createTime
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * updateTime
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    public static final String PARENT_ID = "parent_id";
    public static final String CITY_CODE = "city_code";
    public static final String STATUS = "status";
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

    public String getCityCode()
    {
        return cityCode;
    }

    public void setCityCode(String cityCode)
    {
        this.cityCode = cityCode;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
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

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }

    @Override
    protected Serializable pkVal()
    {
        return id;
    }
}
