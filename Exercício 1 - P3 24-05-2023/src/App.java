import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Variáveis 1
        String nome[] = {"Ivo", "Leia", "Susi", "Alan", "Ian", "Bia", "Gil"};
        double salarioBase[] = {3000.00, 2200.00, 2400.00, 2000.00, 2500.00, 2600.00, 3500.00};
        double vendas[] = {7000.00, 20000.00, 15000.00, 6000.00, 5000.00, 22000.00, 8000.00};
        char categoria[] = {'B', 'E', 'E', 'B', 'B', 'E', 'B'};
        int opcao = ' ';

        //Variáveis 2
        int cont = 0;
        double somaSalarios = 0, media = 0.0;
        char opcao2 = ' ';
        boolean achou = false;

        //Variáveis 3
        double salarioFinal = 0.0;

        //Vetores 4
        double porcentagemCategoria = 0.0;
        boolean achou2 = false;
        char opcao3 = ' ';

        //V 5
        double menorVenda = 0.0;
        String menorNome = " ";
        char menorCategoria = ' ';


        //1) Armazene os dados em vetores e exiba na tela.
        for (int i = 0; i < nome.length; i++) {
            System.out.printf("%10s %10.2f %10.2f %10c\n", nome[i], salarioBase[i], vendas[i], categoria[i]);
        }

        do {
            System.out.println("\nMenu\n" +
                    "1 - Média dos salários base dos vendedores\n" +
                    "2 - Valor do salário final\n" +
                    "3 - Porcentagem de vendas por categoria\n" +
                    "4 - Nome do vendedor com a menor venda\n" +
                    "5 - Sair\n" +
                    "Digite a opção: ");
            opcao = scan.nextInt();

            switch (opcao) {


                case 1:

                    //2) Calcule e escreva a média dos salários base dos vendedores.
                    somaSalarios = 0;
                    cont = 0;
                    media = 0;
                    opcao2 = ' ';
                    achou = false;

                    System.out.println("\nMenu\n" +
                            "E - Externo\n" +
                            "B - Balcão\n" +
                            "Digite a categoria: ");
                    opcao2 = scan.next().charAt(0);

                    for (int i = 0; i < nome.length; i++) {
                        if (opcao2 == categoria[i]) {
                            achou = true;
                            somaSalarios += salarioBase[i];
                            cont++;
                        }
                    }

                    if (!achou) {
                        System.out.println("Categoria não encontrada");
                    } else {
                        media = somaSalarios / cont;
                        System.out.printf("Média: %.2f", media);
                    }
                    break;

                case 2:
                    /*3) Exiba os nomes e os salários finais de todos os vendedores, sendo que o vendedor externo recebe seu salário
                    base mais 20% de suas vendas e o vendedor do balcão recebe seu salário base mais 5% de suas vendas*/

                    salarioFinal = 0.0;

                    for (int i = 0; i < nome.length; i++) {
                        if (categoria[i] == 'E') {
                            salarioFinal = salarioBase[i] + (vendas[i] * 20 / 100);
                        } else {
                            salarioFinal = salarioBase[i] + (vendas[i] * 5 / 100);
                        }

                        System.out.printf("Salário final: %10s %10.2f\n", nome[i], salarioFinal);

                    }
                    break;

                case 3:
                    //4) Solicite que o usuário digite uma categoria e calcule e exiba a porcentagem de vendedores da categoria digitada.

                    porcentagemCategoria = 0;
                    cont = 0;
                    achou2 = false;

                    System.out.println("\nMenu\n" +
                            "E - Externo\n" +
                            "B - Balcão\n" +
                            "Digite a categoria desejada: ");
                    opcao3 = scan.next().charAt(0);

                    for (int i = 0; i < nome.length; i++) {
                        if (opcao3 == categoria[i]) {
                            achou2 = true;
                            cont++;
                        }
                    }

                    if (!achou2) {
                        System.out.println("Categoria não encontrada");
                    } else {
                        porcentagemCategoria = (double) cont / nome.length * 100;
                        System.out.printf("Porcentagem: %.2f%%", porcentagemCategoria);
                    }
                    break;

                case 4:
                    //5) Qual é o nome e a categoria do vendedor que fez a menor venda?
                    menorVenda = vendas[0];
                    menorNome = nome[0];
                    menorCategoria = categoria[0];

                    for (int i = 0; i < nome.length; i++) {
                        if (vendas[i] < menorVenda) {
                            menorVenda = vendas[i];
                            menorNome = nome[i];
                            menorCategoria = categoria[i];
                        }
                    }

                    System.out.printf("\nVendedor com a menor venda\n" +
                            "Nome: %s. Valor da venda: %.2f. Categoria: %c", menorNome, menorVenda, menorCategoria);
                    break;

                case 5:
                    System.out.println("Encerrado");
                    break;

                default:
                    System.out.println("Opção invalida");
                    break;
            }
        } while (opcao != 5);
    }
}