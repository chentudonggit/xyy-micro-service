package com.xyy.backend.server.controller.user;

import com.xyy.framework.web.response.ResponseResult;
import com.xyy.user.consumer.server.client.user.UserClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 *
 * @author chentudong
 * @date 2019/9/15 12:22
 * @since 1.0
 */
@RestController
@RequestMapping("user")
public class UserController
{
    private final UserClient userClient;

    public UserController(UserClient userClient)
    {
        this.userClient = userClient;
    }

    /**
     * id 获取用户
     * @param id id
     * @return ResponseResult
     */
    @RequestMapping("findById")
    public ResponseResult findById(String id)
    {
        return ResponseResult.data(userClient.findById(id));
    }
}
