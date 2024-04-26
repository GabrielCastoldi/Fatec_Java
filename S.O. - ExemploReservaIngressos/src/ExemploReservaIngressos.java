public class ExemploReservaIngressos {
    public static void main(String[] args) {
        int numeroClientes = 5; //Número de clientes
        Cinema cinema = new Cinema(); //Criação do objeto Cinema

        for (int i = 1; i <= numeroClientes; i++) { //Loop para criar threads representando clientes e reservar ingressos
            Thread cliente = new Thread(new Cliente(cinema, "Cliente " + i)); //Cria uma nova thread para cada cliente
            cliente.start(); //Inicia a thread do cliente
        }
    }
}

class Cinema { //Classe Cinema para gerenciar a reserva de ingressos
    private int assentosDisponiveis = 10; //Número total de assentos disponíveis no cinema

    public synchronized boolean reservarIngresso(int numAssentos, String cliente) { //Método para reservar ingressos de forma sincronizada para garantir thread safety

        if (assentosDisponiveis >= numAssentos) {//Verifica se há assentos disponíveis para reserva

            System.out.println(cliente + " reservou " + numAssentos + " assentos."); //Mensagem de confirmação da reserva
            assentosDisponiveis -= numAssentos; //Atualiza o número de assentos disponíveis

            return true; //Retorna verdadeiro para indicar que a reserva foi feita com sucesso

        } else {

            System.out.println(cliente + " não pôde reservar. Assentos insuficientes"); //Mensagem de erro quando não há assentos disponíveis

            return false; //Retorna falso para indicar que a reserva não foi feita
        }
    }
}

class Cliente implements Runnable { //Classe Cliente implementando a interface Runnable para representar um cliente
    private Cinema cinema; //Referência ao objeto Cinema para fazer reservas
    private String nome; //Nome do cliente

    public Cliente(Cinema cinema, String nome) { //Construtor da classe Cliente
        this.cinema = cinema; //Inicializa o objeto Cinema
        this.nome = nome; //Inicializa o nome do cliente
    }

    @Override
    public void run() { //Método run() para executar a reserva de ingressos quando a thread é iniciada
        int numAssentos = 2; //Número de assentos que o cliente deseja reservar
        cinema.reservarIngresso(numAssentos, nome); //Chama o método de reserva de ingressos do cinema
    }
}