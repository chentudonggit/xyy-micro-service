package com.xyy.user.model.vo.user;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * UserVO
 *
 * @author chentudong
 * @date 2019/9/14 22:42
 * @since 1.0
 */
public class UserVO implements Serializable
{
    private static final long serialVersionUID = 4438205142498359379L;

    /**
     * id
     */
    @JSONField(name="id")
    private String id;

    /**
     * 用户名
     */
    @JSONField(name="user_name")
    private String userName;

    /**
     * 手机号（登录账号）
     */
    @JSONField(name="phone")
    private String phone;

    /**
     * 密码
     */
    @JSONField(name="pass_word")
    private String passWord;

    /**
     * 创建时间
     */
    @JSONField(name="create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @JSONField(name="modify_time")
    private Date modifyTime;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPassWord()
    {
        return passWord;
    }

    public void setPassWord(String passWord)
    {
        this.passWord = passWord;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getModifyTime()
    {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime)
    {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", passWord='" + passWord + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
