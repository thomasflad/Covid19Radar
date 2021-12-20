import common
import SwiftUI
import Combine

struct ContentView: View {
    @StateObject private var viewModel = ViewModel()

	var body: some View {
        Text(viewModel.cases)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
