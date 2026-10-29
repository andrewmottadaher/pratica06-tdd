package com.gqs.pratica6.tdd;

import java.util.ArrayList;
import java.util.List;

public class ValidadorSenha {

    public static class ResultadoValidacao {
        private final boolean valida;
        private final List<String> erros;

        public ResultadoValidacao(boolean valida, List<String> erros) {
            this.valida = valida;
            this.erros = erros;
        }
        public boolean isValida() {
            return valida;
        }
        public List<String> getErros() {
            return erros;
        }
    }

    public ResultadoValidacao validar(String senha) {
        // O List<String> armazena todas as mensagens de erro encontradas durante as validacoes da senha.
        List<String> erros = new ArrayList<>();
        if (senha.length() < 8) {
            erros.add("A senha deve ter pelo menos 8 caracteres");
        }
        // Conta quantos digitos numericos existem na senha utilizando Streams do Java.
        long quantidadeDigitos = senha.chars().filter(Character::isDigit).count();
        if (quantidadeDigitos < 2) {
            erros.add("A senha deve conter pelo menos 2 dígitos");
        }
        // Este metodo percorre todo os caracteres e retorna true assim que localiza a letra maiuscula.
        boolean possuiMaiuscula = senha.chars().anyMatch(Character::isUpperCase);
        if (!possuiMaiuscula) {
            erros.add("A senha deve conter pelo menos uma letra maiuscula");
        }
        // Este metodo percorre todo os caracteres e verifica se existe pelo menos um caractere que nao seja letra ou digito (simbolo especial).
        boolean possuiCaractereEspecial = senha.chars().anyMatch(c -> !Character.isLetterOrDigit(c));
        if (!possuiCaractereEspecial) {
            erros.add("A senha deve conter pelo menos um caractere especial");
        }
        return new ResultadoValidacao(erros.isEmpty(), erros);
    }
}