package br.com.application.cleanarcexample.domain.usecases;

import br.com.application.cleanarcexample.adapters.presenters.model.PersonRequestModel;
import br.com.application.cleanarcexample.adapters.presenters.model.PersonResponseModel;

public interface PersonInputBoundary {
    PersonResponseModel create(PersonRequestModel requestModel) throws Exception;
}
