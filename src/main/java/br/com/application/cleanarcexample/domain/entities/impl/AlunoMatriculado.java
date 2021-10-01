package br.com.application.cleanarcexample.domain.entities.impl;

import br.com.application.cleanarcexample.domain.Evento;

import java.time.LocalDateTime;

public class AlunoMatriculado implements Evento {

    private final Cpf cpf;
    private final LocalDateTime momento;

    public AlunoMatriculado(Cpf cpf) {
        this.cpf = cpf;
        this.momento = LocalDateTime.now();
    }

    @Override
    public LocalDateTime momento() {
        return null;
    }
}
