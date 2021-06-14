package br.com.application.cleanarcexample.adapters.gateway;

import br.com.application.cleanarcexample.adapters.controllers.model.request.PersonRequestModel;

public interface PersonGateway {
    boolean existsByName(String name);
    int save(PersonRequestModel requestModel);
}
