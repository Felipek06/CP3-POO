public abstract class Celular {
    private String cor;
    private String marca;
    private int bateria;
    private Dono dono;

    // CONSTRUTOR
    public Celular(String cor, String marca, Dono dono) {
        this.setCor(cor);
        this.setMarca(marca);
        this.setDono(dono);
        this.setBateria(Carregavel.CARGA_MAXIMA);
    }

    // MÉTODO ABSTRATO
    public abstract String tipoDeConector();

    // GETTERS
    public String getCor() {
        return cor;
    }

    public String getMarca() {
        return marca;
    }

    public int getBateria() {
        return bateria;
    }

    public Dono getDono() {
        return dono;
    }

    // SETTERS
    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }

    // REGRA ESPECIAL: bateria só aceita valores entre CARGA_MINIMA e CARGA_MAXIMA
    public void setBateria(int bateria) {
        if (bateria < Carregavel.CARGA_MINIMA || bateria > Carregavel.CARGA_MAXIMA) {
            System.out.println("Erro: bateria deve estar entre " + Carregavel.CARGA_MINIMA + " e " + Carregavel.CARGA_MAXIMA + ". Valor ignorado: " + bateria);
        } else {
            this.bateria = bateria;
        }
    }

    // MÉTODOS
    public void carregarBateria(int quantidade) {
        if (quantidade <= Carregavel.CARGA_MINIMA) {
            System.out.println("Erro: a quantidade para carregar deve ser maior que zero.");
            return;
        }
        if (bateria + quantidade > Carregavel.CARGA_MAXIMA) {
            bateria = Carregavel.CARGA_MAXIMA;
            System.out.println("Bateria carregada ao máximo: " + Carregavel.CARGA_MAXIMA + "%");
        } else {
            bateria = bateria + quantidade;
            System.out.println("Bateria carregada. Nível atual: " + bateria + "%");
        }
    }

    public void usarBateria(int quantidade) {
        if (quantidade <= Carregavel.CARGA_MINIMA) {
            System.out.println("Erro: a quantidade de uso deve ser maior que zero.");
            return;
        }
        if (bateria - quantidade < Carregavel.CARGA_MINIMA) {
            bateria = Carregavel.CARGA_MINIMA;
            System.out.println("Bateria descarregada. Nível atual: " + Carregavel.CARGA_MINIMA + "%");
        } else {
            bateria = bateria - quantidade;
            System.out.println("Bateria utilizada. Nível atual: " + bateria + "%");
        }
    }

    public String exibirInfo() {
        return "Celular | Marca: " + getMarca() + " | Cor: " + getCor() +
               " | Bateria: " + getBateria() + "%" +
               " | Conector: " + tipoDeConector();
    }
}