public class Main {
    public static void main(String[] args) {

        Celular meuCelular = new Celular();

        // Setters válidos
        meuCelular.setCor("preto");
        meuCelular.setMarca("samsung");
        meuCelular.setBateria(100);

        System.out.println("=== Dados do Celular ===");
        System.out.println("Cor: " + meuCelular.getCor());
        System.out.println("Marca: " + meuCelular.getMarca());
        System.out.println("Bateria: " + meuCelular.getBateria() + "%");

        System.out.println("\n=== Testando regra especial: setBateria ===");
        meuCelular.setBateria(-10);   // inválido: negativo
        meuCelular.setBateria(150);   // inválido: acima de 100
        meuCelular.setBateria(0);     // válido: limite inferior
        meuCelular.setBateria(100);   // válido: limite superior
        System.out.println("Bateria após tentativas: " + meuCelular.getBateria() + "%");

        System.out.println("\n=== Testes: usarBateria ===");
        meuCelular.usarBateria(30);   // válido: 100 -> 70
        meuCelular.usarBateria(80);   // limite: trava em 0%
        meuCelular.usarBateria(-10);  // inválido: valor negativo

        System.out.println("\n=== Testes: carregarBateria ===");
        meuCelular.carregarBateria(50);  // válido: 0 -> 50
        meuCelular.carregarBateria(80);  // limite: trava em 100%
        meuCelular.carregarBateria(0);   // inválido: valor zero
    }
}