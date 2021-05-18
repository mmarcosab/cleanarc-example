//package br.com.application.cleanarcexample.domain.usecase;
//
//import br.com.application.cleanarcexample.adapters.gateways.PersonRegisterDsGateway;
//import br.com.application.cleanarcexample.adapters.gateways.model.PersonDsRequestModel;
//import br.com.application.cleanarcexample.adapters.presenters.PersonPresenter;
//import br.com.application.cleanarcexample.adapters.presenters.model.PersonRequestModel;
//import br.com.application.cleanarcexample.adapters.presenters.model.PersonResponseModel;
//import br.com.application.cleanarcexample.domain.factory.PersonFactory;
//import br.com.application.cleanarcexample.domain.usecases.impl.PersonRegisterUseCase;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//import static org.mockito.Mockito.*;
//
//public class PersonRegisterUseCaseTests {
//
//    @InjectMocks
//    private PersonRegisterUseCase useCase;
//    @Mock
//    private PersonRegisterDsGateway personDsGateway;
//    @Mock
//    private PersonPresenter personPresenter;
//    @Mock
//    private PersonFactory personFactory;
//
//    @BeforeEach
//    public void init(){
//
//    }
//
//    @Test
//    void givenPerson_whenCreate_thenSaveItAndPrepareSuccessView() {
//
//        given(personDsGateway.existsByName("Chico"))
//                .willReturn(true);
//
//        useCase.create(new PersonRequestModel("Chico", "12345678910", "123456789", 30));
//
//        then(personDsGateway).should()
//                .save(new PersonDsRequestModel("Chico", "12345678910", "123456789", 30));
//        then(PersonPresenter).should()
//                .prepareSuccessView(new PersonResponseModel("Chico", "12345678910", "123456789", 30));
//    }
//
//}
