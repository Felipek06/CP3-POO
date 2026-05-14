public class Main {
    public static void main(String[] args) {

        Celular meuCelular = new Celular();
        meuCelular.cor = "preto";
        meuCelular.marca = "samsung";
        meuCelular.bateria = 100;

        System.out.println("Cor: " + meuCelular.cor);
        System.out.println("Marca: " + meuCelular.marca);
        System.out.println("Bateria inicial: " + meuCelular.bateria + "%");
    }
}