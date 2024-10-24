package com.example.features.main_screen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.features.main_screen.databinding.FragmentMainScreenBinding
import com.example.features.main_screen.ui.adapter.ButtonMoreViewHolder
import com.example.features.main_screen.ui.adapter.VacancyAdapter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainScreenFragment : Fragment() {
    private lateinit var binding: FragmentMainScreenBinding
    private val viewModel: MainScreenViewModel by viewModel()
    private val callback = object : ButtonMoreViewHolder.ButtonMoreCallback {
        override fun onClick() {
            viewModel.onShowMoreClick()
//            binding.tfMainJobSearchField.startIconDrawable = ContextCompat.getDrawable(requireContext(), R.drawable.back_arrow)
//            binding.tfMainJobSearchField.setStartIconOnClickListener {
//                binding.tfMainJobSearchField.startIconDrawable = ContextCompat.getDrawable(requireContext(), R.drawable.nav_search_icon)
//            }
        }
    }
    private val vacancyAdapter = VacancyAdapter(callback)

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
        binding.recyclerViewMain.adapter = vacancyAdapter
    }

    private fun setupUiStateObserver() {
        viewModel.uiState.onEach {
            vacancyAdapter.offers = it.offers
            vacancyAdapter.submitList(it.vacancies)
        }
            .launchIn(lifecycleScope)
    }
}