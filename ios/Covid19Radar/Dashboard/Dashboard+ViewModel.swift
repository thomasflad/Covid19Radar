import Combine
import common
import KMPNativeCoroutinesCombine
import SwiftUI

extension Dashboard {
    class ViewModel: ObservableObject {

        @Published private(set) var weekIncidence = "---"
        @Published private(set) var hospitalizationIncidence = "---"

        var bag = Set<AnyCancellable>()

        init(getGermany: GetGermany = GetGermany()) {

            createPublisher(for: getGermany.dataFlowNative())
                .receive(on: DispatchQueue.main)
                .replaceError(with: DataState(status: .error, data: nil, message: nil))
                .compactMap { $0.data }
                .sink { [weak self] in
                    self?.weekIncidence = $0.weekIncidence.formatted()
                    self?.hospitalizationIncidence = $0.hospitalizationIncidence.formatted()
                }
                .store(in: &bag)

        }
    }
}
