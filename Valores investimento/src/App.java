import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        /*3) Uma agência bancária possui dois tipos de investimentos, conforme o quadro a seguir.
        Faça um programa que receba o tipo de investimento e seu valor e calcule e mostre o valor corrigido,
        de acordo com o tipo de investimento.
        TIPO	DESCRIÇÃO               RENDIMENTO MENSAL
        1	    Poupança                3%
        2	    Fundos de renda fixa	  4%
        */

        int op;
        int valor;
        float poup = 0;
        float rf;

        System.out.println("\nDigite o valor a investir:");
        valor = scan.nextInt();

        System.out.println("\nEscolha uma opção de investimento: " + "\n1- Poupança 2-Fundos de renda fixa.");
        op = scan.nextInt();

        if (op == 1) {
            poup = (valor * 3)/100+ valor;
            System.out.println("Rendimento depois de um mês na Poupança: " + poup);
        }
        if (op == 2) {
            rf = (valor * 4)/100+ valor;
            System.out.println("Rendimento depois de um mês na Renda Fixa: " + rf);
        }
        if (op !=1 && op!=2) {
            System.out.println("Opção Inválida:" );
        }
    }
}