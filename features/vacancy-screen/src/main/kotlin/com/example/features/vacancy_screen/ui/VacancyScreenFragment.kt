package com.example.features.vacancy_screen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.core.navigation.Screens
import com.example.core.network.data.VacancyResponse
import com.example.features.vacancy_screen.databinding.FragmentVacancyScreenBinding
import com.example.features.vacancy_screen.ui.adapter.VacancyScreenAdapter
import com.example.features.vacancy_screen.ui.adapter.item.ApplyItem
import com.example.features.vacancy_screen.ui.adapter.item.DescriptionItem
import com.example.features.vacancy_screen.ui.adapter.item.HeaderItem
import com.example.features.vacancy_screen.ui.adapter.item.LocationItem
import com.example.features.vacancy_screen.ui.adapter.item.OthersItem
import com.example.features.vacancy_screen.ui.adapter.item.QuestionItem
import com.example.features.vacancy_screen.ui.adapter.item.QuestionsItem
import com.example.features.vacancy_screen.ui.adapter.item.ResponsibilitiesItem
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import org.koin.android.ext.android.inject
import org.koin.core.component.inject

class VacancyScreenFragment(private val vacancy: VacancyResponse) : Fragment() {
    private val cicerone: Cicerone<Router> by inject()
    private val screens: Screens by inject()
    lateinit var binding: FragmentVacancyScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVacancyScreenBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = VacancyScreenAdapter()
        adapter.submitList(setupViewList(vacancy))
        binding.rvVacancy.adapter = adapter
        binding.ivBackIcon.setOnClickListener { cicerone.router.backTo(screens.main()) }
    }

    private fun setupViewList(vacancy: VacancyResponse): MutableList<Any> {
        val mutableList = mutableListOf<Any>()
        mutableList.add(HeaderItem(
            title = vacancy.title ?: "",
            salary = vacancy.salary?.full ?: "",
            experience = vacancy.experience?.text ?: "",
            employmentType = vacancy.schedules.toString(),
        ))

        mutableList.add(OthersItem(
            lookingNumber = vacancy.lookingNumber ?: 0,
            appliedNumber = vacancy.appliedNumber ?: 0,
        ))

        mutableList.add(LocationItem(
            companyName = vacancy.company ?: "null",
            address = "${vacancy.address?.town}, ${vacancy.address?.street}, ${vacancy.address?.house}",
        ))

        vacancy.description?.let {
            mutableList.add(DescriptionItem(it.trim()))
        }

        vacancy.responsibilities?.let {
            mutableList.add(ResponsibilitiesItem(it.trim()))
        }

        val questions = vacancy.questions.map { QuestionItem(it) }
        mutableList.add(QuestionsItem(questions))

        mutableList.add(ApplyItem(View.OnClickListener {  }))

        return mutableList
    }
}