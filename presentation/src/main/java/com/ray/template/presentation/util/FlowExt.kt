package com.ray.template.presentation.util

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.ray.template.common.event.Event
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

suspend inline fun <T> Flow<Event<T>?>.eventObserve(
    crossinline onEventUnhandledContent: (value: T) -> Unit
) {
    this.collect { event ->
        event?.getContentIfNotHandled()?.let { value ->
            onEventUnhandledContent(value)
        }
    }
}

inline fun AppCompatActivity.launch(crossinline block: suspend () -> Unit) {
    this.lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            block()
        }
    }
}

inline fun Fragment.launch(crossinline block: suspend () -> Unit) {
    viewLifecycleOwner.lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            block()
        }
    }
}
