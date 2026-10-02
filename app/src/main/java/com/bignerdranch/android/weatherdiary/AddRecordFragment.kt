import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bignerdranch.android.weatherdiary.databinding.FragmentAddRecordBinding

class AddRecordFragment : Fragment() {
    private var _binding: FragmentAddRecordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAddRecordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {
            val date = binding.etDate.text.toString().trim()
            val temp = binding.etTemp.text.toString().trim()
            val condition = binding.etCondition.text.toString().trim()
            val notes = binding.etNotes.text.toString().trim()

            if (date.isEmpty() || temp.isEmpty() || condition.isEmpty()) {
                Toast.makeText(requireContext(), "Заполните обязательные поля", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val newRecord = WeatherEntry(date, temp, condition, notes)


            val currentRecords = AppPreferences.getRecords(requireContext()).toMutableList()
            currentRecords.add(0, newRecord)
            AppPreferences.saveRecords(requireContext(), currentRecords)

            Toast.makeText(requireContext(), "Запись сохранена!", Toast.LENGTH_SHORT).show()
            parentFragmentManager.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}