public class Android extends Celular {
    private String versaoAndroid;

    // CONSTRUTOR
    public Android(String cor, String marca, Dono dono, String versaoAndroid) {
        super(cor, marca, dono);
        this.setVersaoAndroid(versaoAndroid);
    }

    // GETTER
    public String getVersaoAndroid() {
        return versaoAndroid;
    }

    // SETTER COM REGRA: versão não pode ser nula ou vazia
    public void setVersaoAndroid(String versaoAndroid) {
        if (versaoAndroid == null || versaoAndroid.isEmpty()) {
            System.out.println("Erro: versão do Android não pode ser vazia.");
        } else {
            this.versaoAndroid = versaoAndroid;
        }
    }

    @Override
    public String tipoDeConector() {
        return "USB-C";
    }

    @Override
    public String exibirInfo() {
        return "Android | Marca: " + getMarca() + " | Cor: " + getCor() +
                " | Bateria: " + getBateria() + "%" +
                " | Versão: " + versaoAndroid +
                " | Conector: " + tipoDeConector() +
                " | Dono: " + getDono().getNome();
    }
}