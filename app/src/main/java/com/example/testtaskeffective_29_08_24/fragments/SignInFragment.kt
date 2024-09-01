package com.example.testtaskeffective_29_08_24.fragments


import android.content.res.Resources
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.testtaskeffective_29_08_24.R
import com.example.testtaskeffective_29_08_24.databinding.FragmentSigninBinding


class SignInFragment : Fragment() {
    private lateinit var binding : FragmentSigninBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSigninBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val field = binding.signinJobSearchField

        field.boxStrokeColor = resources.getColor(R.color.grey_2)
        field.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                field.editText?.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
                field.editText?.compoundDrawablePadding = -40

            }
            if (!hasFocus) {
                field.editText?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.nav_responses_icon, 0, 0, 0)}
        }
        field.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                s?.let { if(!android.util.Patterns.EMAIL_ADDRESS.matcher(it).matches()&& it.isNotEmpty()) {
                    field.boxStrokeColor = resources.getColor(R.color.red)
                }
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(it).matches() || it.isEmpty()){
                    field.boxStrokeColor = resources.getColor(R.color.grey_1)
                }}

            }

        })
    }

}