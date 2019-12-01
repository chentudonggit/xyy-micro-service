package com.xyy.weather.provider;

import com.xyy.weather.provider.scheduled.WeatherScheduled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

/**
 * WeatherServerMainTest
 *
 * @author chentudong
 * @date 2019/12/1 13:03
 * @since 1.0
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class WeatherServerMainTest
{
    private static Random random = new Random();
    @Autowired
    private WeatherScheduled weatherScheduled;

    @Test
    public void test()
    {
        weatherScheduled.configureTasks();
    }

    @Test
    public void next()
    {
        for (int i = 0; i < 100; i++)
        {
            System.out.println(random.nextInt(100000));
        }
    }
}