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

    @Test
    void naoDeveRetornarErroQuandoSenhaTiverDoisDigitos() {
        ValidadorSenha validador = new ValidadorSenha();
        ValidadorSenha.ResultadoValidacao resultado = validador.validar("Abcdef12");
        assertFalse(resultado.getErros().contains(
                "A senha deve conter pelo menos 2 dígitos"));
    }

    @Test
    void deveRetornarErroQuandoSenhaNaoTiverLetraMaiuscula() {
        ValidadorSenha validador = new ValidadorSenha();
        ValidadorSenha.ResultadoValidacao resultado = validador.validar("abcdef12");
        assertFalse(resultado.isValida());
        assertTrue(resultado.getErros().contains("A senha deve conter pelo menos uma letra maiuscula"));
    }

    @Test
    void naoDeveRetornarErroQuandoSenhaTiverUmaLetraMaiuscula() {
        ValidadorSenha validador = new ValidadorSenha();
        ValidadorSenha.ResultadoValidacao resultado = validador.validar("Abcdef12");
        assertFalse(resultado.getErros().contains("A senha deve conter pelo menos uma letra maiuscula"));
    }

    @Test
    void deveRetornarErroQuandoSenhaNaoTiverCaractereEspecial() {
        ValidadorSenha validador = new ValidadorSenha();
        ValidadorSenha.ResultadoValidacao resultado = validador.validar("Abcdef12");
        assertFalse(resultado.isValida());
        assertTrue(resultado.getErros().contains("A senha deve conter pelo menos um caractere especial"));
    }

    @Test
    void naoDeveRetornarErroQuandoSenhaTiverCaractereEspecial() {
        ValidadorSenha validador = new ValidadorSenha();
        ValidadorSenha.ResultadoValidacao resultado = validador.validar("Abcdef1!");
        assertFalse(resultado.getErros().contains("A senha deve conter pelo menos um caractere especial"));
    }

    @Test
    void deveRetornarTodosOsErrosQuandoSenhaNaoAtenderAosRequisitos() {
        ValidadorSenha validador = new ValidadorSenha();
        ValidadorSenha.ResultadoValidacao resultado = validador.validar("mypass");
        assertFalse(resultado.isValida());
        assertEquals(4, resultado.getErros().size());
        assertTrue(resultado.getErros().contains("A senha deve ter pelo menos 8 caracteres"));
        assertTrue(resultado.getErros().contains("A senha deve conter pelo menos 2 dígitos"));
        assertTrue(resultado.getErros().contains("A senha deve conter pelo menos uma letra maiuscula"));
        assertTrue(resultado.getErros().contains("A senha deve conter pelo menos um caractere especial"));
    }

    @Test
    void deveConsiderarValidaSenhaQueAtendeTodosOsRequisitos() {
        ValidadorSenha validador = new ValidadorSenha();
        ValidadorSenha.ResultadoValidacao resultado = validador.validar("Abcdef12!");
        assertTrue(resultado.isValida());
        assertTrue(resultado.getErros().isEmpty());
    }
}