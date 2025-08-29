enum Genero {
    ROCK("Rock"),
    FUNK("Funk"),
    ELETRONICA("Eletrônica");
    POP("Pop"),
    MPB("Música Popular Brasileira"),
    JAZZ("Jazz"),
    CLASSICA("Música Clássica");

    private final String descricao;

    Genero(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
