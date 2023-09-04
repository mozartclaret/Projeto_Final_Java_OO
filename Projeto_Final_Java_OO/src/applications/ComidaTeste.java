package applications;

import entities.Comida;

public class ComidaTeste {
    public static void main(String[] args) {
        // Criar três instâncias diferentes da classe Comida
        Comida comida1 = new Comida("Pizza", 25.0f, 201, 0.5f, false, "Queijo, Tomate, Massa");
        Comida comida2 = new Comida("Salada", 10.0f, 202, 0.3f, true, "Alface, Tomate, Cenoura");
        Comida comida3 = new Comida("Hambúrguer", 15.0f, 203, 0.2f, false, "Carne, Queijo, Alface");

        // Imprimir os detalhes das comidas
        System.out.println("Detalhes da Comida 1:");
        imprimirDetalhesComida(comida1);

        System.out.println("\nDetalhes da Comida 2:");
        imprimirDetalhesComida(comida2);

        System.out.println("\nDetalhes da Comida 3:");
        imprimirDetalhesComida(comida3);
    }

    private static void imprimirDetalhesComida(Comida comida) {
        System.out.println("Nome: " + comida.getNome());
        System.out.println("Valor: R$" + comida.getValor());
        System.out.println("Código: " + comida.getCodigo());
        System.out.println("Peso: " + comida.getPeso() + " kg");
        System.out.println("É Vegano? " + (comida.isVegano() ? "Sim" : "Não"));
        System.out.println("Ingredientes: " + comida.getIngredientes());
    }
}





