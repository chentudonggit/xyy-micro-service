package com.xyy.user.consumer.service.city;

import com.xyy.framework.common.utils.format.DateFormatUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * CityServiceImplTest
 *
 * @author chentudong
 * @date 2019/11/17 1:25
 * @since 1.0
 */
//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
public class CityServiceImplTest
{
    @Test
    public void test()
    {
        Date now = new Date();
        Date date = DateFormatUtils.setMinute(now, -10);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(now));
        System.out.println(sdf.format(date));
    }
}