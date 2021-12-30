extension Double {
    func formatted(precision: Int = 2) -> String {
        return self.formatted(.number.precision(.fractionLength(precision)))
    }
}
