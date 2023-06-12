package com.ray.template.presentation.ui.main.a

sealed interface AViewEvent {
    object None : AViewEvent
    object ShowToast : AViewEvent
}
