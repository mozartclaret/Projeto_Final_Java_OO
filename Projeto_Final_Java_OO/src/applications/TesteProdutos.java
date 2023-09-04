package applications;

import entities.Bebida;
import entities.Comida;
import entities.Sobremesa;

public class TesteProdutos {
    public static void main(String[] args) {
        Bebida cocaCola = new Bebida("Coca-Cola", 3.0f, 101, true, 0.5f, "Coca-Cola Company");
        Comida pizza = new Comida("Pizza Margherita", 20.0f, 202, 0.5f, false, "Molho de tomate, queijo, manjericão");
        Sobremesa boloChocolate = new Sobremesa("Bolo de Chocolate", 15.0f, 303, 0.3f, true, "Cobertura de chocolate");

        // Imprimindo informações dos produtos
        System.out.println("Informações da Bebida:");
        System.out.println("Nome: " + cocaCola.getNome());
        System.out.println("Valor: R$" + cocaCola.getValor());
        System.out.println("Código: " + cocaCola.getCodigo());
        System.out.println("Gelada: " + cocaCola.isGelada());
        System.out.println("Tamanho: " + cocaCola.getTamanho() + " litros");
        System.out.println("Marca: " + cocaCola.getMarca());

        System.out.println("\nInformações da Comida:");
        System.out.println("Nome: " + pizza.getNome());
        System.out.println("Valor: R$" + pizza.getValor());
        System.out.println("Código: " + pizza.getCodigo());
        System.out.println("Peso: " + pizza.getPeso() + " kg");
        System.out.println("Vegano: " + pizza.isVegano());
        System.out.println("Ingredientes: " + pizza.getIngredientes());

        System.out.println("\nInformações da Sobremesa:");
        System.out.println("Nome: " + boloChocolate.getNome());
        System.out.println("Valor: R$" + boloChocolate.getValor());
        System.out.println("Código: " + boloChocolate.getCodigo());
        System.out.println("Quantidade: " + boloChocolate.getQuantidade() + " kg");
        System.out.println("Doce: " + boloChocolate.isDoce());
        System.out.println("Informação adicional: " + boloChocolate.getInformacao());
    }
}