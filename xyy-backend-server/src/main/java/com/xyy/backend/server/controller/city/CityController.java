package com.xyy.backend.server.controller.city;

import com.xyy.framework.web.response.ResponseResult;
import com.xyy.weather.client.city.CityClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CityController
 *
 * @author chentudong
 * @date 2019/11/17 12:59
 * @since 1.0
 */
@RestController
@RequestMapping("city")
public class CityController
{
    private final CityClient cityClient;

    public CityController(CityClient cityClient)
    {
        this.cityClient = cityClient;
    }

    /**
     * 分页
     *
     * @param page page
     * @param size size
     * @return ResponseResult
     */
    @GetMapping("findPage")
    public ResponseResult findPage(Integer page, Integer size)
    {
        return ResponseResult.data(cityClient.findAll(page, size));
    }

    /**
     * findAll
     * @return ResponseResult
     */
    @GetMapping("findAll")
    public ResponseResult findAll()
    {
        return ResponseResult.data(cityClient.findAll());
    }
}
