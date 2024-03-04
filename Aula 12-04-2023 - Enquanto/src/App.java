import java.util.Scanner;

class App {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        double salarioBase, valorVendas, salarioFinal;
        String nome;

        System.out.print("Digite o nome do vendedor: ");
        nome = scan.next();

        System.out.print("Digite o salário base do vendedor: ");
        salarioBase = scan.nextDouble();

        System.out.print("Digite o valor das vendas do vendedor: ");
        valorVendas = scan.nextDouble();

        salarioFinal = 0;

        if (salarioBase == 600.0) {
            salarioFinal = salarioBase + (valorVendas * 0.05);
        } else if (salarioBase == 1000.0) {
            salarioFinal = salarioBase + (valorVendas * 0.1);
        } else if (salarioBase == 2000.0) {
            salarioFinal = salarioBase + (valorVendas * 0.2);
        } else {
            System.out.println("Salário base inválido!");
            System.exit(0);
        }

        System.out.println("O salário final de " + nome + " é R$" + salarioFinal);
      
    }
}