package br.com.application.cleanarcexample.domain.factory;

import br.com.application.cleanarcexample.domain.entities.Person;
import br.com.application.cleanarcexample.domain.factory.impl.CommonPersonFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class CommonPersonFactoryTests {

    @Test
    public void testCreatePersonOk() throws Exception {

        CommonPersonFactory commonPersonFactory = new CommonPersonFactory();
        Person person = commonPersonFactory.create("Chico", "35133524846","123456789", 30);

        assertSame("Chico", person.getName());
        assertSame("35133524846", person.getCpf());
        assertSame("123456789", person.getRg());
        assertSame(30, person.getAge());

    }

    @Test
    public void testCreatePersonNok() throws Exception {

        try {
            CommonPersonFactory commonPersonFactory = new CommonPersonFactory();
            Person person = commonPersonFactory.create("Chico", "12365487485", "123456789", 30);
        } catch (Exception e) {
            assertSame("Cpf is invalid, please verify this information", e.getMessage());
        }
    }


}
