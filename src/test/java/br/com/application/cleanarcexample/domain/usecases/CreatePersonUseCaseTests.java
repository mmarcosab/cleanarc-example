package br.com.application.cleanarcexample.domain.usecases;

import br.com.application.cleanarcexample.adapters.controllers.model.request.PersonRequestModel;
import br.com.application.cleanarcexample.adapters.controllers.model.response.PersonResponseModel;
import br.com.application.cleanarcexample.adapters.gateway.PersonGateway;
import br.com.application.cleanarcexample.adapters.presenters.PersonPresenter;
import br.com.application.cleanarcexample.domain.entities.impl.CommonPerson;
import br.com.application.cleanarcexample.domain.factory.PersonFactory;
import br.com.application.cleanarcexample.domain.usecases.impl.UserRegisterInteractor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.mockito.Mockito.*;


public class CreatePersonUseCaseTests {

    private UserRegisterInteractor createPersonUseCase;
    private PersonGateway personGateway;
    private PersonPresenter personPresenter;
    private PersonFactory personFactory;

    @BeforeEach
    public void init(){
        personGateway = mock(PersonGateway.class);
        personPresenter = mock(PersonPresenter.class);
        personFactory = mock(PersonFactory.class);
        createPersonUseCase = new UserRegisterInteractor(personGateway, personPresenter, personFactory);
    }

    @Test
    public void testCreatePersonOK() throws Exception {
        PersonRequestModel personRequestModel = PersonRequestModel.builder()
                .name("Jose")
                .cpf("64518468058")
                .rg("1254784587")
                .idade(20)
                .build();
        CommonPerson person = new CommonPerson("Jose", "64518468058", "1254784587", 20);
        PersonResponseModel personResponseModel = PersonResponseModel.builder()
                .name("Jose")
                .cpf("64518468058")
                .rg("1254784587")
                .codigo(1)
                .idade(20)
                .build();
        when(personFactory.create(anyString(), anyString(), anyString(), anyInt())).thenReturn(person);
        when(personGateway.save(any())).thenReturn(1);
        when(personPresenter.prepareSuccessView(any())).thenReturn(personResponseModel);
        PersonResponseModel responseModel = createPersonUseCase.create(personRequestModel);
        Assertions.assertEquals(20, responseModel.getIdade());
    }

    @Test
    public void testCreatePersonNOK(){
        try {
            PersonRequestModel personRequestModel = PersonRequestModel.builder()
                    .name("Jose")
                    .cpf("12345678987")
                    .rg("1254784587")
                    .idade(20)
                    .build();
            createPersonUseCase.create(personRequestModel);
        }catch (ResponseStatusException e) {
            Assertions.assertEquals(HttpStatus.CONFLICT, e.getStatus());
        }
    }

    @Test
    public void testCreatePersonWhenPersonAlreadyExists(){
        try {
            PersonRequestModel personRequestModel = PersonRequestModel.builder()
                    .name("Jose")
                    .cpf("12345678987")
                    .rg("1254784587")
                    .idade(20)
                    .build();
            when(personGateway.existsByName(anyString())).thenReturn(true);
            createPersonUseCase.create(personRequestModel);
        }catch (ResponseStatusException e) {
            Assertions.assertEquals(HttpStatus.CONFLICT, e.getStatus());
        }
    }

}
