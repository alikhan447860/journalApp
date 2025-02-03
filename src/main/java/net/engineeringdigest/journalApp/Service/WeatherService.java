package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.Cache.AppCache;
import net.engineeringdigest.journalApp.api.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Watchable;

@Component
public class WeatherService {
   @Value("${Weather.api.key}")
   private     String apikey;
    private  static  final String API="http://api.weatherstack.com/current?access_key=API_KEY&query=CITY";
@Autowired
    private RestTemplate restTemplate;
@Autowired
private AppCache appCache;
    public  WeatherResponse getWeather(String city){
        String finalAPI=appCache.appcache.get(AppCache.keys.WEATHER_API.toString()).replace("CITY",city).replace("API_KEY",apikey);
    ResponseEntity<WeatherResponse>response =restTemplate.exchange(finalAPI, HttpMethod.GET,null , WeatherResponse.class);
WeatherResponse body=response.getBody();
return body;
    }
}
