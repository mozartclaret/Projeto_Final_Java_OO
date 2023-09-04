package applications;

import java.util.Scanner;
import entities.Solicitante;

public class SolicitanteTeste {
    public static void main(String[] args) {
        // Criar três objetos diferentes da classe Solicitante
        Solicitante solicitante1 = new Solicitante("João", "123456789", "joao@example.com");
        Solicitante solicitante2 = new Solicitante("Maria", "987654321", "maria@example.com");
        Solicitante solicitante3 = new Solicitante("Carlos", "456789123", "carlos@example.com");

        // Imprimir os detalhes dos solicitantes
        System.out.println("Detalhes do Solicitante 1:");
        System.out.println("Nome: " + solicitante1.getNome());
        System.out.println("CPF: " + solicitante1.getCpf());
        System.out.println("E-mail: " + solicitante1.getEmail());

        System.out.println("\nDetalhes do Solicitante 2:");
        System.out.println("Nome: " + solicitante2.getNome());
        System.out.println("CPF: " + solicitante2.getCpf());
        System.out.println("E-mail: " + solicitante2.getEmail());

        System.out.println("\nDetalhes do Solicitante 3:");
        System.out.println("Nome: " + solicitante3.getNome());
        System.out.println("CPF: " + solicitante3.getCpf());
        System.out.println("E-mail: " + solicitante3.getEmail());
    }
}
