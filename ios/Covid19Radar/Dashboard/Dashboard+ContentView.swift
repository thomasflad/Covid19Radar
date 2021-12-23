//
//  Dashboard+ContentView.swift
//  Covid19Radar
//
//  Created by Thomas Flad on 23.12.21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

extension Dashboard {
    struct ContentView: View {

        let weekIncidence: String

        var body: some View {
            ZStack {
                Color.accentColor
                    .opacity(0.15)
                    .ignoresSafeArea(.all, edges: .top)

                HStack {
                    VStack {
                        VStack(alignment: .leading) {
                            Text("dashboard_weekIncidents_title")
                                .font(.subheadline)
                                .fontWeight(.semibold)

                            Text("dashboard_weekIncidents_germanywide")
                                .font(.caption)
                                .foregroundColor(.secondary)
                                .padding(.bottom)

                            Text(weekIncidence)
                                .font(.title)
                                .fontWeight(.semibold)
                                .foregroundColor(.accentColor)
                        }
                        .padding()
                        .background(
                            RoundedRectangle(cornerRadius: 10)
                                .fill(.background)
                        )
                        Spacer()
                    }
                    Spacer()
                }
                .padding()
            }
        }
    }
}

struct DashboardContentView_Previews: PreviewProvider {
    static var previews: some View {
        Dashboard.ContentView(weekIncidence: "123.45")
    }
}
