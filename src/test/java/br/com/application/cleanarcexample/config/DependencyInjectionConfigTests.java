package br.com.application.cleanarcexample.config;

import br.com.application.cleanarcexample.adapters.gateway.PersonGateway;
import br.com.application.cleanarcexample.adapters.gateway.database.repository.Personrepository;
import br.com.application.cleanarcexample.adapters.presenters.impl.PersonResponseFormatter;
import br.com.application.cleanarcexample.domain.factory.PersonFactory;
import br.com.application.cleanarcexample.domain.usecases.impl.CreatePersonUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class DependencyInjectionConfigTests {

    private DependencyInjectionConfig config;
    private PersonGateway personGateway;
    private PersonResponseFormatter personResponseFormatter;
    private PersonFactory personFactory;
    private Personrepository personRepository;

    @BeforeEach
    public void init() {
        personGateway = mock(PersonGateway.class);
        personResponseFormatter = mock(PersonResponseFormatter.class);
        personFactory = mock(PersonFactory.class);
        personRepository = mock(Personrepository.class);
        config = new DependencyInjectionConfig();
    }

    @Test
    public void testCreatePersonUseCase(){
        CreatePersonUseCase useCase = config.createPersonUseCase(personGateway, personResponseFormatter, personFactory);
        assertTrue(useCase != null);
    }

    @Test
    public void testCreatePersonFactory(){
        PersonFactory factory = config.createPersonFactory();
        assertTrue(factory != null);
    }

    @Test
    public void testCreatePersonResponseFormatter(){
        PersonResponseFormatter formatter = config.createPersonResponseFormatter();
        assertTrue(formatter != null);
    }

    @Test
    public void testCreatePersonGateway(){
        PersonGateway gateway = config.createPersonGateway(personRepository);
        assertTrue(gateway != null);
    }

}
