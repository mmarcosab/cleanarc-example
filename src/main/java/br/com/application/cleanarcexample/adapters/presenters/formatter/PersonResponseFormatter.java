package br.com.application.cleanarcexample.adapters.presenters.formatter;

import br.com.application.cleanarcexample.adapters.presenters.PersonPresenter;
import br.com.application.cleanarcexample.adapters.presenters.model.PersonResponseModel;

public class PersonResponseFormatter implements PersonPresenter {

    @Override
    public PersonResponseModel prepareSuccessView(PersonResponseModel person) {
        //TODO
        return null;
    }

    @Override
    public PersonResponseModel prepareFailView(String error) {
        //TODO
        return null;
    }
}
