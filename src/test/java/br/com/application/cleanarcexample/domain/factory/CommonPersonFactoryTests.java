package br.com.application.cleanarcexample.domain.factory;

import br.com.application.cleanarcexample.domain.entities.Person;
import br.com.application.cleanarcexample.domain.factory.impl.CommonPersonFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class CommonPersonFactoryTests {

    @Test
    public void test(){

        CommonPersonFactory commonPersonFactory = new CommonPersonFactory();
        Person person = commonPersonFactory.create("Chico", "12345678910","123456789", 30);

        assertSame("Chico", person.getName());
        assertSame("12345678910", person.getCpf());
        assertSame("123456789", person.getRg());
        assertSame(30, person.getAge());

    }


}
