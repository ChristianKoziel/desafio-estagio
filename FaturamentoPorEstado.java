import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FaturamentoPorEstado {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        try {
            FileReader reader = new FileReader("faturamento.json");
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONObject faturamento = (JSONObject) jsonObject.get("faturamento");

            double totalFaturamento = 0;
            for (Object key : faturamento.keySet()) {
                totalFaturamento += (double) faturamento.get(key);
            }

            System.out.println("Percentual de representação de cada estado no faturamento total:");
            for (Object key : faturamento.keySet()) {
                String estado = (String) key;
                double valor = (double) faturamento.get(estado);
                double percentual = (valor / totalFaturamento) * 100;
                System.out.printf("%s: %.2f%%\n", estado, percentual);
            }

            reader.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
