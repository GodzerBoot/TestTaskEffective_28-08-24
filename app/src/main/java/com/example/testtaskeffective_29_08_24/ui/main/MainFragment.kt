package com.example.testtaskeffective_29_08_24.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.testtaskeffective_29_08_24.ui.main.adapter.VacancyAdapter
import com.example.testtaskeffective_29_08_24.databinding.FragmentMainScreenBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import org.koin.androidx.scope.fragmentScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent

class MainFragment : Fragment(), KoinComponent {
    private lateinit var binding: FragmentMainScreenBinding
    private val viewModel: MainViewModel by viewModel()
    private val vacancyAdapter = VacancyAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainScreenBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupVacancyRecyclerView()
        setupUiStateObserver()
    }

    private fun setupVacancyRecyclerView() {
        binding.recyclerView.adapter = vacancyAdapter
    }

    private fun setupUiStateObserver() {
        viewModel.uiState.onEach { vacancyAdapter.submitList(it.vacancies) }.launchIn(lifecycleScope)
    }
}