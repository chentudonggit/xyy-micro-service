package com.xyy.weather.model.enums;

import java.util.Objects;

/**
 * DayTypeEnum
 *
 * @author chentudong
 * @date 2019/12/1 11:12
 * @since 1.0
 */
public enum DayTypeEnum
{
    /**
     * 昨天
     */
    Yesterday(0, "昨天"),

    /**
     * 今天
     */
    Today(1, "今天"),

    /**
     * 未来
     */
    Future(2, "未来");

    /**
     * code
     */
    private Integer code;

    /**
     * message
     */
    private String message;

    DayTypeEnum(Integer code, String message)
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

    public static DayTypeEnum value(Integer key)
    {
        if (Objects.isNull(key))
        {
            return null;
        }
        switch (key)
        {
            case 0:
                return Yesterday;
            case 1:
                return Today;
            case 2:
                return Future;
            default:
                return null;
        }
    }
}
