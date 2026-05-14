import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Criando os Donos
        Dono dono1 = new Dono("João Silva", "12345678901");
        Dono dono2 = new Dono("Maria Lima", "98765432100");

        // Criando objetos
        Android meuAndroid = new Android("preto", "samsung", dono1, "Android 14");
        Iphone meuIphone = new Iphone("branco", "apple", dono2, "iOS 17");
        Powerbank meuPowerbank = new Powerbank("Anker", 20000);

        // ERRO DE COMPILAÇÃO: descomente para ver o erro
        // Celular celularGenerico = new Celular("preto", "samsung", dono1);

        System.out.println("=== Teste de Fogo: Polimorfismo com interface Carregavel ===");
        List<Carregavel> carregaveis = new ArrayList<>();
        carregaveis.add(meuAndroid);
        carregaveis.add(meuIphone);
        carregaveis.add(meuPowerbank);

        for (Carregavel c : carregaveis) {
            System.out.println("Nível de carga atual: " + c.getNivelCarga());
            c.carregar(50);
            System.out.println("Nível após carregar: " + c.getNivelCarga());
            System.out.println("---");
        }

        System.out.println("\n=== Testes com try/catch ===");

        // Teste 1: Dono com CPF inválido
        try {
            Dono donoInvalido = new Dono("Carlos", "123");
            if (donoInvalido.getCpf() == null) {
                throw new IllegalArgumentException("CPF inválido rejeitado corretamente.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Capturado: " + e.getMessage());
        }

        // Teste 2: Powerbank com capacidade inválida
        try {
            Powerbank pbInvalido = new Powerbank("Genérico", 500);
            if (pbInvalido.getCapacidadeMaxima() == 10000) {
                throw new IllegalArgumentException("Capacidade inválida, assumiu valor padrão de 10000 mAh.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Capturado: " + e.getMessage());
        }

        // Teste 3: Android com versão vazia
        try {
            Android androidInvalido = new Android("azul", "motorola", dono1, "");
            if (androidInvalido.getVersaoAndroid() == null) {
                throw new IllegalArgumentException("Versão Android vazia rejeitada corretamente.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Capturado: " + e.getMessage());
        }

        // Teste 4: Iphone com versão nula
        try {
            Iphone iphoneInvalido = new Iphone("preto", "apple", dono2, null);
            if (iphoneInvalido.getVersaoIOS() == null) {
                throw new IllegalArgumentException("Versão iOS nula rejeitada corretamente.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Capturado: " + e.getMessage());
        }

        // Teste 5: setBateria com valor inválido
        try {
            meuAndroid.setBateria(200);
            if (meuAndroid.getBateria() != 200) {
                throw new IllegalArgumentException("Bateria 200% rejeitada corretamente.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Capturado: " + e.getMessage());
        }

        System.out.println("\n=== Exibindo info final ===");
        List<Celular> celulares = new ArrayList<>();
        celulares.add(meuAndroid);
        celulares.add(meuIphone);

        for (Celular c : celulares) {
            System.out.println(c.exibirInfo());
        }
    }
}