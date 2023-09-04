package applications;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.*;

public class InformaPedido {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicializar listas para armazenar produtos
        List<Produto> produtos = new ArrayList<>();

        // Pedir informações do Pedido
        System.out.println("Informe os dados do Pedido:");
        System.out.print("Descrição do Pedido: ");
        String descricaoPedido = scanner.nextLine();

//        System.out.print("Data do Pedido (no formato yyyy-MM-dd HH:mm:ss): ");
        System.out.print("Data do Pedido (no formato dd/MM/yyyy): ");
        String dataStr = scanner.nextLine();

//        LocalDateTime dataPedido = LocalDateTime.parse(dataStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDate dataPedido = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Pedido via Web? (true/false): ");
        boolean webPedido = scanner.nextBoolean();

        scanner.nextLine(); // Limpar o buffer do scanner

        // Pedir informações do Solicitante
        System.out.println("\nInforme os dados do Solicitante:");
        System.out.print("Nome do Solicitante: ");
        String nomeSolicitante = scanner.nextLine();

        System.out.print("CPF do Solicitante: ");
        String cpfSolicitante = scanner.nextLine();

        System.out.print("E-mail do Solicitante: ");
        String emailSolicitante = scanner.nextLine();

        Solicitante solicitante = new Solicitante(nomeSolicitante, cpfSolicitante, emailSolicitante);

        boolean maisProdutos = true;
        while (maisProdutos) {
            try {
                System.out.println("\nEscolha o tipo de Produto:");
                System.out.println("1. Bebida");
                System.out.println("2. Comida");
                System.out.println("3. Sobremesa");
                System.out.print("Digite o número do tipo de Produto: ");
                int tipoProduto = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner

                Produto produto = null;

                switch (tipoProduto) {
                    case 1:
                        produto = criarBebida(scanner);
                        break;
                    case 2:
                        produto = criarComida(scanner);
                        break;
                    case 3:
                        produto = criarSobremesa(scanner);
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha um tipo de Produto válido.");
                        break;
                }

                if (produto != null) {
                    produtos.add(produto);
                    System.out.print("Deseja informar mais Produtos? (true/false): ");
                    maisProdutos = scanner.nextBoolean();
                    scanner.nextLine(); // Limpar o buffer do scanner
                }
            } catch (InputMismatchException e) {
                System.err.println("Erro: Valor inserido inválido. Por favor, insira um valor válido.");
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        }

        // Criar o Pedido
        Pedido pedido = new Pedido(descricaoPedido, dataPedido, webPedido, solicitante);

        // Adicionar os Produtos ao Pedido
        for (Produto produto : produtos) {
            pedido.adicionarProduto(produto);
        }

        // Exibir os Dados do Pedido e o Total a Pagar
        System.out.println("\nDados do Pedido:");
        System.out.println(pedido);

        float totalAPagar = calcularTotalAPagar(produtos);
        System.out.println("\nTotal a Pagar: R$" + totalAPagar);

        scanner.close();
    }

    private static Produto criarBebida(Scanner scanner) {
        System.out.println("\nInforme os dados da Bebida:");
        System.out.print("Nome da Bebida: ");
        String nomeBebida = scanner.nextLine();

        float valorBebida = 0;
        while (valorBebida <= 0) {
            try {
                System.out.print("Valor da Bebida (maior que zero): ");
                valorBebida = scanner.nextFloat();
                if (valorBebida <= 0) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.err.println("Erro: Valor da Bebida deve ser maior que zero.");
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        }

        System.out.print("Código da Bebida: ");
        int codigoBebida = scanner.nextInt();

        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("É Gelada? (true/false): ");
        boolean geladaBebida = scanner.nextBoolean();

        scanner.nextLine(); // Limpar o buffer do scanner
        float tamanhoBebida = 0;
        while (tamanhoBebida <= 0) {
            try {
                System.out.print("Tamanho da Bebida (em litros, maior que zero): ");
                tamanhoBebida = scanner.nextFloat();
                if (tamanhoBebida <= 0) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.err.println("Erro: Tamanho da Bebida deve ser maior que zero.");
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        }

        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("Marca da Bebida: ");
        String marcaBebida = scanner.nextLine();

        return new Bebida(nomeBebida, valorBebida, codigoBebida, geladaBebida, tamanhoBebida, marcaBebida);
    }

    private static Comida criarComida(Scanner scanner) {
        System.out.println("\nInforme os dados da Comida:");
        System.out.print("Nome da Comida: ");
        String nomeComida = scanner.nextLine();

        float valorComida = 0;
        while (valorComida <= 0) {
            try {
                System.out.print("Valor da Comida (maior que zero): ");
                valorComida = scanner.nextFloat();
                if (valorComida <= 0) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.err.println("Erro: Valor da Comida deve ser maior que zero.");
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        }

        System.out.print("Código da Comida: ");
        int codigoComida = scanner.nextInt();

        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("Peso da Comida: ");
        float pesoComida = scanner.nextFloat();

        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("É Vegano? (true/false): ");
        boolean veganoComida = scanner.nextBoolean();

        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("Ingredientes da Comida: ");
        String ingredientesComida = scanner.nextLine();

        return new Comida(nomeComida, valorComida, codigoComida, pesoComida, veganoComida, ingredientesComida);
    }

    private static Sobremesa criarSobremesa(Scanner scanner) {
        System.out.println("\nInforme os dados da Sobremesa:");
        System.out.print("Nome da Sobremesa: ");
        String nomeSobremesa = scanner.nextLine();

        float valorSobremesa = 0;
        while (valorSobremesa <= 0) {
            try {
                System.out.print("Valor da Sobremesa (maior que zero): ");
                valorSobremesa = scanner.nextFloat();
                if (valorSobremesa <= 0) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.err.println("Erro: Valor da Sobremesa deve ser maior que zero.");
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        }

        System.out.print("Código da Sobremesa: ");
        int codigoSobremesa = scanner.nextInt();

        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("Quantidade da Sobremesa (em kg): ");
        float quantidadeSobremesa = scanner.nextFloat();

        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("É Doce? (true/false): ");
        boolean doceSobremesa = scanner.nextBoolean();

        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("Informação Adicional da Sobremesa: ");
        String informacaoSobremesa = scanner.nextLine();

        return new Sobremesa(nomeSobremesa, valorSobremesa, codigoSobremesa, quantidadeSobremesa, doceSobremesa, informacaoSobremesa);
    }

    private static float calcularTotalAPagar(List<Produto> produtos) {
        float totalAPagar = 0;
        for (Produto produto : produtos) {
            totalAPagar += produto.getValor();
        }
        return totalAPagar;
    }
}