public class Main {
    public static void main(String[] args) {

        // Criando os Donos
        Dono dono1 = new Dono("João Silva", "12345678901");
        Dono dono2 = new Dono("Maria Lima", "98765432100");

        // Criando o Android
        Android meuAndroid = new Android("preto", "samsung", dono1, "Android 14");

        // Criando o Iphone
        Iphone meuIphone = new Iphone("branco", "apple", dono2, "iOS 17");

        System.out.println("=== Dados do Android ===");
        System.out.println("Cor: " + meuAndroid.getCor());
        System.out.println("Marca: " + meuAndroid.getMarca());
        System.out.println("Bateria: " + meuAndroid.getBateria() + "%");
        System.out.println("Dono: " + meuAndroid.getDono().getNome());
        System.out.println("Versão: " + meuAndroid.getVersaoAndroid());

        System.out.println("\n=== Dados do Iphone ===");
        System.out.println("Cor: " + meuIphone.getCor());
        System.out.println("Marca: " + meuIphone.getMarca());
        System.out.println("Bateria: " + meuIphone.getBateria() + "%");
        System.out.println("Dono: " + meuIphone.getDono().getNome());
        System.out.println("Versão: " + meuIphone.getVersaoIOS());

        System.out.println("\n=== Testando regras das subclasses ===");
        Android androidInvalido = new Android("azul", "motorola", dono1, "");   // inválido: versão vazia
        Iphone iphoneInvalido = new Iphone("preto", "apple", dono2, null);      // inválido: versão nula

        System.out.println("\n=== Testando métodos herdados ===");
        meuAndroid.usarBateria(30);       // herdado de Celular
        meuIphone.carregarBateria(50);    // herdado de Celular
    }
}