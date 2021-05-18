package br.com.application.cleanarcexample.domain.usecases.impl;

import br.com.application.cleanarcexample.adapters.gateways.PersonRegisterDsGateway;
import br.com.application.cleanarcexample.adapters.gateways.model.PersonDsRequestModel;
import br.com.application.cleanarcexample.adapters.presenters.*;
import br.com.application.cleanarcexample.adapters.presenters.model.PersonRequestModel;
import br.com.application.cleanarcexample.adapters.presenters.model.PersonResponseModel;
import br.com.application.cleanarcexample.domain.entities.Person;
import br.com.application.cleanarcexample.domain.factory.PersonFactory;
import br.com.application.cleanarcexample.domain.usecases.PersonInputBoundary;

import java.time.LocalDateTime;

public class PersonRegisterUseCase implements PersonInputBoundary {

    private final PersonRegisterDsGateway personDsGateway;
    private final PersonPresenter personPresenter;
    private final PersonFactory personFactory;

    public PersonRegisterUseCase(PersonRegisterDsGateway personDsGateway, PersonPresenter personPresenter, PersonFactory personFactory) {
        this.personDsGateway = personDsGateway;
        this.personPresenter = personPresenter;
        this.personFactory = personFactory;
    }

    @Override
    public PersonResponseModel create(PersonRequestModel requestModel) throws Exception {
        if (personDsGateway.existsByName(requestModel.getName())) {
            return personPresenter.prepareFailView("Person already exists.");
        }
        Person person = personFactory.create(requestModel.getName(), requestModel.getCpf(), requestModel.getRg(), requestModel.getAge());
        //TODO pegar a excecao
        LocalDateTime now = LocalDateTime.now();
        PersonDsRequestModel personDsModel = new PersonDsRequestModel(requestModel.getName(), requestModel.getCpf(), requestModel.getRg(), requestModel.getAge());

        personDsGateway.save(personDsModel);

        PersonResponseModel accountResponseModel = new PersonResponseModel(person.getName(),person.getCpf(), person.getRg(), person.getAge());
        return personPresenter.prepareSuccessView(accountResponseModel);
    }



}
