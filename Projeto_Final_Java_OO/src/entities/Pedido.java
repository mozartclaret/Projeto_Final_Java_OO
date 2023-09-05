package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String descricao;
    private LocalDateTime data;
    private boolean web;
    private Solicitante solicitante; // Relacionamento 1:1 com Solicitante
    private List<Produto> produtos; // Relacionamento 1:n com Produto

    public Pedido(String descricao, LocalDateTime data, boolean web, Solicitante solicitante) {
        this.descricao = descricao;
        this.data = data;
        this.web = web;
        this.solicitante = solicitante;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public boolean isWeb() {
        return web;
    }

    public void setWeb(boolean web) {
        this.web = web;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "descricao='" + descricao + '\'' +
                ", data=" + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +
                ", web=" + web +
                ", solicitante=" + solicitante +
                ", produtos=" + produtos +
                '}';
    }
}
