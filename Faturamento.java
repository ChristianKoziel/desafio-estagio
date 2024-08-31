import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Faturamento {

    public static void main(String[] args) {
        String caminhoArquivoJson = "faturamento.json";
        JSONParser parser = new JSONParser();

        try {
            FileReader reader = new FileReader(caminhoArquivoJson);
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            JSONObject faturamento = (JSONObject) jsonObject.get("faturamento");

            double menorFaturamento = Double.MAX_VALUE;
            double maiorFaturamento = Double.MIN_VALUE;
            double somaFaturamento = 0;
            int diasComFaturamento = 0;

            for (Object key : faturamento.keySet()) {
                String dia = (String) key;
                double valor = (double) faturamento.get(dia);

                if (valor > 0) { 
                    if (valor < menorFaturamento) {
                        menorFaturamento = valor;
                    }
                    if (valor > maiorFaturamento) {
                        maiorFaturamento = valor;
                    }
                    somaFaturamento += valor;
                    diasComFaturamento++;
                }
            }

            double mediaFaturamento = somaFaturamento / diasComFaturamento;

            int diasAcimaDaMedia = 0;
            for (Object key : faturamento.keySet()) {
                String dia = (String) key;
                double valor = (double) faturamento.get(dia);
                if (valor > mediaFaturamento) {
                    diasAcimaDaMedia++;
                }
            }

            System.out.println("Menor valor de faturamento: " + menorFaturamento);
            System.out.println("Maior valor de faturamento: " + maiorFaturamento);
            System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);

            reader.close();

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
