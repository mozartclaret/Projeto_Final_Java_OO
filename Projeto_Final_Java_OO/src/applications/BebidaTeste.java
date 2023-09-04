package applications;

import entities.Bebida;

public class BebidaTeste {
    public static void main(String[] args) {
        // Criar três instâncias diferentes da classe Bebida
        Bebida bebida1 = new Bebida("Refrigerante", 3.0f, 101, true, 2.0f, "Coca-Cola");
        Bebida bebida2 = new Bebida("Suco de Laranja", 2.5f, 102, false, 0.5f, "Del Valle");
        Bebida bebida3 = new Bebida("Água Mineral", 1.0f, 103, false, 0.5f, "Crystal");

        // Imprimir os detalhes das bebidas
        System.out.println("Detalhes da Bebida 1:");
        imprimirDetalhesBebida(bebida1);

        System.out.println("\nDetalhes da Bebida 2:");
        imprimirDetalhesBebida(bebida2);

        System.out.println("\nDetalhes da Bebida 3:");
        imprimirDetalhesBebida(bebida3);
    }

    private static void imprimirDetalhesBebida(Bebida bebida) {
        System.out.println("Nome: " + bebida.getNome());
        System.out.println("Valor: R$" + bebida.getValor());
        System.out.println("Código: " + bebida.getCodigo());
        System.out.println("É Gelada? " + (bebida.isGelada() ? "Sim" : "Não"));
        System.out.println("Tamanho: " + bebida.getTamanho() + " litros");
        System.out.println("Marca: " + bebida.getMarca());
    }
}
