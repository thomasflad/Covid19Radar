import SwiftUI

struct DashboardTileView: View {

    let title: String
    let subTitle: String
    let value: String

    var body: some View {
        VStack(alignment: .leading) {
            Text(LocalizedStringKey(title))
                .font(.subheadline)
                .fontWeight(.semibold)
                .lineLimit(2)

            Text(LocalizedStringKey(subTitle))
                .font(.caption)
                .foregroundColor(.secondary)
                .lineLimit(1)

            Spacer()

            Text(value)
                .font(.title)
                .fontWeight(.semibold)
                .foregroundColor(.accentColor)
                .lineLimit(1)
        }
        .padding()
        .frame(minWidth: 0, maxWidth: .infinity, minHeight: 130, maxHeight: 130, alignment: .topLeading)
        .background(
            RoundedRectangle(cornerRadius: 10)
                .fill(.background)
        )
    }
}

struct DashboardTileView_Previews: PreviewProvider {
    static var previews: some View {
        DashboardTileView(title: "Title",
                          subTitle: "Subtitle",
                          value: "123.12")
            .previewLayout(.sizeThatFits)
    }
}
