package br.com.application.cleanarcexample.adapters.controllers;

import br.com.application.cleanarcexample.adapters.controllers.model.request.PersonRequestModel;
import br.com.application.cleanarcexample.adapters.controllers.model.response.PersonResponseModel;
import br.com.application.cleanarcexample.domain.usecases.InputPersonUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class PersonControllerTests {

    private PersonController personController;
    private InputPersonUseCase personUseCase;

    @BeforeEach
    public void init(){
        personUseCase = mock(InputPersonUseCase.class);
        personController = new PersonController(personUseCase);
    }

    @Test
    public void testCreatePersonOK(){
        PersonRequestModel personRequestModel = PersonRequestModel.builder()
                .name("Jose")
                .cpf("64518468058")
                .rg("1254784587")
                .idade(20)
                .build();
        PersonResponseModel personResponseModel = PersonResponseModel.builder()
                .name("Jose")
                .cpf("64518468058")
                .rg("1254784587")
                .codigo(1)
                .idade(20)
                .build();

        when(personUseCase.create(any())).thenReturn(personResponseModel);

        ResponseEntity response = personController.create(personRequestModel);
        PersonResponseModel responseBody = (PersonResponseModel) response.getBody();

        assertTrue(response != null);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Jose", responseBody.getName());
        assertEquals("64518468058", responseBody.getCpf());
        assertEquals("1254784587", responseBody.getRg());
        assertEquals(1, responseBody.getCodigo());
        assertEquals(20, responseBody.getIdade());

    }

    @Test
    public void testCreatePersonNOK(){
        PersonRequestModel personRequestModel = PersonRequestModel.builder()
                .name("Jose")
                .cpf("12345678947")
                .rg("1254784587")
                .idade(20)
                .build();
        doThrow(new ResponseStatusException(HttpStatus.CONFLICT, "Cpf is invalid, please verify this information")).when(personUseCase).create(any());
        ResponseEntity response = personController.create(personRequestModel);
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertEquals(409, response.getStatusCodeValue());
    }

}
