package br.com.application.cleanarcexample.domain.usecases.impl;

import br.com.application.cleanarcexample.adapters.controllers.model.request.PersonRequestModel;
import br.com.application.cleanarcexample.adapters.controllers.model.response.PersonResponseModel;
import br.com.application.cleanarcexample.adapters.gateway.PersonGateway;
import br.com.application.cleanarcexample.adapters.presenters.IPersonPresenter;
import br.com.application.cleanarcexample.domain.entities.Person;
import br.com.application.cleanarcexample.domain.factory.PersonFactory;
import br.com.application.cleanarcexample.domain.usecases.ICreatePersonUseCase;

public class CreatePersonUseCase implements ICreatePersonUseCase {

    private final PersonGateway personGateway;
    private final IPersonPresenter personPresenter;
    private final PersonFactory personFactory;

    public CreatePersonUseCase(PersonGateway personGateway, IPersonPresenter personPresenter, PersonFactory personFactory) {
        this.personGateway = personGateway;
        this.personPresenter = personPresenter;
        this.personFactory = personFactory;
    }

    @Override
    public PersonResponseModel create(PersonRequestModel requestModel) {
        Person person = null;
        int id = 0;
        PersonResponseModel personResponseModel = null;
        try {
            if(personGateway.existsByName(requestModel.getName())){
                personPresenter.prepareFailView("Person already exists");
            }
            person = personFactory.create(requestModel.getName(), requestModel.getCpf(), requestModel.getRg(), requestModel.getIdade());
            id = personGateway.save(requestModel);
            personResponseModel = PersonResponseModel.builder()
                    .codigo(id)
                    .name(person.getName())
                    .cpf(person.getCpf())
                    .rg(person.getRg())
                    .idade(person.getAge())
                    .build();
        }catch (Exception e) {
            return personPresenter.prepareFailView(e.getMessage());
        }
        return personPresenter.prepareSuccessView(personResponseModel);
    }

}