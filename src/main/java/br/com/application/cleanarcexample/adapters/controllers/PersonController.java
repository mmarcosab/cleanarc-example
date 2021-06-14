package br.com.application.cleanarcexample.adapters.controllers;

import br.com.application.cleanarcexample.adapters.controllers.model.request.PersonRequestModel;
import br.com.application.cleanarcexample.domain.usecases.ICreatePersonUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@Slf4j
@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final ICreatePersonUseCase personUseCase;

    @PostMapping
    public ResponseEntity create(@RequestBody PersonRequestModel personRequestModel){
        try {
            log.info("Requisicao recebida: {}", personRequestModel);
            return ResponseEntity.ok().body(personUseCase.create(personRequestModel));
        } catch (ResponseStatusException e){
            log.error("Houve um erro ao processar a requisicao: {}", e.getMessage());
            return ResponseEntity.status(e.getRawStatusCode()).body(e.getMessage());
        }
    }
}
