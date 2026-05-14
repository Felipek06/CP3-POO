public class Celular {
    private String cor;
    private String marca;
    private int bateria;

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

    // SETTERS
    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    // REGRA ESPECIAL: bateria só aceita valores entre 0 e 100
    public void setBateria(int bateria) {
        if (bateria < 0 || bateria > 100) {
            System.out.println("Erro: bateria deve estar entre 0 e 100. Valor ignorado: " + bateria);
        } else {
            this.bateria = bateria;
        }
    }

    // MÉTODOS DA MISSÃO ANTERIOR
    public void carregarBateria(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Erro: a quantidade para carregar deve ser maior que zero.");
            return;
        }
        if (bateria + quantidade > 100) {
            bateria = 100;
            System.out.println("Bateria carregada ao máximo: 100%");
        } else {
            bateria = bateria + quantidade;
            System.out.println("Bateria carregada. Nível atual: " + bateria + "%");
        }
    }

    public void usarBateria(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Erro: a quantidade de uso deve ser maior que zero.");
            return;
        }
        if (bateria - quantidade < 0) {
            bateria = 0;
            System.out.println("Bateria descarregada. Nível atual: 0%");
        } else {
            bateria = bateria - quantidade;
            System.out.println("Bateria utilizada. Nível atual: " + bateria + "%");
        }
    }
}