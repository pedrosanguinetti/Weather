package ps.intive.myweather.data.repository

import ps.intive.myweather.data.model.Forecast
import ps.intive.myweather.data.model.Weather
import ps.intive.myweather.data.remote.WeatherAPI
import retrofit2.Response
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val weatherAPI: WeatherAPI) :
    WeatherRepository {

    companion object {

        //TODO move this to the BuildConfig
        const val WEATHER_API_ID = "eae031cfa13342449a5171321221307"

        //TODO Lat and lon should come as parameters. Should get these from the GPS and pass this data to the API
        const val COUNTRY = "London"
    }

    override suspend fun getCurrent(): Response<Weather> {
        return weatherAPI.getWeather(WEATHER_API_ID, COUNTRY)
    }

    override suspend fun getForecast(): Response<Weather> {
        //TODO move this to the constants
        return weatherAPI.getForecast(WEATHER_API_ID, COUNTRY, 10)
    }
}