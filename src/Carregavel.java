public interface Carregavel {
    int CARGA_MINIMA = 0;    // constante nova
    int CARGA_MAXIMA = 100;  // constante nova

    void carregar(int quantidade);
    int getNivelCarga();
}