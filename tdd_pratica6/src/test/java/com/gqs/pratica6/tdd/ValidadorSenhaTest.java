package com.gqs.pratica6.tdd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidadorSenhaTest {

    @Test
    void deveRetornarErroQuandoSenhaTiverMenosDeOitoCaracteres() {
        ValidadorSenha validador = new ValidadorSenha();
        ValidadorSenha.ResultadoValidacao resultado = validador.validar("Abc123!");
        assertFalse(resultado.isValida());
        assertTrue(resultado.getErros().contains(
                "A senha deve ter pelo menos 8 caracteres"));
    }

    @Test
    void naoDeveRetornarErroQuandoSenhaTiverOitoCaracteres() {
        ValidadorSenha validador = new ValidadorSenha();
        ValidadorSenha.ResultadoValidacao resultado = validador.validar("Abc123!x");
        assertFalse(resultado.getErros().contains(
                "A senha deve ter pelo menos 8 caracteres"));
    }

    @Test
    void deveRetornarErroQuandoSenhaTiverMenosDeDoisDigitos() {
        ValidadorSenha validador = new ValidadorSenha();
        ValidadorSenha.ResultadoValidacao resultado = validador.validar("Abcdef!g");
        assertFalse(resultado.isValida());
        assertTrue(resultado.getErros().contains(
                "A senha deve conter pelo menos 2 dígitos"));
    }
}