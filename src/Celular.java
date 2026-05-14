public class Celular {
    public String cor;
    public String marca;
    public int bateria;

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