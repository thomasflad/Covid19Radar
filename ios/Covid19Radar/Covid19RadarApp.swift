import common
import SwiftUI

@main
struct Covid19RadarApp: App {

    init() {
        KoinKt.doInitKoin()
        UITabBar.setupDefaultBackground()
    }

	var body: some Scene {
		WindowGroup {
			AppContainer()
		}
	}
}
