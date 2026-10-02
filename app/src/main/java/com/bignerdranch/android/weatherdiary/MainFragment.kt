import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bignerdranch.android.weatherdiary.databinding.FragmentMainBinding
import com.example.weatherdiary.replaceFragment

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = AppPreferences.getUser(requireContext())
        binding.tvWelcomeUser.text = "Привет, ${user?.name}!"

        binding.btnAdd.setOnClickListener { replaceFragment(AddRecordFragment()) }
        binding.btnView.setOnClickListener { replaceFragment(RecordsFragment()) }

        binding.btnLogout.setOnClickListener {
            AppPreferences.clearUser(requireContext())

            parentFragmentManager.popBackStack(null, android.app.FragmentManager.POP_BACK_STACK_INCLUSIVE)
            replaceFragment(LoginFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}