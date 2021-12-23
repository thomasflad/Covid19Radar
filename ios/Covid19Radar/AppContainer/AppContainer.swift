//
//  AppContainer.swift
//  Covid19Radar
//
//  Created by Thomas Flad on 23.12.21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct AppContainer: View {
    var body: some View {
        TabView {
            NavigationView {
                Dashboard()
                    .navigationTitle("dashboard_navigationbar_title")
            }
            .tabItem {
                Label("global_tab_dashboard", systemImage: "list.dash")
            }
        }
    }
}

struct AppContainer_Previews: PreviewProvider {
    static var previews: some View {
        AppContainer()
    }
}
