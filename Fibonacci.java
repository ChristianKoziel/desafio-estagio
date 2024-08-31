public class Soma {

    public static void main(String[] args) {
        int indice = 13;
        int soma = 0;
        int k = 0;
        for (k = 1; k <= indice; k++) {
            soma = soma + k;
        }

        System.out.println("O valor da soma é: "+soma);
    }
}