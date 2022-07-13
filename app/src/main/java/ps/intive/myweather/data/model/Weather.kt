package ps.intive.myweather.data.model

data class Weather(
    val location: Location,
    val current: Current,
    val forecast: Forecast
)

data class Location(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double
)

data class Current(
    val temp_c: Double,
    val temp_f: Double,
    val condition: Condition
)

data class Condition(
    val text: String,
    val icon: String,
    val wind_mph: Double,
    val wind_kph: Double,
    val wind_degree: Double,
    val wind_dir: Double,
    val pressure_mb: Double,
    val pressure_in: Double,
    val precip_mm: Double,
    val precip_in: Double,
    val humidity: Double
)
