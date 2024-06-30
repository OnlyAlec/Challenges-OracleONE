public record Conversion(String result,
                         String base_code,
                         String target_code,
                         String conversion_rate,
                         String conversion_result) {
    @Override
    public String toString() {
        String str = String.format("""
                \t- La conversion de %s a %s es de: %s
                \t- - Con una tasa de conversion de: %s""", base_code, target_code, conversion_result, conversion_rate);
        return str;
    }
}
