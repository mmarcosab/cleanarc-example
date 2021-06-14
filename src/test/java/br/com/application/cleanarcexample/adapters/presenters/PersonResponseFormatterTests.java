package br.com.application.cleanarcexample.adapters.presenters;

import br.com.application.cleanarcexample.adapters.controllers.model.response.PersonResponseModel;
import br.com.application.cleanarcexample.adapters.presenters.impl.PersonResponseFormatter;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import static org.junit.jupiter.api.Assertions.*;

public class PersonResponseFormatterTests {

    private PersonResponseFormatter formatter = new PersonResponseFormatter();

    @Test
    public void testPrepareSuccessView(){
        PersonResponseModel responseModel = PersonResponseModel.builder()
                .codigo(1)
                .cpf("12345678944")
                .idade(20)
                .rg("1245789652")
                .name("Joaquim")
                .build();
        PersonResponseModel p = formatter.prepareSuccessView(responseModel);
        assertEquals(1, p.getCodigo());
        assertEquals("12345678944", p.getCpf());
        assertEquals("1245789652", p.getRg());
        assertEquals(20, p.getIdade());
        assertEquals("Joaquim", p.getName());
    }

    @Test
    public void testPrepareFailView(){
        try {
            formatter.prepareFailView("Cpf is invalid, please verify this information");
        } catch (ResponseStatusException e) {
            assertEquals(HttpStatus.CONFLICT, e.getStatus());
            assertEquals(409, e.getRawStatusCode());
        }
    }

}
