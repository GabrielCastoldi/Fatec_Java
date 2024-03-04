import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Variáveis 1
        String nome[] = {"Rui", "Iumi", "Nei", "Susi", "Alan", "Ian", "Bia", "Gil" };
        double salarioBase[] = {3000.00, 1000.00, 800.00, 1800.00, 1100.00, 1500.00, 1200.00, 900.00};
        int numDep[] = {4, 2, 2, 0, 1, 3, 3, 0};
        int opcao = 0;

        //Variáveis 2
        boolean achou = false;
        int dependentes;
        double somaSalarios = 0, media = 0;
        int cont = 0;

        //Variáveis 3
        double salarioFinal = 0;

        //Variáveis 4
        int dependentes2 = 0;
        int cont2 = 0;
        double perc = 0.0;
        int maior = numDep[0];

        //Variáveis 5
        String menorNome = nome[0];
        int menorNomeDependentes = numDep[0];
        double menorNomeSalario = salarioBase[0];


        //1) Armazene os dados em vetores e exiba na tela.
        for (int i = 0; i < nome.length; i++) {
            System.out.printf("%10s %10.2f %10d\n", nome[i], salarioBase[i], numDep[i]);
        }

        do {
            System.out.printf("\nMenu\n" +
                    "1 - Média dos salários base\n" +
                    "2 - Salários finais\n" +
                    "3 - Porcentagem de funcionários com dependentes\n" +
                    "4 - Nome e número de dependentes do funcionário com menor salário\n" +
                    "5 - Sair\n" +
                    "Digite a opção: ");
            opcao = scan.nextInt();

            switch (opcao) {

                //2) Calcule e escreva a média dos salários base dos funcionários.
                case 1:
                    achou = false;
                    dependentes = 0;
                    somaSalarios = 0;
                    media = 0;
                    cont = 0;

                    System.out.printf("Digite o número de dependentes: ");
                    dependentes = scan.nextInt();

                    for (int i = 0; i < nome.length; i++) {
                        if (dependentes == numDep[i]) {
                            achou = true;
                            somaSalarios += salarioBase[i];
                            cont++;
                        }
                    }

                    if (!achou) {
                        System.out.printf("Nenhum funcionário possui %d filho(s)", dependentes);
                    } else {
                        media = somaSalarios / cont;
                        System.out.printf("A média de salário de funcionários com %d filho(s) é: %.2f", dependentes, media);
                    }
                    break;

                case 2:
                    /*3) Exiba os nomes e os salários finais de todos os funcionários, sendo que, para cada um dos dependentes,
                    é acrescentado o salário família ao salário base. O valor do salário família é 70 reais para salário base até
                    1110 reais e 50 reais para salário base acima de 1100 reais até 1550 reais. Acima desse valor, o funcionário
                    não tem direito ao salário-família.*/
                    salarioFinal = 0;

                    for (int i = 0; i < nome.length; i++) {
                        if (salarioBase[i] <= 1110) {
                            salarioFinal = salarioBase[i] + 70 * numDep[i];
                        } else if (salarioBase[i] > 1110 && salarioBase[i] <= 1550) {
                            salarioFinal = salarioBase[i] + 50 * numDep[i];
                        } else {
                            salarioFinal = salarioBase[i];
                        }
                        System.out.printf("%s %.2f\n", nome[i], salarioFinal);
                    }
                    break;

                case 3:
                    /*4) Solicite que o usuário digite o número de dependentes e calcule e exiba a porcentagem de funcionários que
                    tem mais dependentes do que o número digitado.*/
                    dependentes2 = 0;
                    cont2 = 0;
                    perc = 0;
                    maior = numDep[0];

                    System.out.println("Digite o número de filhos: ");
                    dependentes2 = scan.nextInt();

                    for (int i = 0; i < nome.length; i++) {
                        if (dependentes2 < numDep[i]) {
                            cont2++;
                        }
                    }

                    for (int i = 0; i < nome.length; i++) {
                        if (maior < numDep[i]) {
                            maior = numDep[i];
                        }
                    }

                    if (dependentes2 == maior) {
                        System.out.printf("Nenhum funcionário tem mais que %d filhos", dependentes2);
                    } else {
                        perc = (double) cont2 / nome.length * 100;
                        System.out.printf("Perc: %.2f%%", perc);
                    }
                    break;

                case 4:
                    //5) Qual é o nome e o número de dependentes do funcionário que tem o menor salário?
                    menorNome = nome[0];
                    menorNomeDependentes = numDep[0];
                    menorNomeSalario = salarioBase[0];

                    for (int i = 0; i < nome.length; i++) {
                        if (salarioBase[i] < menorNomeSalario) {
                            menorNomeSalario = salarioBase[i];
                            menorNomeDependentes = numDep[i];
                            menorNome = nome[i];
                        }
                    }

                    System.out.printf("Funcionário com menor salário\n" +
                            "Nome: %s. Salário: %.2f. Dependentes: %d.", menorNome, menorNomeSalario, menorNomeDependentes);
                    break;

                case 5:
                    System.out.println("Encerrado");
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 5);
    }
}