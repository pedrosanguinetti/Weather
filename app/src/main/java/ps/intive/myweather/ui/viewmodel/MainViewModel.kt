package ps.intive.myweather.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import ps.intive.myweather.data.model.Weather
import ps.intive.myweather.data.repository.WeatherRepository
import ps.intive.myweather.ui.model.Resource
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val weatherRepository: WeatherRepository) :
    ViewModel() {

    /**
     * @return current weather from London. Should implement a feature to select or detect the user location
     */
    fun getCurrentWeather() =
        liveData<Resource<Weather>>(viewModelScope.coroutineContext + Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                val result = weatherRepository.getCurrent()
                emit(Resource.Result(result.body() as Weather))
            } catch (e: Exception) {
                emit(Resource.Error(e))
            }
        }

    /**
     * @return the forecast limited to 10 days. The API might be returning less than 10 items.
     */
    fun getForecast() =
        liveData<Resource<Weather>>(viewModelScope.coroutineContext + Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                val result = weatherRepository.getForecast()
                emit(Resource.Result(result.body() as Weather))
            } catch (e: Exception) {
                emit(Resource.Error(e))
            }
        }
}