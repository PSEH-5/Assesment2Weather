package com.sapient;

import com.assessment2.controller.TemperatureController;
import com.assessment2.pojo.City;
import com.assessment2.pojo.Forecast;
import com.assessment2.pojo.Main;
import com.assessment2.pojo.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RunWith(PowerMockRunner.class)
public class TemperatureControllerTest {

    @Mock
    TemperatureController temperatureController;

    @Mock
    RestTemplate restTemplate;

    @Before
    public void init(){
        temperatureController.restTemplate = this.restTemplate;
    }

    @Test
    public void getForecastTestSuccess(){
        Response expected = new Response();
        Forecast f = new Forecast();
        f.setMain( new Main());
        List l = new ArrayList<>();
        l.add(f);
        expected.setList(l);
        //Mockito.when(temperatureController.restTemplate(Mockito.anyString(),Object.class)).thenReturn( expected );
        ResponseEntity response = temperatureController.getForecast("Mumbai");
        Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
    }

    @Test
    public void getForecastTestFailure(){

        ResponseEntity response = temperatureController.getForecast("/");
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,response.getStatusCode());
    }
}
