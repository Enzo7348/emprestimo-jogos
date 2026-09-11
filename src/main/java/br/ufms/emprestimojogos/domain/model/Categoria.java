package br.ufms.emprestimojogos.domain.model;
import java.util.UUID;

public class Categoria {
    private UUID id;
    private String nome;
    private String descricao;

    public Categoria(String nome, String descricao, UUID id) {
        this.nome = nome;
        this.descricao = descricao;
        this.id = UUID.randomUUID();
    }
    public Categoria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

