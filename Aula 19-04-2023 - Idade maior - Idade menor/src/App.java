import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        /*
        Leia várias idades e:
        a) calcule a média
        b) encontre a maior
        c) encontre a menor
        */

        int idade;
        int cont = 0, soma = 0;
        double media;
        int maior, menor;

        System.out.println("Digite a idade (ou 0 para encerrar)");
        idade = scan.nextInt();

        maior = idade;
        menor = idade;

        do{
            cont = cont + 1;
            soma = soma + idade;

            if (idade > maior) {
                maior = idade;
            }
            if (idade < menor) {
                menor = idade;
            }

            System.out.println("Digite a idade");
            idade = scan.nextInt();

        }while(idade > 0);

        media = (double) soma / cont;

        System.out.println("Media = " + media);
        System.out.println("Maior = " + maior);
        System.out.println("Menor = " + menor);

    }
}