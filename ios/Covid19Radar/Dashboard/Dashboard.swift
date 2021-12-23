import common
import SwiftUI
import Combine

struct Dashboard: View {
    @StateObject private var viewModel = ViewModel()

	var body: some View {
        ContentView(weekIncidence: viewModel.weekIncidence)
	}
}
