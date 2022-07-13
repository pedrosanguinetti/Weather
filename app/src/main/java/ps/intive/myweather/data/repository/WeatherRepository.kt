package ps.intive.myweather.data.repository

import ps.intive.myweather.data.model.Weather
import retrofit2.Response

interface WeatherRepository {

    /**
     * @return current weather from London. Should implement a feature to select or detect the user location
     */
    suspend fun getCurrent(): Response<Weather>

    /**
     * @return the forecast limited to 10 days. The API might be returning less than 10 items.
     */
    suspend fun getForecast(): Response<Weather>
}