public class Main {
    public static void main(String[] args) {

        Celular meuCelular = new Celular();
        meuCelular.cor = "preto";
        meuCelular.marca = "samsung";
        meuCelular.bateria = 100;

        System.out.println("=== Dados do Celular ===");
        System.out.println("Cor: " + meuCelular.cor);
        System.out.println("Marca: " + meuCelular.marca);
        System.out.println("Bateria inicial: " + meuCelular.bateria + "%");

        System.out.println("\n=== Testes: usarBateria ===");
        meuCelular.usarBateria(30);   // válido: 100 -> 70
        meuCelular.usarBateria(80);   // limite: tentativa de ir abaixo de 0
        meuCelular.usarBateria(-10);  // inválido: valor negativo

        System.out.println("\n=== Testes: carregarBateria ===");
        meuCelular.carregarBateria(50);  // válido: 0 -> 50
        meuCelular.carregarBateria(80);  // limite: tentativa de ultrapassar 100
        meuCelular.carregarBateria(0);   // inválido: valor zero
    }
}