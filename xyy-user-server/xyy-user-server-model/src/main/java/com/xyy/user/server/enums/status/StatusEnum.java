package com.xyy.user.server.enums.status;

import java.util.Objects;

/**
 * 状态
 *
 * @author chentudong
 * @date 2019/11/16 21:23
 * @since 1.0
 */
public enum StatusEnum
{
    /**
     * 启用
     */
    Enable(1, "启用"),

    /**
     * 禁用
     */
    Disable(0, "禁用");

    /**
     * code
     */
    private Integer code;

    /**
     * message
     */
    private String message;


    StatusEnum(int code, String message)
    {
        this.code = code;
        this.message = message;
    }

    public Integer getCode()
    {
        return code;
    }

    public void setCode(Integer code)
    {
        this.code = code;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public static StatusEnum value(Integer key)
    {
        if(Objects.isNull(key))
        {
            return null;
        }
        switch (key)
        {
            case 1:
                return StatusEnum.Enable;
            case 0:
                return StatusEnum.Disable;
            default:
                return null;
        }
    }
}
