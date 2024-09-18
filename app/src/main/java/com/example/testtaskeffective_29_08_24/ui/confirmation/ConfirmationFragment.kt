package com.example.testtaskeffective_29_08_24.ui.confirmation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testtaskeffective_29_08_24.R
import com.example.testtaskeffective_29_08_24.databinding.FragmentConfirmationBinding
import com.example.testtaskeffective_29_08_24.ui.main.MainFragment

class ConfirmationFragment : Fragment() {
    private lateinit var binding: FragmentConfirmationBinding


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

        binding.etConfirmationCode1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null) {
                    if (s.isNotEmpty()) binding.etConfirmationCode2.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {}

        })

        binding.etConfirmationCode2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null) {
                    if (s.isNotEmpty()) binding.etConfirmationCode3.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {}

        })

        binding.etConfirmationCode3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null) {
                    if (s.isNotEmpty()) binding.etConfirmationCode4.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {}

        })

        binding.etConfirmationCode4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null) {
                    binding.btnConfirmation.isEnabled =
                        binding.etConfirmationCode1.text.isNotEmpty() && binding.etConfirmationCode2.text.isNotEmpty() && binding.etConfirmationCode3.text.isNotEmpty() && binding.etConfirmationCode4.text.isNotEmpty()
                }
            }

            override fun afterTextChanged(s: Editable?) {}

        })


        binding.btnConfirmation.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container_view, MainFragment())?.addToBackStack("toMain")
                ?.commit()
        }
    }


}