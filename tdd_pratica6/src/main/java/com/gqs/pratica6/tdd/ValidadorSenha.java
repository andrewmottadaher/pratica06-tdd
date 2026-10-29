
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
        List<String> erros = new ArrayList<>();

        return new ResultadoValidacao(erros.isEmpty(), erros);
    }
}