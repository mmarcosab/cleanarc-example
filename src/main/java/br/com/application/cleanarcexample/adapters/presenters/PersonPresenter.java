package br.com.application.cleanarcexample.adapters.presenters;

import br.com.application.cleanarcexample.adapters.presenters.model.PersonResponseModel;

public interface PersonPresenter {
    PersonResponseModel prepareSuccessView(PersonResponseModel person);
    PersonResponseModel prepareFailView(String error);
}
