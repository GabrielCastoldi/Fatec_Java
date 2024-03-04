import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        //1) Armazene os dados em vetores e exiba-os na tela.
        int codigo[] = {110, 112, 130, 114, 119, 150, 160, 164};
        char tipo[] = {'r', 'g', 'r', 'r', 'c', 'g', 'c', 'r'};
        double aluguelBase[] = {400, 800, 600, 300, 1500, 1100, 1800, 900};
        int status[] = {1, 1, 2, 1, 2, 1, 1, 2};

        for (int i = 0; i < codigo.length; i++) {
            System.out.printf("%10d %10c %10.2f %10d\n", codigo[i], tipo[i], aluguelBase[i], status[i]);
        }

        //2) Calcule e escreva a média dos aluguéis base de imóveis ocupados.
        double soma = 0, media;
        int cont = 0;

        for (int i = 0; i < codigo.length; i++) {
            if (status[i] == 1) {
                soma = soma + aluguelBase[i];
                cont++;
            }
        }
        
        media = soma / cont;
        
        System.out.printf("A média é %.2f\n", media);

        //3) Encontre as porcentagens de imóveis de cada categoria.
        double percR, percC, percG;
        int contR = 0, contC = 0, contG = 0;

        for (int i = 0; i < codigo.length; i++) {
            if (tipo[i] == 'r') {
                contR++;
            } else if (tipo[i] == 'c') {
                contC++;
            } else {
                contG++;
            }
        }
        
        percR = (double) contR / codigo.length * 100;
        percC = (double) contC / codigo.length * 100;
        percG = (double) contG / codigo.length * 100;

        System.out.printf("Percentual de imóveis resideciais: %.2f%%\n", percR);
        System.out.printf("Percentual de imóveis comerciais: %.2f%%\n", percC);
        System.out.printf("Percentual de galpões: %.2f%%\n", percG);

        /*
        4) Solicite que o usuário digite o código de um imóvel e escreva o seu aluguel final, que é calculado com a seguinte regra:
        Imóvel residencial: aluguel base mais 5% do aluguel base;
        Imóvel galpão: aluguel base mais 10% do aluguel base;
        Imóvel comercial: aluguel base mais 20% do aluguel base;
         */
        int codDig;
        double aluguelFinal = 0;

        System.out.println("Digite o código: ");
        codDig = scan.nextInt();

        for (int i = 0; i < codigo.length; i++) {
            if (codDig == codigo[i]) {
                if (codigo[i] == 'r') {
                    aluguelFinal = aluguelBase[i] + aluguelBase[i] * 0.05;
                } else if (codigo[i] == 'c') {
                    aluguelFinal = aluguelBase[i] + aluguelBase[i] * 0.10;
                } else {
                    aluguelFinal = aluguelBase[i] + aluguelBase[i] * 0.20;
                }
            }
        }
        
        System.out.printf("Aluguel final: %.2f\n", aluguelFinal);
        
    }
}