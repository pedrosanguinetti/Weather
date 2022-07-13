package ps.intive.myweather.data.model

import java.util.Date

data class Forecast(val forecastday: List<ForecastDay>)

data class ForecastDay
    (
    val date: Date,
    val day: Day
)

data class Day
    (
    val maxtemp_f: Double,
    val mintemp_f: Double,
    val avghumidity: Double,
    val condition: Condition
)