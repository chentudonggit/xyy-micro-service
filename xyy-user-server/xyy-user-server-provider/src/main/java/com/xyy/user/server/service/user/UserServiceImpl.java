package com.xyy.user.server.service.user;

import com.xyy.user.server.vo.user.UserVO;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserServiceImpl
 *
 * @author chentudong
 * @date 2019/9/14 22:57
 * @since 1.0
 */
@RestController
public class UserServiceImpl implements UserService
{
    /**
     * 保存用户
     *
     * @param userName userName
     * @param phone    phone
     * @param passWord passWord
     * @return UserVO
     */
    @Override
    public UserVO save(String userName, String phone, String passWord)
    {
        return null;
    }

    /**
     * 更新用户
     *
     * @param id       id
     * @param userName userName
     * @param phone    phone
     * @param passWord passWord
     * @return UserVO
     */
    @Override
    public UserVO update(String id, String userName, String phone, String passWord)
    {
        return null;
    }

    /**
     * id 获取用户
     *
     * @param id id
     * @return findById
     */
    @Override
    public UserVO findById(String id)
    {
        return null;
    }

    /**
     * 用户名获取用户
     *
     * @param userName userName
     * @return UserVO
     */
    @Override
    public UserVO findByUserName(String userName)
    {
        return null;
    }

    /**
     * 手机号获取用户
     *
     * @param phone phone
     * @return UserVO
     */
    @Override
    public UserVO findByPhone(String phone)
    {
        return null;
    }
}
