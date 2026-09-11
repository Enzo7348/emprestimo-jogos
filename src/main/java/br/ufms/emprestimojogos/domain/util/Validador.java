package br.ufms.emprestimojogos.domain.util;

public class Validador {
    // validador nome
    public static void nomePessoa(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser vazio");
        }
        nome = nome.trim();
        String regex = "[a-zA-ZÀ-ÿ]+(\\s+[a-zA-ZÀ-ÿ]+)+";

        if (!nome.matches(regex) || nome.length() > 255) {
            throw new IllegalArgumentException("Nome inválido. Digite o nome completo (até 255 caracteres).");
        }
    }

    // validador telefone
    public static void validarTelefone(String telefone) {
        if (telefone == null || telefone.isBlank()) {
            throw new IllegalArgumentException("O telefone está vazio");
        }
        telefone = telefone.trim();
        String regex = "\\d{2}9\\d{8}";

        if (!telefone.matches(regex)) {
            throw new IllegalArgumentException("O telefone deve ter entre 2 e 9");
        }
    }

    // validador email
    public static void validarEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("O email esta vazio");
        }

        email = email.trim();
        String regex = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        if (!email.matches(regex)) {
            throw new IllegalArgumentException("Email invalido");
        }
    }

    // validador cpf
    public static void validarCpf(String cpf) {
        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("O cpf invalido");
        }

        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            throw new IllegalArgumentException("O cpf invalido");
        }

        int soma = 0;

        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }

        int resto = soma % 11;
        int digito1 = 0;
        int digito2 = 0;

        if (resto < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - resto;
        }
        if (Character.getNumericValue(cpf.charAt(9)) != digito1) {
            throw new IllegalArgumentException("O cpf invalido");
        }

        soma = 0;

        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }

        resto = 0;
        resto = soma % 11;

        if (resto < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - resto;
        }

        if (Character.getNumericValue(cpf.charAt(10)) != digito2) {
            throw new IllegalArgumentException("O cpf invalido");
        }

    }
    // validador data (formato dd/MM/yyyy)
    public static void validarData(String data) {
        if (data == null || data.isBlank()) {
            throw new IllegalArgumentException("A data não pode ser vazia");
        }

        data = data.trim();
        String regex = "(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/\\d{4}";

        if (!data.matches(regex)) {
            throw new IllegalArgumentException("Data inválida. Use o formato dd/MM/yyyy");
        }
    }

}
