package br.ufms.emprestimojogos.domain.model;

import br.ufms.emprestimojogos.domain.util.Validador;

import java.time.LocalDate;
import java.util.UUID;

public class Usuario {
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private final UUID id;
    private LocalDate dataNascimento;
    private LocalDate dataCadastro;
    private Status status;
    private String cpf;

    public Usuario(String nome, String email, String telefone, LocalDate dataNascimento) {
        Validador.nomePessoa(nome);
        Validador.validarEmail(email);
        Validador.validarTelefone(telefone);

        this.nome = nome.trim();
        this.email = email.trim();
        this.telefone = telefone.trim();
        this.dataNascimento = dataNascimento;
        this.status = Status.ATIVO;
        this.id = UUID.randomUUID();
        this.dataCadastro = LocalDate.now();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        Validador.nomePessoa(nome);
        this.nome = nome.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Validador.validarEmail(email);
        this.email = email.trim();
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        if (dataNascimento == null || dataNascimento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento inválida");
        }
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
        Validador.validarTelefone(telefone);
        this.telefone = telefone.trim();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha == null || senha.isBlank() || senha.length() < 6) {
            throw new IllegalArgumentException("A senha deve ter no mínimo 6 caracteres");
        }
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        Validador.validarCpf(cpf);
        this.cpf = cpf.replaceAll("\\D", "");
    }
}