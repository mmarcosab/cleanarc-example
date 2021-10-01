package br.com.application.cleanarcexample.domain;

public abstract class Ouvinte {
    abstract boolean deveProcessar(Evento evento);
    abstract void reageAo(Evento evento);
}
