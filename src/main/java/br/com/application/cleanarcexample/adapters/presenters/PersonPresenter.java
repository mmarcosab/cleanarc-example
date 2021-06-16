package br.com.application.cleanarcexample.adapters.presenters;

import br.com.application.cleanarcexample.adapters.controllers.model.response.PersonResponseModel;

public interface PersonPresenter {
    PersonResponseModel prepareSuccessView(PersonResponseModel response);
    PersonResponseModel prepareFailView(String error);
}
