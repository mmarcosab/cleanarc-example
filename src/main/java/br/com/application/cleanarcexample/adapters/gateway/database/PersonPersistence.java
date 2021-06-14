package br.com.application.cleanarcexample.adapters.gateway.database;

import br.com.application.cleanarcexample.adapters.controllers.model.request.PersonRequestModel;
import br.com.application.cleanarcexample.adapters.gateway.PersonGateway;
import br.com.application.cleanarcexample.adapters.gateway.database.entities.PersonData;
import br.com.application.cleanarcexample.adapters.gateway.database.repository.Personrepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PersonPersistence implements PersonGateway {

    private final Personrepository personrepository;

    @Override
    public boolean existsByName(String name) {
        return personrepository.existsByName(name);
    }

    @Override
    public int save(PersonRequestModel requestModel) {

        PersonData personData = new PersonData();

        personData.setName(requestModel.getName());
        personData.setCpf(requestModel.getCpf());
        personData.setAge(requestModel.getIdade());
        personData.setRg(requestModel.getRg());

        personrepository.save(personData);

        return personData.getId();
    }
}
