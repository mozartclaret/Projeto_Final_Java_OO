package applications;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import entities.Bebida;
import entities.Comida;
import entities.Pedido;
import entities.Produto;
import entities.Sobremesa;
import entities.Solicitante;

public class PedidoTeste {
    public static void main(String[] args) {
        // Criar três objetos diferentes da classe Solicitante
        Solicitante solicitante1 = new Solicitante("João", "123456789", "joao@example.com");
        Solicitante solicitante2 = new Solicitante("Maria", "987654321", "maria@example.com");
        Solicitante solicitante3 = new Solicitante("Carlos", "456789123", "carlos@example.com");

        // Criar três objetos diferentes da classe Pedido com produtos
        Pedido pedido1 = criarPedido("Pedido 1", LocalDateTime.now(), true, solicitante1);
        Pedido pedido2 = criarPedido("Pedido 2", LocalDateTime.now(), false, solicitante2);
        Pedido pedido3 = criarPedido("Pedido 3", LocalDateTime.now(), true, solicitante3);

        // Imprimir os detalhes dos pedidos
        imprimirDetalhesPedido(pedido1);
        imprimirDetalhesPedido(pedido2);
        imprimirDetalhesPedido(pedido3);
    }

    private static Pedido criarPedido(String descricao, LocalDateTime data, boolean web, Solicitante solicitante) {
        Pedido pedido = new Pedido(descricao, data, web, solicitante);

        // Adicionar produtos aos pedidos
        Produto produto1 = new Bebida("Refrigerante", 3.0f, 101, true, 2.0f, "Coca-Cola");
        Produto produto2 = new Comida("Pizza", 25.0f, 201, 0.5f, false, "Queijo, Tomate, Massa");
        Produto produto3 = new Sobremesa("Bolo de Chocolate", 15.0f, 301, 0.2f, true, "Cobertura de Chocolate");

        pedido.adicionarProduto(produto1);
        pedido.adicionarProduto(produto2);
        pedido.adicionarProduto(produto3);

        return pedido;
    }

    private static void imprimirDetalhesPedido(Pedido pedido) {
    	System.out.println();
    	System.out.println();
    	System.out.println("==============================================");
    	System.out.println("Detalhes do Pedido:");
        System.out.println("Descrição: " + pedido.getDescricao());
        
        // Formatando a data no padrão "DD/MM/YYYY"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = pedido.getData().format(formatter);
        
        System.out.println("Data: " + dataFormatada);
        
        // Substituir true/false por Sim/Não
        String pedidoWeb = pedido.isWeb() ? "Sim" : "Não";
        System.out.println("Pedido via Web? " + pedidoWeb);
        
        System.out.println("Solicitante: " + pedido.getSolicitante().getNome());
        System.out.println("CPF do Solicitante: " + pedido.getSolicitante().getCpf());
        System.out.println("E-mail do Solicitante: " + pedido.getSolicitante().getEmail());

        List<Produto> produtosDoPedido = pedido.getProdutos();
        if (!produtosDoPedido.isEmpty()) {
            System.out.println("\nProdutos no Pedido:");
            for (Produto produto : produtosDoPedido) {
                System.out.println("Nome: " + produto.getNome());
                System.out.println("Valor: R$" + produto.getValor());
            }
        } else {
            System.out.println("\nNenhum produto foi adicionado a este pedido.");
        }
    }
}



