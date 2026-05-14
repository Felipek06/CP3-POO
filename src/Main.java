public class Main {
    public static void main(String[] args) {

        // Criando o Dono
        Dono dono1 = new Dono("João Silva", "12345678901");

        // Criando o Celular já com o Dono associado
        Celular meuCelular = new Celular("preto", "samsung", dono1);

        System.out.println("=== Dados do Celular ===");
        System.out.println("Cor: " + meuCelular.getCor());
        System.out.println("Marca: " + meuCelular.getMarca());
        System.out.println("Bateria: " + meuCelular.getBateria() + "%");
        System.out.println("Dono: " + meuCelular.getDono().getNome());
        System.out.println("CPF do Dono: " + meuCelular.getDono().getCpf());

        System.out.println("\n=== Testando regra do CPF ===");
        Dono donoInvalido = new Dono("Maria", "123");        // inválido: CPF curto
        Dono donoInvalido2 = new Dono("Carlos", null);       // inválido: CPF nulo
        Dono donoValido = new Dono("Ana Lima", "98765432100"); // válido

        System.out.println("\n=== Testando regra especial: setBateria ===");
        meuCelular.setBateria(-10);   // inválido: negativo
        meuCelular.setBateria(150);   // inválido: acima de 100
        meuCelular.setBateria(100);   // válido

        System.out.println("\n=== Testes: usarBateria ===");
        meuCelular.usarBateria(30);   // válido: 100 -> 70
        meuCelular.usarBateria(80);   // limite: trava em 0%

        System.out.println("\n=== Testes: carregarBateria ===");
        meuCelular.carregarBateria(50);  // válido: 0 -> 50
        meuCelular.carregarBateria(80);  // limite: trava em 100%
    }
}