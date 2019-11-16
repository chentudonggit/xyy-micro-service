package com.xyy.user.server.vo.city;

import com.alibaba.fastjson.annotation.JSONField;
import com.xyy.user.server.enums.status.StatusEnum;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

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
     * status
     */
    @JSONField(name = "status")
    private StatusEnum status;

    /**
     * name
     */
    @JSONField(name = "city_name")
    private String cityName;

    /**
     * remark
     */
    @JSONField(name = "remark")
    private String remark;

    /**
     * createTime
     */
    @JSONField(name = "create_time")
    private Date createTime;

    /**
     * updateTime
     */
    @JSONField(name = "update_time")
    private Date updateTime;

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

    public Integer getSort()
    {
        return Objects.isNull(sort) ? 0 : sort;
    }

    public void setSort(Integer sort)
    {
        this.sort = sort;
    }

    public StatusEnum getStatus()
    {
        return status;
    }

    public void setStatus(StatusEnum status)
    {
        this.status = status;
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
}
