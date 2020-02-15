package com.assessment2.controller;

import com.assessment2.pojo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class TemperatureController {

    @Autowired
    public RestTemplate restTemplate;

    @RequestMapping("/getForecast/{cityName}")
    public @ResponseBody
    ResponseEntity getForecast(@PathVariable String cityName){
        Response response;
        try{
            response = restTemplate.getForObject("https://openweathermap.org/data/2.5/forecast?q="+cityName+",356&appid=b6907d289e10d714a6e88b30761fae22", Response.class);
            this.getSuggestion(response);
        }catch ( Exception e){
            return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

    private void getSuggestion(Response response){
String suggestion;
        for(int i =0; i< 3; i++){
            if( 40 < (response.getList().get(i).getMain()).getTemp()){
                response.setSuggestion("Use sunscreen lotion");
            }else if(response.getList().get(i).getRain() != null){
                response.setSuggestion("Carry Umbrella");
            }
        }
    }


}
