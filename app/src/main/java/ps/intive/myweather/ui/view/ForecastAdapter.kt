package ps.intive.myweather.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ps.intive.myweather.data.model.ForecastDay
import ps.intive.myweather.databinding.ItemForecastDayBinding
import java.text.SimpleDateFormat
import java.util.Locale

class ForecastAdapter(private val forecastday: List<ForecastDay>) :
    RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemForecastDayBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(forecastDay: ForecastDay) {
            binding.maxTempLbl.text = "MAX temp:  ${forecastDay.day.maxtemp_f}"
            binding.minTempLbl.text = "MIN temp ${forecastDay.day.mintemp_f}"
            binding.textLbl.text = forecastDay.day.condition.text
            binding.dateLbl.text =
                SimpleDateFormat("yyyy-MM-dd", Locale.US).format(forecastDay.date)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemForecastDayBinding = ItemForecastDayBinding.inflate(
            LayoutInflater.from(
                viewGroup.context
            ), viewGroup, false
        );

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(forecastday[position])
    }

    override fun getItemCount() = forecastday.size
}
