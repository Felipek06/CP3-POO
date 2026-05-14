public class Iphone extends Celular {
    private String versaoIOS;

    // CONSTRUTOR
    public Iphone(String cor, String marca, Dono dono, String versaoIOS) {
        super(cor, marca, dono);
        this.setVersaoIOS(versaoIOS);
    }

    // GETTER
    public String getVersaoIOS() {
        return versaoIOS;
    }

    // SETTER COM REGRA: versão não pode ser nula ou vazia
    public void setVersaoIOS(String versaoIOS) {
        if (versaoIOS == null || versaoIOS.isEmpty()) {
            System.out.println("Erro: versão do iOS não pode ser vazia.");
        } else {
            this.versaoIOS = versaoIOS;
        }
    }
}