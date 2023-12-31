package entities;

public class Comida extends Produto {
    private float peso;
    private boolean vegano;
    private String ingredientes;

    public Comida(String nome, float valor, int codigo, float peso, boolean vegano, String ingredientes) {
        super(nome, valor, codigo);
        this.peso = peso;
        this.vegano = vegano;
        this.ingredientes = ingredientes;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public boolean isVegano() {
        return vegano;
    }

    public void setVegano(boolean vegano) {
        this.vegano = vegano;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    @Override
    public String toString() {
        return "Comida{" +
                "nome='" + getNome() + '\'' +
                ", valor=" + getValor() +
                ", codigo=" + getCodigo() +
                ", peso=" + peso +
                ", vegano=" + vegano +
                ", ingredientes='" + ingredientes + '\'' +
                '}';
    }
    
    @Override
    public String getDescricao() {
        return "Comida: " + getNome() + " (Ingredientes: " + ingredientes + ")";
    }
}

