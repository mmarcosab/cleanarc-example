package br.com.application.cleanarcexample.adapters.gateways;

import br.com.application.cleanarcexample.adapters.gateways.model.PersonDsRequestModel;

public interface PersonRegisterDsGateway {
    boolean existsByName(String name);

    void save(PersonDsRequestModel requestModel);
}
