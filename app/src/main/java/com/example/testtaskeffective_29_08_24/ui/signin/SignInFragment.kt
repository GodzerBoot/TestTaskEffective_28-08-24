package com.example.testtaskeffective_29_08_24.ui.signin


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.testtaskeffective_29_08_24.AppConstants
import com.example.testtaskeffective_29_08_24.R
import com.example.testtaskeffective_29_08_24.databinding.FragmentSigninBinding
import com.example.testtaskeffective_29_08_24.ui.Screens
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import org.koin.android.ext.android.inject


class SignInFragment : Fragment() {
    private lateinit var binding: FragmentSigninBinding
    private val cicerone: Cicerone<Router> by inject()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentSigninBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupFocusChangeListener()
        setupEmailTextWatcher()
        setupClickListeners()
        if (AppConstants.isDevFeatureEnabled) {
            binding.signinJobSearchField.editText?.setText("test@test.test")
            binding.signinJobSearchContinueButton.isEnabled = true
        } //debug default input
    }

    private fun setupEmailTextWatcher() {
        binding.signinJobSearchField.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                s?.let {
                    if (!android.util.Patterns.EMAIL_ADDRESS.matcher(it)
                            .matches() || it.isEmpty()
                    ) {
                        binding.signinJobSearchField.boxStrokeColor =
                            ContextCompat.getColor(requireContext(), R.color.red)
                        binding.signinJobSearchContinueButton.isEnabled = false
                    } else {
                        binding.signinJobSearchField.boxStrokeColor =
                            ContextCompat.getColor(requireContext(), R.color.grey_1)
                        binding.signinJobSearchContinueButton.isEnabled = true
                    }
                }

            }

        })
    }

    private fun setupClickListeners() {
        binding.signinJobSearchContinueButton.setOnClickListener {
            cicerone.router.navigateTo(Screens.conformation(binding.signinJobSearchField.editText?.text.toString()))
        }
    }

    private fun setupFocusChangeListener() = with(binding.signinJobSearchField) {
        setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                editText?.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
                editText?.compoundDrawablePadding = -40
                startIconDrawable = ContextCompat.getDrawable(requireContext(), R.drawable.level_up_resume_icon)

            } else {
                editText?.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.nav_responses_icon, 0, 0, 0
                )
            }
        }
    }
}