public class App {
    
    public static void main(String[] args) {
        
        //1) Armazene os dados em vetores e exiba na tela.
        String descricao[] = {"caneta", "lapis", "caderno", "borracha", "regua", "apontador"};
        int qtdEstoque[] = {50, 40, 10, 20, 20, 60};
        double precoUnit[] = {2.00, 1.00, 9.00, 3.00, 4.00, 5.00};

        for (int i = 0; i < descricao.length; i++) {
            System.out.printf("%10s %10d %10.2f\n", descricao[i], qtdEstoque[i], precoUnit[i]);
        }

        //2) Calcule o preço unitário médio dos produtos.
        double somaPreco = 0;
        double cont = 0;
        double precoMedio;

        for (int i = 0; i < descricao.length; i++) {
            somaPreco = somaPreco + precoUnit[i];
            cont++;
        }
        
        precoMedio = somaPreco / cont;
        
        System.out.printf("O preço médio dos produtos é: %.2f\n", precoMedio);

        //3) Encontre o produto mais barato e exiba sua descrição e sua quantidade em estoque.
        double menorPreco = Double.MAX_VALUE;
        int vetorMenorPreco = 0;

        for (int i = 0; i < descricao.length; i++) {
            if (precoUnit[i] < menorPreco) {
                menorPreco = precoUnit[i];
                vetorMenorPreco = i;
            }
        }
        
        System.out.printf("Produto mais barato: %s\n", descricao[vetorMenorPreco]);
        System.out.printf("Preço: %.2f\n", precoUnit[vetorMenorPreco]);
        System.out.printf("Quantidade em estoque: %d\n", qtdEstoque[vetorMenorPreco]);
        
    }
}