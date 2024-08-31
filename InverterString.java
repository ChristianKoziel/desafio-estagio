import javax.swing.JOptionPane;

public class InverterString {
    public static void main(String[] args) {
        String original = JOptionPane.showInputDialog("Informe um texto para ser invertido:");

        String invertida = inverterString(original);

        JOptionPane.showMessageDialog(null,"Texto Original: "+ original);
        JOptionPane.showMessageDialog(null,"Texto Invertido: "+ invertida);
    }

    public static String inverterString(String str) {
        char[] caracteres = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            caracteres[i] = str.charAt(i);
        }

        StringBuilder stringInvertida = new StringBuilder();
        for (int i = caracteres.length - 1; i >= 0; i--) {
            stringInvertida.append(caracteres[i]);
        }

        return stringInvertida.toString();
    }
}
