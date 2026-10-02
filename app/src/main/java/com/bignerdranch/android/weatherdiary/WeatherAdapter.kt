import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.weatherdiary.databinding.ItemWeatherRecordBinding

class WeatherAdapter(private val records: List<WeatherEntry>) :
    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemWeatherRecordBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemWeatherRecordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = records[position]
        holder.binding.tvDate.text = item.date
        holder.binding.tvDetails.text = "${item.condition}, ${item.temperature}\n${item.notes}"
    }

    override fun getItemCount() = records.size
}