import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Criando os Donos
        Dono dono1 = new Dono("João Silva", "12345678901");
        Dono dono2 = new Dono("Maria Lima", "98765432100");

        // ERRO DE COMPILAÇÃO: descomente a linha abaixo para ver o erro
        // Celular celularGenerico = new Celular("preto", "samsung", dono1);

        // Criando objetos das subclasses
        Android meuAndroid = new Android("preto", "samsung", dono1, "Android 14");
        Iphone meuIphone = new Iphone("branco", "apple", dono2, "iOS 17");

        System.out.println("=== Tipo de Conector ===");
        System.out.println("Android: " + meuAndroid.tipoDeConector());
        System.out.println("iPhone: " + meuIphone.tipoDeConector());

        System.out.println("\n=== Teste de Fogo: Polimorfismo ===");
        List<Celular> celulares = new ArrayList<>();
        celulares.add(meuAndroid);
        celulares.add(meuIphone);

        for (Celular c : celulares) {
            System.out.println(c.exibirInfo());
        }

        System.out.println("\n=== Testando métodos herdados ===");
        meuAndroid.usarBateria(30);
        meuIphone.carregarBateria(50);

        System.out.println("\n=== Exibindo info após uso ===");
        for (Celular c : celulares) {
            System.out.println(c.exibirInfo());
        }
    }
}