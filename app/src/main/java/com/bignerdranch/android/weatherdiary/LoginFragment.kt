import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bignerdranch.android.weatherdiary.R
import com.bignerdranch.android.weatherdiary.databinding.FragmentLoginBinding
import com.example.weatherdiary.replaceFragment

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            val login = binding.etLogin.text.toString().trim()
            val name = binding.etName.text.toString().trim()


            if (login.isEmpty()) {
                binding.tilLogin.error = getString(R.string.error_empty_field)
                return@setOnClickListener
            } else binding.tilLogin.error = null

            if (name.isEmpty()) {
                binding.tilName.error = getString(R.string.error_empty_field)
                return@setOnClickListener
            } else binding.tilName.error = null


            val user = User(login, name)
            AppPreferences.saveUser(requireContext(), user)


            replaceFragment(MainFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}