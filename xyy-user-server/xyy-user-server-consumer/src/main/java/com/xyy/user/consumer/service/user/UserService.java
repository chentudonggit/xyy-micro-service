package com.xyy.user.consumer.service.user;

import com.xyy.user.model.vo.user.UserVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户服务
 *
 * @author chentudong
 * @date 2019/9/14 22:39
 * @since 1.0
 */
@RequestMapping("userService")
public interface UserService
{
    /**
     * 保存用户
     *
     * @param userName userName
     * @param phone    phone
     * @param passWord passWord
     * @return UserVO
     */
    @RequestMapping("save")
    UserVO save(@RequestParam("userName") String userName,
                @RequestParam("phone") String phone,
                @RequestParam("passWord") String passWord);

    /**
     * 更新用户
     *
     * @param id       id
     * @param userName userName
     * @param phone    phone
     * @param passWord passWord
     * @return UserVO
     */
    @RequestMapping("update")
    UserVO update(@RequestParam("id") String id,
                  @RequestParam("userName") String userName,
                  @RequestParam("phone") String phone,
                  @RequestParam("passWord") String passWord);

    /**
     * id 获取用户
     *
     * @param id id
     * @return findById
     */
    @RequestMapping("findById")
    UserVO findById(@RequestParam("id") String id);

    /**
     * 用户名获取用户
     *
     * @param userName userName
     * @return UserVO
     */
    @RequestMapping("findByUserName")
    UserVO findByUserName(@RequestParam("userName") String userName);

    /**
     * 手机号获取用户
     *
     * @param phone phone
     * @return UserVO
     */
    @RequestMapping("findByPhone")
    UserVO findByPhone(@RequestParam("phone") String phone);
}
