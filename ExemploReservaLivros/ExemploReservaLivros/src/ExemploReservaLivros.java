public class ExemploReservaLivros {
    public static void main(String[] args) {
        int numeroAlunos = 100; //Número de alunos
        Biblioteca biblioteca = new Biblioteca(); //Criação do objeto Biblioteca

        for (int i = 1; i <= numeroAlunos; i++) { //Loop para criar threads representando alunos e reservar livros
            Thread aluno = new Thread(new Aluno(biblioteca, "Aluno " + i)); //Cria uma nova thread para cada aluno
            aluno.start(); //Inicia a thread do aluno
        }
    }
}

class Biblioteca { //Classe Biblioteca para gerenciar a reserva de livros
    private int livrosDisponiveis = 50; //Números total de livros disponíveis na biblioteca


/*synchronized fornece um mecanismo de exclusão para um recurso compartilhado,
ou seja, apenas uma thread pode executar o recurso por vez.
Quando uma thead executa um metodo syncrhonized, ele "bloqueia" o objeto, não deixando
nenhuma outra thread executar o bloco paralelamente.
*/
    public synchronized boolean reservarLivro(int numLivros, String aluno) {

        if (livrosDisponiveis >= numLivros) { //Verifica se há livros disponíveis para reserva

            System.out.println(aluno + " reservou " + numLivros + " livro(s)."); //Mensagem de confirmação de reserva
            livrosDisponiveis -= numLivros; //Atualiza o número de livros disponíveis

            return true; //Retorna verdadeiro para indicar que a reserva foi feita com sucesso

        } else {

            System.out.println(aluno + " não pôde reservar. Livros insuficientes"); //Mensagem de erro quando não há livros disponíveis

            return false; //Retorna falso para indicar que a reserva não foi feita
        }
    }
}

class Aluno implements Runnable { //Classe Cliente implementando a interface Runnable para representar um cliente
    private Biblioteca biblioteca; //Referência ao objeto Biblioteca para fazer reservas
    private String nome; //Nome do cliente

    public Aluno(Biblioteca biblioteca, String nome) { //Construtor da classe Aluno
        this.biblioteca = biblioteca; //Inicializa o objeto Biblioteca
        this.nome = nome; //Inicializa o nome do aluno
    }

    @Override
    public void run() { //Método run() para executar a reserva de livros quando a thread é iniciada
        int numLivros = 1; //Número de livros que o aluno deseja reservar
        biblioteca.reservarLivro(numLivros, nome); //Chama o metodo reserva de livros da biblioteca
    }
}