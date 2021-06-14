package br.com.application.cleanarcexample.adapters.presenters.impl;

import br.com.application.cleanarcexample.adapters.controllers.model.response.PersonResponseModel;
import br.com.application.cleanarcexample.adapters.presenters.IPersonPresenter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public class PersonResponseFormatter implements IPersonPresenter {

    @Override
    public PersonResponseModel prepareSuccessView(PersonResponseModel response) {
        return response;
    }

    @Override
    public PersonResponseModel prepareFailView(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }
}
