package br.com.application.cleanarcexample.domain.entities;


public interface Person {
    String getName();
    String getCpf();
    String getRg();
    int getAge();
    void isCpfValid(String cpf) throws Exception;
}
