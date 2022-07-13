package ps.intive.myweather.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import ps.intive.myweather.databinding.ActivityMainBinding
import ps.intive.myweather.ui.model.Resource.Error
import ps.intive.myweather.ui.model.Resource.Loading
import ps.intive.myweather.ui.model.Resource.Result
import ps.intive.myweather.ui.viewmodel.MainViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initUI()
    }

    private fun initUI() {
        viewmodelRequests()

        binding.refresh.setOnRefreshListener {
            viewmodelRequests()
        }
    }

    private fun viewmodelRequests() {
        initForecast()
        initCurrentWeather()
    }

    private fun initForecast() {
        viewModel.getForecast().observe(this) {
            when (it) {
                is Loading -> {
                    binding.refresh.isRefreshing = true
                }
                is Error -> {
                    binding.refresh.isRefreshing = false
                    Toast.makeText(this, it.exception.message, Toast.LENGTH_LONG).show()
                }
                is Result -> {
                    binding.refresh.isRefreshing = false
                    val linearLayoutManager = LinearLayoutManager(this)
                    binding.forecastRv.layoutManager = linearLayoutManager
                    val adapter = ForecastAdapter(it.data.forecast.forecastday)
                    binding.forecastRv.adapter = adapter
                }
            }

        }
    }

    private fun initCurrentWeather() {
        viewModel.getCurrentWeather().observe(this) {
            when (it) {
                is Loading -> {
                    binding.refresh.isRefreshing = true
                }
                is Error -> {
                    binding.refresh.isRefreshing = false
                    Toast.makeText(this, it.exception.message, Toast.LENGTH_LONG).show()
                }
                is Result -> {
                    binding.refresh.isRefreshing = false
                    binding.countryLbl.text = "Weather from ${it.data.location.country}"
                    binding.tempLbl.text = "${it.data.current.temp_f} ºf"
                    binding.textLbl.text = "Today is ${it.data.current.condition.text}"
                    //TODO the url needs the base domain. The URL provided by the backend is not working, or some auth config is missing.
                    Picasso.get().load(it.data.current.condition.icon).into(binding.iconImg)
                }
            }

        }
    }
}