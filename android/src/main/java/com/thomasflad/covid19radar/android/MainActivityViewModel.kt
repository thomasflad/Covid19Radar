package com.thomasflad.covid19radar.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thomasflad.covid19radar.domain.DataState
import com.thomasflad.covid19radar.domain.useCases.GetGermany
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.stateIn

class Inputs {
}

interface Outputs {
    val cases: Flow<Double>
}

interface MainActivityViewModelType {
    val inputs: Inputs
    val outputs: Outputs
}

class MainActivityViewModel(
    getGermanyUseCase: GetGermany
) : ViewModel(), MainActivityViewModelType, Outputs {

    override val inputs: Inputs = Inputs()
    override val outputs: Outputs = this

    private val getGermany = getGermanyUseCase.dataFlow
        .stateIn(viewModelScope, WhileSubscribed(5000), DataState.initial())

    override val cases = getGermany
        .mapNotNull { it.data?.cases }

}
