//
//  ContentViewModel.swift
//  Covid19Radar
//
//  Created by Thomas Flad on 21.12.21.
//  Copyright © 2021 orgName. All rights reserved.
//

import common
import SwiftUI
import Combine
import KMPNativeCoroutinesCombine

extension Dashboard {
    class ViewModel: ObservableObject {

        @Published private(set) var weekIncidence = "---"

        init(getGermany: GetGermany = GetGermany()) {

            createPublisher(for: getGermany.dataFlowNative)
                .receive(on: DispatchQueue.main)
                .replaceError(with: DataState(status: .error, data: nil, message: nil))
                .compactMap { $0.data?.weekIncidence }
                .map { "\($0.formatted(.number.precision(.fractionLength(2))))" }
                .assign(to: &$weekIncidence)

        }
    }
}
