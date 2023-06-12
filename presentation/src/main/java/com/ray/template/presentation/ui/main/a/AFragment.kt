package com.ray.template.presentation.ui.main.a

import android.content.Intent
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.ray.template.common.eventObserve
import com.ray.template.presentation.R
import com.ray.template.presentation.databinding.FragmentABinding
import com.ray.template.presentation.ui.c.CActivity
import com.ray.template.presentation.ui.common.base.BaseFragment
import com.ray.template.presentation.util.eventObserve
import com.ray.template.presentation.util.launch
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@AndroidEntryPoint
class AFragment : BaseFragment<FragmentABinding>(
    FragmentABinding::inflate
) {

    private val viewModel: AViewModel by viewModels()

    override fun initView() {
        bind {
            vm = viewModel
            lifecycleOwner = this@AFragment

            goToB.setOnClickListener {
                goToB()
            }
            goToC.setOnClickListener {
                goToC()
            }
        }
    }

    override fun initObserver() {
        viewModel.flow1.observe(viewLifecycleOwner) {
            binding.value1.text = getNowText()
        }
        viewModel.flow1.observe(viewLifecycleOwner) {
            viewModel.countFlow1()
        }
        viewModel.flow2.eventObserve(viewLifecycleOwner) {
            binding.value2.text = getNowText()
        }
        viewModel.flow2.observe(viewLifecycleOwner) {
            viewModel.countFlow2()
        }
        launch {
            viewModel.flow3.collect {
                binding.value3.text = getNowText()
            }
        }
        launch {
            viewModel.flow3.collect {
                viewModel.countFlow3()
            }
        }
        launch {
            viewModel.flow4.eventObserve {
                binding.value4.text = getNowText()
            }
        }
        launch {
            viewModel.flow4.collect {
                viewModel.countFlow4()
            }
        }
        launch {
            viewModel.flow5.collect {
                binding.value5.text = getNowText()
            }
        }
        launch {
            viewModel.flow5.collect {
                viewModel.countFlow5()
            }
        }
        launch {
            viewModel.flow6.eventObserve {
                binding.value6.text = getNowText()
            }
        }
        launch {
            viewModel.flow6.collect {
                viewModel.countFlow6()
            }
        }
    }

    private fun getNowText(): String {
        return SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
    }

    private fun goToB() {
        findNavController().navigate(R.id.action_a_to_b)
    }

    private fun goToC() {
        startActivity(
            Intent(
                requireContext(),
                CActivity::class.java
            )
        )
    }
}
