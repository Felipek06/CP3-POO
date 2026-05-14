public class Dono {
    private String nome;
    private String cpf;

    // CONSTRUTOR
    public Dono(String nome, String cpf) {
        this.setNome(nome);
        this.setCpf(cpf);
    }

    // GETTERS
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    // SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }

    // REGRA ESPECIAL: CPF deve ter exatamente 11 dígitos
    public void setCpf(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            System.out.println("Erro: CPF inválido. Deve conter exatamente 11 dígitos. Valor ignorado: " + cpf);
        } else {
            this.cpf = cpf;
        }
    }
}