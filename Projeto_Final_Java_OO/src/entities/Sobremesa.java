package entities;

public class Sobremesa extends Produto {
    private float quantidade;
    private boolean doce;
    private String informacao;

    public Sobremesa(String nome, float valor, int codigo, float quantidade, boolean doce, String informacao) {
        super(nome, valor, codigo);
        this.quantidade = quantidade;
        this.doce = doce;
        this.informacao = informacao;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isDoce() {
        return doce;
    }

    public void setDoce(boolean doce) {
        this.doce = doce;
    }

    public String getInformacao() {
        return informacao;
    }

    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }
    
    @Override
    public String toString() {
        return "Sobremesa{" +
                "nome='" + getNome() + '\'' +
                ", valor=" + getValor() +
                ", codigo=" + getCodigo() +
                ", quantidade=" + quantidade +
                ", doce=" + doce +
                ", informacao='" + informacao + '\'' +
                '}';
    }
    
    @Override
    public String getDescricao() {
        return "Sobremesa: " + getNome() + " (Informação: " + informacao + ")";
    }
}
