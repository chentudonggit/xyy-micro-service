package com.xyy.weather.provider.scheduled;

import com.xyy.weather.provider.common.weather.parsing.CityInfoDTO;
import com.xyy.weather.provider.common.weather.parsing.CityWeatherDTO;
import com.xyy.weather.provider.common.weather.parsing.ParsingDTO;
import com.xyy.weather.provider.common.weather.parsing.forecast.CityForecastDTO;
import com.xyy.weather.provider.domain.city.City;
import com.xyy.weather.provider.manager.city.CityManager;
import com.xyy.weather.provider.remote.request.weather.WeatherRemoteRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * WeatherScheduled
 * 主要用于标记配置类，兼备Component的效果
 *
 * @author chentudong
 * @date 2019/11/30 15:05
 * @since 1.0
 */
@Component
@Configuration
public class WeatherScheduled
{
    private final WeatherRemoteRequest weatherRemoteRequest;
    private final CityManager cityManager;

    public WeatherScheduled(WeatherRemoteRequest weatherRemoteRequest, CityManager cityManager)
    {
        this.weatherRemoteRequest = weatherRemoteRequest;
        this.cityManager = cityManager;
    }

    @Scheduled(cron = "0/5 * * * * ?")
    private void configureTasks()
    {
        //获取数据库里面的所有的城市数据
        List<City> cities = cityManager.findCityCodeNotNull();
        if (!cities.isEmpty())
        {
            for (City city : cities)
            {
                ParsingDTO parsing = weatherRemoteRequest.findByCityCode(city.getCityCode());
                if(Objects.nonNull(parsing))
                {
                    CityInfoDTO cityInfo = parsing.getCity();
                    CityWeatherDTO cityWeather = parsing.getCityWeather();
                    if(Objects.nonNull(cityWeather))
                    {
                        CityForecastDTO yesterday = cityWeather.getYesterday();
                        if(Objects.nonNull(yesterday))
                        {
                            //
                        }
                        List<CityForecastDTO> forecasts = cityWeather.getForecasts();
                        if(Objects.nonNull(forecasts) && (!forecasts.isEmpty()))
                        {
                            //
                        }
                    }
                }
            }
        }
    }
}
