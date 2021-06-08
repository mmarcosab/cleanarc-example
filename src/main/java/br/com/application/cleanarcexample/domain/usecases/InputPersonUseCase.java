package br.com.application.cleanarcexample.domain.usecases;

import br.com.application.cleanarcexample.adapters.controllers.model.request.PersonRequestModel;
import br.com.application.cleanarcexample.adapters.controllers.model.response.PersonResponseModel;


public interface InputPersonUseCase {
    PersonResponseModel create(PersonRequestModel requestModel) throws Exception;
}