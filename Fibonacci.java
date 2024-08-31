import javax.swing.JOptionPane;

public class Fibonacci {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Informe um número para verificar se pertence à sequência de Fibonacci:");
        int numero = Integer.parseInt(input); 

        int a = 0, b = 1;
        boolean pertence = false;

        if (numero == a || numero == b) {
            pertence = true; 
        } else {
            while (b <= numero) {
                int proximo = a + b;
                a = b; 
                b = proximo; 
                int teste=1;

                if (b == numero) {
                    pertence = true; 
                    break; 
                }
            }
        }
        if (pertence) {
            JOptionPane.showMessageDialog(null, "O número " + numero + " pertence à sequência de Fibonacci.");
        } else {
            JOptionPane.showMessageDialog(null, "O número " + numero + " NÃO pertence à sequência de Fibonacci.");
        }
    }
}
