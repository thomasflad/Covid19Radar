import Combine
import common
import SwiftUI

struct Dashboard: View {
    @StateObject private var viewModel = ViewModel()

	var body: some View {
        ContentView(weekIncidence: viewModel.weekIncidence,
                    hospitalIncidence: viewModel.hospitalizationIncidence)
	}
}
