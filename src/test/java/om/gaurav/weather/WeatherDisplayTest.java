package om.gaurav.weather;

import com.gaurav.weather.WeatherController;
import com.gaurav.weather.WeatherInput;
import com.gaurav.weather.WeatherInputService;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.verification.Times;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: gaurav
 * Date: 6/8/13
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class WeatherDisplayTest {

    private WeatherController weatherController;
    private WeatherInputService weatherInputService;

    @Before
    public void setup(){

        weatherInputService = mock(WeatherInputService.class);
        weatherController = new WeatherController();
        weatherController.setWeatherInputService(weatherInputService);



    }
    @Test
    public void displayWeatherDuringDay(){

        WeatherInput weatherInput = new WeatherInput();

        weatherInput.setDay(true);


        given(weatherInputService.getWeatherInput()).willReturn(weatherInput);

        List<String> expectedWeatherDetails = new ArrayList<String>();
        expectedWeatherDetails.add("Sun");

        List<String> actualWeatherDetails = weatherController.getWeatherDetails();

        Assert.assertEquals(expectedWeatherDetails,actualWeatherDetails);

    }
    @Test
    public void displayWeatherDuringNight(){

        WeatherInput weatherInput = new WeatherInput();

        weatherInput.setNight(true);

        given(weatherInputService.getWeatherInput()).willReturn(weatherInput);
        List<String> expectedWeatherDetails = new ArrayList<String>();
        expectedWeatherDetails.add("Moon");

        List<String> actualWeatherDetails = weatherController.getWeatherDetails();


        Assert.assertEquals(expectedWeatherDetails,actualWeatherDetails);

    }

    @Test
    public void displayWeatherDuringCloudyDay(){
        WeatherInput weatherInput = new WeatherInput();

        weatherInput.setDay(true);
        weatherInput.setCloud(true);

        given(weatherInputService.getWeatherInput()).willReturn(weatherInput);
        List<String> expectedWeatherDetails = new ArrayList<String>();
        expectedWeatherDetails.add("Sun");
        expectedWeatherDetails.add("Cloud");


        List<String> actualWeatherDetails = weatherController.getWeatherDetails();


        Assert.assertEquals(expectedWeatherDetails,actualWeatherDetails);
    }

    @Test
    public void displayWeatherDuringCloudyRainyDay(){
        WeatherInput weatherInput = new WeatherInput();

        weatherInput.setDay(true);
        weatherInput.setCloud(true);
        weatherInput.setRainy(true);
        given(weatherInputService.getWeatherInput()).willReturn(weatherInput);
        List<String> expectedWeatherDetails = new ArrayList<String>();
        expectedWeatherDetails.add("Sun");
        expectedWeatherDetails.add("Cloud");
        expectedWeatherDetails.add("Raining");

        verify(weatherInputService,times(1)).getWeatherInput();
        List<String> actualWeatherDetails = weatherController.getWeatherDetails();


        Assert.assertEquals(expectedWeatherDetails,actualWeatherDetails);
    }

    @Test
    public void displayWeatherDuringCloudyNight(){
        WeatherInput weatherInput = new WeatherInput();

        weatherInput.setNight(true);
        weatherInput.setCloud(true);
        given(weatherInputService.getWeatherInput()).willReturn(weatherInput);
        List<String> expectedWeatherDetails = new ArrayList<String>();
        expectedWeatherDetails.add("Moon");
        expectedWeatherDetails.add("Cloud");


        List<String> actualWeatherDetails = weatherController.getWeatherDetails();


        Assert.assertEquals(expectedWeatherDetails,actualWeatherDetails);
    }

}
