import UIKit
import SwiftUI

struct AppContainer: View {

    var body: some View {
        TabView {
            NavigationView {
                Dashboard()
                    .navigationTitle("dashboard.navigationbar.title")
            }
            .tabItem {
                Label("global.tab.dashboard", systemImage: "allergens")
            }
        }
        .navigationViewStyle(StackNavigationViewStyle())
    }
}

struct AppContainer_Previews: PreviewProvider {
    static var previews: some View {
        AppContainer()
    }
}
