package br.com.application.cleanarcexample.domain.entities;


public interface Person {
    String getName();
    String getCpf();
    String getRg();
    int getAge();
    void adicionarTelefone(String ddd, String numero) throws Exception;
}
