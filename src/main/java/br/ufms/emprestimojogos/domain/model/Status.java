package br.ufms.emprestimojogos.domain.model;

public enum Status {
    ATIVO ( "Ativo"),
    INATIVO("Inativo"),
    BLOQUEADO("Bloqueado");

    Status(String descricao){
        this.descricao = descricao;

    }
    private final String descricao;

    public String getDescricao() {
        return descricao;
    }

}
