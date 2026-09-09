package br.ufms.emprestimojogos.model;
import java.time.LocalDate;
import java.util.UUID;

public class Usuario {
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private UUID id;
    private LocalDate dataNascimento;
    private LocalDate dataCadastro;
    private Status status;
    private String cpf;

    public Usuario(String nome, String email, String telefone, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.status = Status.ATIVO;
        this.id = UUID.randomUUID();
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public UUID getId() {
        return id;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
