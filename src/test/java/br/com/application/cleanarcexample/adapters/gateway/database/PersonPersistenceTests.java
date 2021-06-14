package br.com.application.cleanarcexample.adapters.gateway.database;

import br.com.application.cleanarcexample.adapters.controllers.model.request.PersonRequestModel;
import br.com.application.cleanarcexample.adapters.gateway.database.entities.PersonData;
import br.com.application.cleanarcexample.adapters.gateway.database.repository.Personrepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


public class PersonPersistenceTests {

    private PersonPersistence personPersistence;
    private Personrepository personrepository;

    @BeforeEach
    public void init(){
        personrepository = mock(Personrepository.class);
        personPersistence = new PersonPersistence(personrepository);
    }

    @Test
    public void testDontExistsByName(){
        when(personrepository.existsByName(anyString())).thenReturn(false);
        boolean x = personPersistence.existsByName("Joao");
        assertEquals(false, x);
    }

    @Test
    public void testDoExistsByName(){
        when(personrepository.existsByName(anyString())).thenReturn(true);
        boolean x = personPersistence.existsByName("Joao");
        assertEquals(true, x);
    }

    @Test
    public void testSave(){
        PersonRequestModel personRequestModel = PersonRequestModel.builder()
                .name("Jose")
                .cpf("12345678947")
                .rg("1254784587")
                .idade(20)
                .build();

        PersonData data = new PersonData();
        data.setRg("1254785478");
        data.setAge(20);
        data.setCpf("12345678947");
        data.setName("Joao");
        data.setId(1);

        when(personrepository.save(any())).thenReturn(data);
        int id = personPersistence.save(personRequestModel);

    }

}
