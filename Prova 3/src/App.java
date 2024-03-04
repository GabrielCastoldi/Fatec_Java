import java.util.Scanner;
public class App {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Variáveis 1
        int codigo[] = {110, 112, 130, 114, 123, 456, 100, 200};
        String descricao[] = {"botao", "linha", "tesoura", "fita", "revista", "barbante", "agulha", "tecido"};
        int estoque[] = {20, 10, 3, 8, 3, 10, 8, 12};
        int estoqueMinimo[] = {15, 12, 5, 6, 2, 15, 6, 10};
        double precoUnit[] = {0.3, 2.6, 13, 0.8, 10, 8, 5.2, 3.9};

        //Variáveis 2
        int opcao = 0;

        //Vetores 3
        int codigoVenda = 0;
        boolean achou = false;
        int quantDesejada;
        double valorCompra = 0.0;

        //Vetores 4
        int quantComprar = 0;
        String itemComprar = " ";

        //1) Crie vetores para armazenar os dados e exiba os dados na tela.
        for (int i = 0; i < codigo.length; i++) {
            System.out.printf("%10d %10s %10d %10d %10.2f\n", codigo[i], descricao[i], estoque[i], estoqueMinimo[i], precoUnit[i]);
        }

        /*2) Crie o seguinte menu de opções (incluir mensagem de opção inválida, com a cláusula default):
        Menu
        1 – Efetuar venda
        2 – Verificar estoque mínimo
        3 – Sair
        Digite a opção desejada:*/
        do {

            opcao = 0;

            System.out.println("\nMenu\n" +
                    "1 - Efetuar venda\n" +
                    "2 - Verificar estoque mínimo\n" +
                    "3 - Sair\n" +
                    "Digite a opção desejada: ");
            opcao = scan.nextInt();

            switch (opcao) {

                case 1:

                    /*3) Na opção 1, solicite que o usuário digite o código do produto. Se o código informado for válido, solicite que o usuário digite
                    a quantidade desejada. Verifique se há estoque e, se houver, efetue a venda, dando baixa no estoque, e exiba o valor a ser pago
                    pelo cliente. Se o estoque não for suficiente, exiba a mensagem “Estoque suficiente”. Se o código informado for inválido, exiba
                    a mensagem “Código inexistente”.*/
                    codigoVenda = 0;
                    quantDesejada = 0;
                    valorCompra = 0.0;
                    achou = false;

                    System.out.println("Digite o código do produto: ");
                    codigoVenda = scan.nextInt();

                    for (int i = 0; i < codigo.length; i++) {
                        if (codigoVenda == codigo[i]) {
                            achou = true;
                            if (achou) {
                                System.out.println("Digite a quantidade desejada: ");
                                quantDesejada = scan.nextInt();
                                if (quantDesejada < estoque[i]) {
                                    valorCompra = precoUnit[i] * quantDesejada;
                                    estoque[i] = estoque[i] - quantDesejada;
                                    System.out.printf("Valor da venda: %.2f", valorCompra);
                                } else {
                                    System.out.println("Estoque insuficiente");
                                }
                            }
                        }
                    }

                    if (!achou) {
                        System.out.println("Código inexistente");
                    }
                    break;

                case 2:

                    /*4) Na opção 2, exiba as descrições dos produtos com estoque abaixo do estoque mínimo e informe quantos itens devem ser
                    comprados para atingir o estoque mínimo.*/
                    quantComprar = 0;
                    itemComprar = " ";

                    for (int i = 0; i < codigo.length; i++) {
                        if (estoque[i] < estoqueMinimo[i]) {
                            quantComprar = estoqueMinimo[i] - estoque[i];
                            itemComprar = descricao[i];
                            System.out.printf("É necessário comprar: %d %s\n", quantComprar, itemComprar);
                        } else {
                            System.out.printf("Não é necessário comprar: %s\n", descricao[i]);
                        }


                    }
                    break;

                case 3:

                    //5) Na opção 3, escreva a mensagem “Encerrando o sistema”.
                    System.out.println("Encerrando o sistema");
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 3);
    }
}