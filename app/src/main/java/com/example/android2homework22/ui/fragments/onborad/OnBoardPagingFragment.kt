package com.example.android2homework22.ui.fragments.onborad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android2homework22.R
import com.example.android2homework22.databinding.FragmentOnBoardPagingBinding
import com.example.android2homework22.utils.PreferenceHelper

class OnBoardPagingFragment : Fragment() {

    private var _binding: FragmentOnBoardPagingBinding? = null
    private val binding: FragmentOnBoardPagingBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardPagingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        goToNoteFragment()
    }

    private fun initialize() = with(binding) {
        when (requireArguments().getInt(ARG_ONBOARD_POSITION)) {
            0 -> {
                onTxt.text = "Очень удобный функционал"
                binding.lottieAnimationSecond.setAnimation(R.raw.first_animation)
            }

            1 -> {
                onTxt.text = "Быстрый, качественный продукт"
                binding.lottieAnimationSecond.setAnimation(R.raw.second_animation)
            }

            2 -> {
                onTxt.text = "Куча функций и интересных фишек"
                binding.start.isVisible = true
                binding.lottieAnimationSecond.setAnimation(R.raw.third_animation)
            }
        }
    }

    private fun goToNoteFragment() = with(binding) {
        val preferenceHelper = PreferenceHelper()
        preferenceHelper.unit(requireContext())
        start.setOnClickListener {
            preferenceHelper.saveBoolean = true
            findNavController().navigate(R.id.action_onBoardFragment_to_noteFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val ARG_ONBOARD_POSITION = "onBoard"
    }
}