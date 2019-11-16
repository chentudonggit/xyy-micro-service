package com.xyy.user.server.config.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.xyy.user.server.enums.status.StatusEnum;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;
import java.util.Objects;

/**
 * 自动填充
 *
 * @author chentudong
 * @date 2019/11/17 2:17
 * @since 1.0
 */
public class BaseMetaObjectHandler implements MetaObjectHandler
{
    @Override
    public void insertFill(MetaObject metaObject)
    {
        Date now = new Date();
        this.setFieldValByName("createTime", now, metaObject);
        this.setFieldValByName("updateTime", now, metaObject);
        Object status = this.getFieldValByName("status", metaObject);
        Object parentId = this.getFieldValByName("parentId", metaObject);
        if (Objects.isNull(status))
        {
            this.setFieldValByName("status", StatusEnum.Enable.getCode(), metaObject);
        }
        if (Objects.isNull(parentId))
        {
            this.setFieldValByName("parentId", 0, metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject)
    {
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
