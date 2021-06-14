package br.com.application.cleanarcexample.adapters.controllers.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class PersonResponseModel {

    @JsonProperty("codigo")
    private int codigo;

    @JsonProperty("name")
    private String name;

    @JsonProperty("rg")
    private String rg;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("idade")
    private int idade;

}
