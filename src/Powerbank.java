public class Powerbank implements Carregavel {
    private String marca;
    private int carga;
    private int capacidadeMaxima;

    // CONSTRUTOR
    public Powerbank(String marca, int capacidadeMaxima) {
        this.marca = marca;
        this.setCapacidadeMaxima(capacidadeMaxima);
        this.carga = capacidadeMaxima; // começa cheio
    }

    // GETTERS
    public String getMarca() {
        return marca;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    // SETTER COM REGRA: capacidade deve ser entre 1000 e 30000 mAh
    public void setCapacidadeMaxima(int capacidadeMaxima) {
        if (capacidadeMaxima < 1000 || capacidadeMaxima > 30000) {
            System.out.println("Erro: capacidade deve estar entre 1000 e 30000 mAh. Valor ignorado: " + capacidadeMaxima);
            this.capacidadeMaxima = 10000; // valor padrão
        } else {
            this.capacidadeMaxima = capacidadeMaxima;
        }
    }

    // INTERFACE Carregavel
    @Override
    public void carregar(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Erro: quantidade deve ser maior que zero.");
            return;
        }
        if (carga + quantidade > capacidadeMaxima) {
            carga = capacidadeMaxima;
            System.out.println("Powerbank carregado ao máximo: " + carga + " mAh");
        } else {
            carga = carga + quantidade;
            System.out.println("Powerbank carregado. Nível atual: " + carga + " mAh");
        }
    }

    @Override
    public int getNivelCarga() {
        return carga;
    }
}