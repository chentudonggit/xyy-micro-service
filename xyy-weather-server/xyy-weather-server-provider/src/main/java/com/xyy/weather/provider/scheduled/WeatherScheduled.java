package com.xyy.weather.provider.scheduled;

import com.xyy.weather.model.enums.DayTypeEnum;
import com.xyy.weather.provider.common.weather.parsing.CityWeatherDTO;
import com.xyy.weather.provider.common.weather.parsing.ParsingDTO;
import com.xyy.weather.provider.common.weather.parsing.forecast.CityForecastDTO;
import com.xyy.weather.provider.domain.city.City;
import com.xyy.weather.provider.domain.weather.CityWeather;
import com.xyy.weather.provider.domain.weather.forecast.CityForecast;
import com.xyy.weather.provider.manager.city.CityManager;
import com.xyy.weather.provider.manager.weather.CityWeatherManager;
import com.xyy.weather.provider.manager.weather.forecast.CityForecastManager;
import com.xyy.weather.provider.remote.request.weather.WeatherRemoteRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Random;

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
    private static Random random = new Random();
    private final WeatherRemoteRequest weatherRemoteRequest;
    private final CityManager cityManager;
    private final CityWeatherManager cityWeatherManager;
    private final CityForecastManager cityForecastManager;

    public WeatherScheduled(WeatherRemoteRequest weatherRemoteRequest, CityManager cityManager,
                            CityWeatherManager cityWeatherManager, CityForecastManager cityForecastManager)
    {
        this.weatherRemoteRequest = weatherRemoteRequest;
        this.cityManager = cityManager;
        this.cityWeatherManager = cityWeatherManager;
        this.cityForecastManager = cityForecastManager;
    }

    //@Scheduled(cron = "0/20 * * * * ?")
    public void configureTasks()
    {
        //获取数据库里面的所有的城市数据
        List<City> cities = cityManager.findCityCodeNotNull();
        if (!cities.isEmpty())
        {
            for (City city : cities)
            {
                try
                {
                    int nextInt = random.nextInt(100000);
                    System.out.println("睡眠 "+nextInt/1000/60+" 分钟");
                    Thread.sleep(nextInt);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
                ParsingDTO parsing = weatherRemoteRequest.findByCityCode(city.getCityCode());
                if (Objects.nonNull(parsing))
                {
                    CityWeatherDTO cityWeather = parsing.getCityWeather();
                    Integer cityId = city.getId();
                    if (Objects.nonNull(cityWeather))
                    {
                        CityWeather weather = cityWeatherManager.save(cityId, cityWeather.getHumidity(), cityWeather.getPm25(), cityWeather.getPm10(),
                                cityWeather.getQuality(), cityWeather.getTemperature(), cityWeather.getRemark(), false);
                        CityForecastDTO yesterday = cityWeather.getYesterday();
                        String weatherId = weather.getId();
                        int sort = 0;
                        if (Objects.nonNull(yesterday))
                        {
                            CityForecast forecast = cityForecastManager.save(weatherId, cityId, yesterday.getHigh(), yesterday.getLow(),
                                    yesterday.getWeek(), yesterday.getSunrise(), yesterday.getSunset(), yesterday.getWinDirection(),
                                    yesterday.getWindPower(), yesterday.getType(), yesterday.getAqi(), yesterday.getYmd(), yesterday.getNotice(), sort, DayTypeEnum.Yesterday.getCode());
                            sort = forecast.getSort();
                        }
                        List<CityForecastDTO> forecasts = cityWeather.getForecasts();
                        if (Objects.nonNull(forecasts) && (!forecasts.isEmpty()))
                        {
                            for (CityForecastDTO forecast : forecasts)
                            {
                                CityForecast forecastq = cityForecastManager.save(weatherId, cityId, forecast.getHigh(), forecast.getLow(),
                                        forecast.getWeek(), forecast.getSunrise(), forecast.getSunset(), forecast.getWinDirection(),
                                        forecast.getWindPower(), forecast.getType(), forecast.getAqi(), forecast.getYmd(), forecast.getNotice(), sort, DayTypeEnum.Future.getCode());
                                sort = forecastq.getSort();
                            }
                        }
                    }
                }
            }
        }
    }
}
