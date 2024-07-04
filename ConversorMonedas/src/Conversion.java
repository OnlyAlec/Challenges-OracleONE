import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public record Conversion(String result,
                         String base_code,
                         String target_code,
                         String conversion_rate,
                         String conversion_result) {
    @Override
    public String toString() {
        return String.format("""
                - La conversion de %s a %s es de: %s
                - - Con una tasa de conversion de: %s""", base_code, target_code, conversion_result, conversion_rate);
    }

    public String toStringSimple(){
        double mount = Double.valueOf(conversion_result) / Double.valueOf(conversion_rate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy").withZone(ZoneId.systemDefault());
        return base_code + "(" + mount + ") -> " + target_code + ": " + conversion_result + " - Fecha: " + formatter.format(Instant.now());
    }
}
