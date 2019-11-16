package com.xyy.user.server.domian.user;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 *
 * @author chentudong
 * @date 2019/9/14 22:23
 * @since 1.0
 */
public class User implements Serializable
{
    private static final long serialVersionUID = -2321943843128791394L;
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

    public User()
    {
    }

    public User(String id, String userName, String phone, String passWord, Date createTime, Date modifyTime)
    {
        this.id = id;
        this.userName = userName;
        this.phone = phone;
        this.passWord = passWord;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

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
