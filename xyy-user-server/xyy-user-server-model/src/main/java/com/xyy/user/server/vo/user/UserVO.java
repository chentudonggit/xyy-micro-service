package com.xyy.user.server.vo.user;

import com.xyy.user.server.model.user.User;

import java.util.Date;

/**
 * UserVO
 *
 * @author chentudong
 * @date 2019/9/14 22:42
 * @since 1.0
 */
public class UserVO extends User
{
    private static final long serialVersionUID = 4438205142498359379L;

    public UserVO()
    {
    }

    public UserVO(String id, String userName, String phone, String passWord, Date createTime, Date modifyTime)
    {
        super(id, userName, phone, passWord, createTime, modifyTime);
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}
