package br.com.application.cleanarcexample.domain.factory;


import br.com.application.cleanarcexample.domain.entities.Person;

public interface PersonFactory {
    Person create(String name, String cpf, String rg, int age);
}
