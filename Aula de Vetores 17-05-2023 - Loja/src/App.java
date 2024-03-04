import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        //1) Armazene os dados em vetores e exiba na tela.
        String cliente[] = {"Ana", "Luis", "Bia", "Ivo", "Ana", "Luis", "Bia", "Ana", "Bia", "Ian"};
        double valorBase[] = {400.00, 700.00, 200.00, 900.00, 500.00, 800.00, 100.00, 600.00, 300.00, 150.00};
        int numPrestacoes[] = {1, 2, 1, 3, 2, 3, 1, 3, 2, 1};

        for (int i = 0; i < cliente.length; i++) {
            System.out.printf("%10s %10.2f %10d\n", cliente[i], valorBase[i], numPrestacoes[i]);
        }

        //2) Calcule o valor médio das vendas à vista, em 2 e em 3 prestações.
        double soma1 = 0, soma2 = 0, soma3 = 0, media1 = 0, media2 = 0, media3 = 0;
        int cont1 = 0, cont2 = 0, cont3 = 0;

        for (int i = 0; i < cliente.length; i++) {
            if (numPrestacoes[i] == 1) {
                soma1 = soma1 + valorBase[i];
                cont1++;
            } else if (numPrestacoes[i] == 2) {
                soma2 = soma2 + valorBase[i];
                cont2++;
            } else {
                soma3 = soma3 + valorBase[i];
                cont3++;
            }
        }
        
        media1 = soma1 / cont1;
        media2 = soma2 / cont2;
        media3 = soma3 / cont3;

        System.out.printf("A média de valores à vista é: %.2f\n", media1);
        System.out.printf("A média de valores em 2 parcelas é: %.2f\n", media2);
        System.out.printf("A média de valores em 3 parcelas é: %.2f\n", media3);

        //2) Calcule a porcentagem de vendas à vista, em 2 e em 3 prestações.
        double perc1, perc2, perc3;
        int contP1 = 0, contP2 = 0, contP3 = 0;

        for (int i = 0; i < cliente.length; i++) {
            if (numPrestacoes[i] == 1) {
                contP1++;

            } else if (numPrestacoes[i] == 2) {
                contP2++;
            } else
                contP3++;
        }
        
        perc1 = (double) contP1 / cliente.length * 100;
        perc2 = (double) contP2 / cliente.length * 100;
        perc3 = (double) contP3 / cliente.length * 100;

        System.out.printf("Percentual de vendas à vista: %.2f%%\n", perc1);
        System.out.printf("Percentual de vendas em 2 parcelas: %.2f%%\n", perc2);
        System.out.printf("Percentual de vendas em 3 parcelas: %.2f%%\n", perc3);

        /*
        3) Encontre a venda mais cara e exiba o seu valor, o nome do cliente e uma mensagem: “Venda à vista” ou “Venda em
        x prestações”, sendo que x deve valer 2 ou 3, conforme o caso.
         */
        double maiorVenda = Double.MIN_VALUE;
        String maiorCliente = " ";
        int prestacoesMaiorVenda = 0;

        for (int i = 0; i < cliente.length; i++) {
            if (valorBase[i] > maiorVenda) {
                maiorVenda = valorBase[i];
                maiorCliente = cliente[i];
                prestacoesMaiorVenda = numPrestacoes[i];
            }
        }

        if (prestacoesMaiorVenda == 1) {
            System.out.printf("Venda mais cara: %.2f. Nome do cliente: %s. Quantidade de parcelas: %d\n", maiorVenda, maiorCliente, prestacoesMaiorVenda);
        } else if (prestacoesMaiorVenda == 2) {
            System.out.printf("Venda mais cara: %.2f. Nome do cliente: %s. Quantidade de parcelas: %d\n", maiorVenda, maiorCliente, prestacoesMaiorVenda);
        } else {
            System.out.printf("Venda mais cara: %.2f. Nome do cliente: %s. Quantidade de parcelas: %d\n", maiorVenda, maiorCliente, prestacoesMaiorVenda);
        }

        //4) Solicite que o usuário digite o nome de um cliente e exiba suas compras e, em seguida, o valor total comprado.
        System.out.printf("Digite o nome do cliente: ");
        String nomeCliente = scan.nextLine();

        double totalComprado = 0;

        for (int i = 0; i < cliente.length; i++) {
            if (nomeCliente.equals(cliente[i])) {
                System.out.printf("Valor da compra: %.2f. Número de prestações: %d\n", valorBase[i], numPrestacoes[i]);
                totalComprado = totalComprado + valorBase[i];
            }
        }
        
        System.out.printf("Valor total comprado: %.2f\n", totalComprado);
        
    }
}