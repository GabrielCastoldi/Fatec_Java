import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int idade;
        int cont = 0, soma = 0;
        double media;
        int maior, menor;

        System.out.println("Digite a idade ou 0 para encerrar");
        idade = scan.nextInt();
        maior = idade;
        menor = idade;

        while(idade > 0){

            cont = cont + 1; //cont++
            soma = soma + idade; //soma+=idade

            if(idade > maior){
                maior = idade;
            }
            if(idade < menor){
                menor = idade;
            }

            System.out.println("Digite a idade o 0 para encerrar");
            idade = scan.nextInt();

        }

        media = (double)soma/cont;

        System.out.printf("Media = %.2f\n", media);
        System.out.println("Maior = " + maior);
        System.out.println("Menor = " + menor);

    }
}