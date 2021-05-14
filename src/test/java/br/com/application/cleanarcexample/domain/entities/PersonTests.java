package br.com.application.cleanarcexample.domain.entities;

import br.com.application.cleanarcexample.domain.entities.impl.CommonPerson;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTests {

    @Test
    public void test(){

        Person person = new CommonPerson("Chico", "12345678910","123456789", 30);

        assertSame("Chico", person.getName());
        assertSame("12345678910", person.getCpf());
        assertSame("123456789", person.getRg());
        assertSame(30, person.getAge());

    }

    @Test
    public void testCpf() throws Exception{
        Person person = new CommonPerson();
        person.isCpfValid("12345678910");
        assertSame("12345678910", person.getCpf());
    }

}
