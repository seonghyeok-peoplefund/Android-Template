package com.ray.template.presentation.ui.c

import android.os.Bundle
import com.ray.template.presentation.databinding.ActivityCBinding
import com.ray.template.presentation.ui.common.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CActivity : BaseActivity<ActivityCBinding>(ActivityCBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initObserver()
    }
}
