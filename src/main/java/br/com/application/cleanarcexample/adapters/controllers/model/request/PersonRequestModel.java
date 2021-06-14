package br.com.application.cleanarcexample.adapters.controllers.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PersonRequestModel {

    @JsonProperty("name")
    private String name;

    @JsonProperty("rg")
    private String rg;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("idade")
    private int idade;

}
