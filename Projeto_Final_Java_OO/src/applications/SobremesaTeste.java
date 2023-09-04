package applications;

import entities.Sobremesa;

public class SobremesaTeste {
    public static void main(String[] args) {
        // Criar três instâncias diferentes da classe Sobremesa
        Sobremesa sobremesa1 = new Sobremesa("Bolo de Chocolate", 15.0f, 301, 0.2f, true, "Cobertura de Chocolate");
        Sobremesa sobremesa2 = new Sobremesa("Sorvete", 7.0f, 302, 0.4f, false, "Sabor Baunilha");
        Sobremesa sobremesa3 = new Sobremesa("Pudim", 10.0f, 303, 0.3f, true, "Calda de Caramelo");

        // Imprimir os detalhes das sobremesas
        System.out.println("Detalhes da Sobremesa 1:");
        imprimirDetalhesSobremesa(sobremesa1);

        System.out.println("\nDetalhes da Sobremesa 2:");
        imprimirDetalhesSobremesa(sobremesa2);

        System.out.println("\nDetalhes da Sobremesa 3:");
        imprimirDetalhesSobremesa(sobremesa3);
    }

    private static void imprimirDetalhesSobremesa(Sobremesa sobremesa) {
        System.out.println("Nome: " + sobremesa.getNome());
        System.out.println("Valor: R$" + sobremesa.getValor());
        System.out.println("Código: " + sobremesa.getCodigo());
        System.out.println("Quantidade: " + sobremesa.getQuantidade() + " unidades");
        System.out.println("É Doce? " + (sobremesa.isDoce() ? "Sim" : "Não"));
        System.out.println("Informação Adicional: " + sobremesa.getInformacao());
    }
}
