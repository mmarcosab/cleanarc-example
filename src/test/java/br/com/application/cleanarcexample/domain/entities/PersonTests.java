package br.com.application.cleanarcexample.domain.entities;

import br.com.application.cleanarcexample.domain.entities.impl.CommonPerson;
import br.com.application.cleanarcexample.domain.entities.impl.Cpf;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTests {

    @Test
    public void test() throws Exception {

        Person person = new CommonPerson("Chico", "35133524846","123456789", 30);

        assertSame("Chico", person.getName());
        assertSame("35133524846", person.getCpf());
        assertSame("123456789", person.getRg());
        assertSame(30, person.getAge());

    }

    @Test
    public void testInvalidCpf() throws Exception{
        try {
            Person person = new CommonPerson("Chico", "12345678910","123456789", 30);
        } catch (Exception e){
            assertSame("Cpf is invalid, please verify this information", e.getMessage());
        }
    }

    @Test
    public void testValidCpf() throws Exception{
        Person person = new CommonPerson("Chico", "35133524846","123456789", 30);
    }

    @Test
    public void testSetEmptyName() throws Exception{
        Person person = new CommonPerson();
        try {
            ((CommonPerson) person).setName("");
        } catch (Exception e){
            assertSame("The name can not be blank or empty", e.getMessage());
        }
    }

    @Test
    public void testSetBlankName() throws Exception{
        Person person = new CommonPerson();
        try {
            ((CommonPerson) person).setName("   ");
        } catch (Exception e){
            assertSame("The name can not be blank or empty", e.getMessage());
        }
    }


    @Test
    public void testSetName() throws Exception{
        Person person = new CommonPerson();
        ((CommonPerson) person).setName("Chico");
        assertSame("Chico", person.getName());
    }

    @Test
    public void testSetEmptyCpf() throws Exception{
        Person person = new CommonPerson();
        try {
            ((CommonPerson) person).setCpf("");
        } catch (Exception e){
            assertSame("The cpf can not be blank or empty", e.getMessage());
        }
    }

    @Test
    public void testSetBlankCpf() throws Exception{
        Person person = new CommonPerson();
        try {
            ((CommonPerson) person).setCpf("   ");
        } catch (Exception e){
            assertSame("The cpf can not be blank or empty", e.getMessage());
        }
    }


    @Test
    public void testSetCpf() throws Exception{
        Person person = new CommonPerson();
        ((CommonPerson) person).setCpf("07799679093");
        assertSame("07799679093", person.getCpf());
    }

    @Test
    public void testSetEmptyRg() throws Exception{
        Person person = new CommonPerson();
        try {
            ((CommonPerson) person).setRg("");
        } catch (Exception e){
            assertSame("The rg can not be blank or empty", e.getMessage());
        }
    }

    @Test
    public void testSetBlankRg() throws Exception{
        Person person = new CommonPerson();
        try {
            ((CommonPerson) person).setRg("   ");
        } catch (Exception e){
            assertSame("The rg can not be blank or empty", e.getMessage());
        }
    }


    @Test
    public void testSetRg() throws Exception{
        Person person = new CommonPerson();
        ((CommonPerson) person).setRg("123456789");
        assertSame("123456789", person.getRg());
    }


    @Test
    public void testSetInvalidAge() throws Exception{
        Person person = new CommonPerson();
        try {
            ((CommonPerson) person).setAge(0);
        } catch (Exception e){
            assertSame("The age must be informed", e.getMessage());
        }
    }


    @Test
    public void testSetValidAge() throws Exception{
        Person person = new CommonPerson();
        ((CommonPerson) person).setAge(25);
        assertSame(25, person.getAge());
    }


    @Test
    public void testCadastroTelefoneComSucesso() throws Exception {
        Person person = new CommonPerson("Jose", "64842282053", "1236547814", 25);
        assertDoesNotThrow(() -> person.adicionarTelefone("011", "123456587"));
    }

    @Test
    public void testCadastroTelefoneComFalha() throws Exception {
        Person person = new CommonPerson("Jose", "64842282053", "1236547814", 25);
        person.adicionarTelefone("011", "123456587");
        person.adicionarTelefone("011", "123456587");
        assertThrows(Exception.class, () -> person.adicionarTelefone("011", "123456587"));
    }

}
