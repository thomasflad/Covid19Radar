import SwiftUI
import UIKit

extension Dashboard {
    struct ContentView: View {

        let weekIncidence: String
        let hospitalIncidence: String

        private let columns: [GridItem] = Array(repeating: .init(.flexible()), count: 2)

        var body: some View {
            ScrollView {
                LazyVGrid(columns: columns) {
                    DashboardTileView(title: "dashboard.weekIncidents.title",
                                      subTitle: "dashboard.weekIncidents.germanywide",
                                      value: weekIncidence)

                    DashboardTileView(title: "dashboard.hospitalization.title",
                                      subTitle: "dashboard.hospitalization.germanywide",
                                      value: hospitalIncidence)
                }
                .padding()
            }
            .background(Color.accentColor.opacity(0.15))
        }
    }
}

struct DashboardContentView_Previews: PreviewProvider {
    static var previews: some View {
        Dashboard.ContentView(
            weekIncidence: "123.45",
            hospitalIncidence: "123.45")
        Dashboard.ContentView(
            weekIncidence: "123.45",
            hospitalIncidence: "123.45")
            .preferredColorScheme(.dark)
    }
}
