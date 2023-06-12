package com.ray.template.presentation.ui.main.a

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ray.template.common.event.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class AViewModel @Inject constructor() : ViewModel() {

    // 예전 일반 데이터
    val flow1: MutableLiveData<AViewEvent> = MutableLiveData()
    val flow1Count: MutableStateFlow<Int> = MutableStateFlow(0)
    val flow1CountText: StateFlow<String> = flow1Count.map {
        "count : ${it.toString()}"
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), "count : 0")

    // 예전 state & event
    val flow2: MutableLiveData<Event<AViewEvent>> = MutableLiveData()
    val flow2Count: MutableStateFlow<Int> = MutableStateFlow(0)
    val flow2CountText: StateFlow<String> = flow2Count.map {
        "count : ${it.toString()}"
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), "count : 0")

    // 현재 일반 데이터
    val flow3: MutableStateFlow<AViewEvent> = MutableStateFlow(AViewEvent.None)
    val flow3Count: MutableStateFlow<Int> = MutableStateFlow(0)
    val flow3CountText: StateFlow<String> = flow3Count.map {
        "count : ${it.toString()}"
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), "count : 0")

    // 현재 state
    val flow4: MutableStateFlow<Event<AViewEvent>> = MutableStateFlow(Event(AViewEvent.None))
    val flow4Count: MutableStateFlow<Int> = MutableStateFlow(0)
    val flow4CountText: StateFlow<String> = flow4Count.map {
        "count : ${it.toString()}"
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), "count : 0")

    // 장성혁이 말하는 tobe state & event
    val flow5: MutableSharedFlow<AViewEvent> = MutableSharedFlow()
    val flow5Count: MutableStateFlow<Int> = MutableStateFlow(0)
    val flow5CountText: StateFlow<String> = flow5Count.map {
        "count : ${it.toString()}"
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), "count : 0")

    // 현재 event
    val flow6: MutableSharedFlow<Event<AViewEvent>> = MutableSharedFlow()
    val flow6Count: MutableStateFlow<Int> = MutableStateFlow(0)
    val flow6CountText: StateFlow<String> = flow6Count.map {
        "count : ${it.toString()}"
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), "count : 0")

    fun onConfirm() {
        viewModelScope.launch {
            flow1.value = AViewEvent.ShowToast
            flow2.value = Event(AViewEvent.ShowToast)
            flow3.value = AViewEvent.ShowToast
            flow4.value = Event(AViewEvent.ShowToast)
            flow5.emit(AViewEvent.ShowToast)
            flow6.emit(Event(AViewEvent.ShowToast))
        }
    }

    fun countFlow1() {
        flow1Count.value++
    }

    fun countFlow2() {
        flow2Count.value++
    }

    fun countFlow3() {
        flow3Count.value++
    }

    fun countFlow4() {
        flow4Count.value++
    }

    fun countFlow5() {
        flow5Count.value++
    }

    fun countFlow6() {
        flow6Count.value++
    }
}
