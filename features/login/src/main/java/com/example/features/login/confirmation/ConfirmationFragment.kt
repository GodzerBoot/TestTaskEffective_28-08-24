package com.example.features.login.confirmation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.core.navigation.Screens
import com.example.features.login.databinding.FragmentConfirmationBinding
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import org.koin.android.ext.android.inject

class ConfirmationFragment : Fragment() {
    private lateinit var binding: FragmentConfirmationBinding
    private val cicerone: Cicerone<Router> by inject()
    private val screens: Screens by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConfirmationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvConfirmationTitle.text = "Отправили код на " + this.arguments?.getString("email")

        binding.etConfirmationCode1.addTextChangedListener(getTextWatcher(binding, binding.etConfirmationCode2))
        binding.etConfirmationCode2.addTextChangedListener(getTextWatcher(binding, binding.etConfirmationCode3))
        binding.etConfirmationCode3.addTextChangedListener(getTextWatcher(binding, binding.etConfirmationCode4))
        binding.etConfirmationCode4.addTextChangedListener(getTextWatcher(binding, null))


        binding.btnConfirmation.setOnClickListener {
            cicerone.router.navigateTo(screens.main())
        }
    }

    private fun getTextWatcher(
        binding: FragmentConfirmationBinding,
        nextField: EditText?,
    ): TextWatcher {
        return object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null) {
                    if (s.isNotBlank() && nextField != null) nextField.requestFocus()
                    binding.btnConfirmation.isEnabled =
                        binding.etConfirmationCode1.text.isNotBlank() && binding.etConfirmationCode2.text.isNotBlank() && binding.etConfirmationCode3.text.isNotBlank() && binding.etConfirmationCode4.text.isNotBlank()
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        }
    }

    companion object {
        fun newInstance(email: String): ConfirmationFragment {
            val args = Bundle()
            args.putString("email", email)
            val fragment = ConfirmationFragment()
            fragment.arguments = args
            return fragment
        }
    }
}