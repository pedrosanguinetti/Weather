package ps.intive.myweather.ui.model

sealed class Resource<out T> {
    class Loading<out T> : Resource<T>()
    data class Result<out T>(val data: T) : Resource<T>()
    data class Error<out T>(val exception: Exception) : Resource<T>()
}