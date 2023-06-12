package com.ray.template.presentation.ui.main.b

import com.ray.template.presentation.databinding.FragmentBBinding
import com.ray.template.presentation.ui.common.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BFragment : BaseFragment<FragmentBBinding>(
    FragmentBBinding::inflate
)
