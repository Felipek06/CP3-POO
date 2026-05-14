import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Criando os Donos
        Dono dono1 = new Dono("João Silva", "12345678901");
        Dono dono2 = new Dono("Maria Lima", "98765432100");

        // Criando os objetos
        Android meuAndroid = new Android("preto", "samsung", dono1, "Android 14");
        Iphone meuIphone = new Iphone("branco", "apple", dono2, "iOS 17");

        System.out.println("=== Teste de Fogo: Polimorfismo ===");
        List<Celular> celulares = new ArrayList<>();
        celulares.add(meuAndroid);
        celulares.add(meuIphone);

        for (Celular c : celulares) {
            System.out.println(c.exibirInfo());
        }

        System.out.println("\n=== Testando regras das subclasses ===");
        Android androidInvalido = new Android("azul", "motorola", dono1, "");  // inválido: versão vazia
        Iphone iphoneInvalido = new Iphone("preto", "apple", dono2, null);     // inválido: versão nula

        System.out.println("\n=== Testando métodos herdados ===");
        meuAndroid.usarBateria(30);
        meuIphone.carregarBateria(50);

        System.out.println("\n=== Exibindo info após uso ===");
        for (Celular c : celulares) {
            System.out.println(c.exibirInfo());
        }
    }
}