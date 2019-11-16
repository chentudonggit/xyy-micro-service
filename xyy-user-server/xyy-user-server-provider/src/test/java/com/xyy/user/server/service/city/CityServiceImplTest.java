package com.xyy.user.server.service.city;

import com.alibaba.fastjson.JSON;
import com.xyy.user.server.vo.city.CityVO;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * CityServiceImplTest
 *
 * @author chentudong
 * @date 2019/11/17 1:25
 * @since 1.0
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CityServiceImplTest
{
    @Autowired
    private CityService cityService;

    class City
    {
        private String cityName;
        private String cityCode;
        private Integer sort;
        private List<City> cities = new ArrayList<>();

        public City(String cityName, String cityCode, Integer sort)
        {
            this.cityName = cityName;
            this.cityCode = cityCode;
            this.sort = sort;
        }

        public String getCityName()
        {
            return cityName;
        }

        public void setCityName(String cityName)
        {
            this.cityName = cityName;
        }

        public String getCityCode()
        {
            return cityCode;
        }

        public void setCityCode(String cityCode)
        {
            this.cityCode = cityCode;
        }

        public List<City> getCities()
        {
            return cities;
        }

        public void setCities(List<City> cities)
        {
            this.cities = cities;
        }

        public Integer getSort()
        {
            return sort;
        }

        public void setSort(Integer sort)
        {
            this.sort = sort;
        }

        @Override
        public String toString()
        {
            return "City{" +
                    "cityName='" + cityName + '\'' +
                    ", cityCode='" + cityCode + '\'' +
                    ", sort=" + sort +
                    ", cities=" + cities +
                    '}';
        }
    }

    @Test
    public void save() throws IOException, JDOMException
    {

        List<City> cities = new ArrayList<>();
        SAXBuilder saxBuilder = new SAXBuilder();
        //2.创建输入流
        InputStream is = new FileInputStream(new File("src/main/resources/city.xml"));
        //3.将输入流加载到build中
        Document document = saxBuilder.build(is);
        //4.获取根节点
        Element rootElement = document.getRootElement();
        //5.获取子节点
        List<Element> children = rootElement.getChildren("province");
        int i = 0;
        for (Element child : children)
        {
            City city = new City(child.getAttribute("name").getValue(), child.getAttribute("postcode").getValue(), i++);
            List<Element> cityChildren = child.getChildren("city");
            int j = 0;
            for (Element eCityChild : cityChildren)
            {
                City cityChild = new City(eCityChild.getAttribute("name").getValue(), eCityChild.getAttribute("postcode").getValue(), j++);
                List<Element> areaChildren = eCityChild.getChildren("area");
                int k = 0;
                for (Element eAreaChild : areaChildren)
                {
                    City areaChild = new City(eAreaChild.getAttribute("name").getValue(), eAreaChild.getAttribute("postcode").getValue(), k++);
                    cityChild.cities.add(areaChild);
                }
                city.cities.add(cityChild);
            }
            cities.add(city);
        }
//        Integer id = null;
//        Integer parentId = null;
//        String cityCode = null;
//        String cityName = null;
//        String remark = null;
//        cityService.save(id, parentId, cityCode, cityName, remark);
        String jsonString = JSON.toJSONString(cities);
        System.out.println(jsonString);
        for (City city : cities)
        {
            int p = 0;
            city(city, p);
        }
    }

    public void city(City city, int parentId)
    {
        List<City> cities = city.getCities();
        String cityName = city.getCityName();
        String cityCode = city.getCityCode();
        CityVO cityVO = cityService.save(null, parentId, cityCode, cityName, "名称：" + cityName + "，编码：" + cityCode);
        if (!cities.isEmpty())
        {
            parentId = cityVO.getId();
            for (City city1 : cities)
            {
                city(city1, parentId);
            }
        }
    }
}