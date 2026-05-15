public class Iphone extends Celular implements Carregavel {
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

    // INTERFACE Carregavel
    @Override
    public void carregar(int quantidade) {
        carregarBateria(quantidade);
    }

    @Override
    public int getNivelCarga() {
        return getBateria();
    }

    @Override
    public String tipoDeConector() {
        return "Lightning";
    }

    @Override
    public String exibirInfo() {
        return "iPhone | Marca: " + getMarca() + " | Cor: " + getCor() +
               " | Bateria: " + getBateria() + "%" +
               " | Versão: " + versaoIOS +
               " | Conector: " + tipoDeConector() +
               " | Dono: " + getDono().getNome();
    }
}