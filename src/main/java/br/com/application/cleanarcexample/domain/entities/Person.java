package br.com.application.cleanarcexample.domain.entities;

//here we define the business rules
public interface Person {
    String getName();
    String getCpf();
    String getRg();
    int getAge();
    void isCpfValid(String cpf) throws Exception;
}
