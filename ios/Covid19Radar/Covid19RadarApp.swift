import SwiftUI
import common

@main
struct Covid19RadarApp: App {

    init() {
        KoinKt.doInitKoin()
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
