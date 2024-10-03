package com.example.testtaskeffective_29_08_24.ui.mainfull

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.testtaskeffective_29_08_24.databinding.FragmentMainScreenFullBinding
import com.example.testtaskeffective_29_08_24.ui.mainfull.adapter.VacancyAdapter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent

class MainFullFragment : Fragment(), KoinComponent {
    private lateinit var binding: FragmentMainScreenFullBinding
    private val viewModel: MainFullViewModel by viewModel()
    private val vacancyAdapter = VacancyAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainScreenFullBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupVacancyRecyclerView()
        setupUiStateObserver()
    }

    private fun setupVacancyRecyclerView() {
        binding.recyclerViewMainFull.adapter = vacancyAdapter
    }

    private fun setupUiStateObserver() {
        viewModel.uiState.onEach {
            vacancyAdapter.submitList(it.vacancies)
        }
            .launchIn(lifecycleScope)
    }
}