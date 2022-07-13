package ps.intive.myweather.data.remote

import ps.intive.myweather.data.model.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    @GET("current.json")
    //TODO key should come from an interceptor
    suspend fun getWeather(
        @Query("key") key: String,
        @Query("q") lat: String
    ): Response<Weather>

    @GET("forecast.json")
    //TODO key should come from an interceptor
    suspend fun getForecast(
        @Query("key") key: String,
        @Query("q") lat: String,
        @Query("days") days: Int
    ): Response<Weather>
}