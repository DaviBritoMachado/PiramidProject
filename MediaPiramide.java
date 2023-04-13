import java.util.Random;
import java.util.Scanner;

public class MediaPiramide {
    public static void main(String[] args) {
        //O usuário define a quantidade de linhas da meia pirâmide
        System.out.println("Quantas linhas na piramide: ");
        Scanner linhas = new Scanner(System.in);
        int qntd = linhas.nextInt();

        // Cria o vetor com os números aleatórios entre 0 e 100
        Random rand = new Random();
        int[] numeros = new int[(qntd*(qntd+1))/2]; //O total de números da meia pirâmide
        String numerosstr = "";
        for (int j = 0; j < numeros.length; j++) {
        	numerosstr += Integer.toString(rand.nextInt(101)) + " "; //Coloca os valores em String
        }
        System.out.println("String: " + numerosstr);
        
        //Coloca os numeros do String na lista int
        String strtoint = "";
        for (int i = 0; i < numeros.length; i++) {
        	numeros[i] = Integer.parseInt(numerosstr.substring(0, numerosstr.indexOf(" ")));
        	numerosstr = numerosstr.substring(numerosstr.indexOf(" ") + 1);
        }
        
        //Printar os numeros que vao formar a piramide
        System.out.print("Os numeros de cada linha da piramide: ");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("["+numeros[i]+"]" + " ");
        }

        // Printa a meia pirâmide
        System.out.println("\n------------------------------");
        System.out.println("--- MEIA PIRAMIDE ---");
        int indice = 0;
        for (int i = 1; i <= qntd; i++) {
        	
            for (int j = 0; j < i; j++) {
                System.out.print(numeros[indice] + " ");
                indice++;
            }
            System.out.println();
        }

        //Encontra o menor número de cada camada e executa a soma deles
        System.out.println("------------------------------");
        System.out.print("Menores numeros de cada linha da piramide: ");
        int soma = 0;
        indice = 0;
        for (int i = 1; i <= qntd; i++) {
            int menor = numeros[indice];
            for (int j = 1; j < i; j++) {
                indice++;
                if (numeros[indice] < menor) {
                    menor = numeros[indice];
                }
            }
            indice++;

            soma += menor;
           
            System.out.print("["+menor +"]" + " ");
        }
        System.out.println("\nA soma dos menores numeros de cada linha da meia piramide: " + soma);
    }
}
