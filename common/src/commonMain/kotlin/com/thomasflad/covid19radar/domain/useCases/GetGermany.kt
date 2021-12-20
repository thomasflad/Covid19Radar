package com.thomasflad.covid19radar.domain.useCases

import com.thomasflad.covid19radar.domain.interfaces.IGermanyRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

class GetGermany: KoinComponent {
    private val germanyRepository: IGermanyRepository = get()
    val dataFlow = germanyRepository.getGermany()
}