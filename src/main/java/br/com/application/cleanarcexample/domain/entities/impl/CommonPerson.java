package br.com.application.cleanarcexample.domain.entities.impl;

import br.com.application.cleanarcexample.domain.entities.Person;

import java.util.InputMismatchException;

public class CommonPerson implements Person {

    private String name;
    private String cpf;
    private String rg;
    private int age;

    public CommonPerson() {
    }

    public CommonPerson(String name, String cpf, String rg, int age) {
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name.isEmpty() || name.isBlank() || name == null) {
            throw new Exception("The name can not be null");
        } else {
            this.name = name;
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws Exception {
        if (cpf.isEmpty() || cpf.isBlank() || cpf == null) {
            throw new Exception("The cpf can not be null");
        } else {
            isCpfValid(cpf);
            this.cpf = cpf;
        }
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) throws Exception {
        if (rg.isEmpty() || rg.isBlank() || rg == null) {
            throw new Exception("The rg can not be null");
        } else {
            this.rg = rg;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {
        if (age == 0) {
            throw new Exception("The age can not be null");
        } else {
            this.age = age;
        }
    }

    public void isCpfValid(String cpf) throws Exception {

        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (cpf.equals("00000000000") ||
                cpf.equals("11111111111") ||
                cpf.equals("22222222222") || cpf.equals("33333333333") ||
                cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") ||
                cpf.equals("88888888888") || cpf.equals("99999999999") ||
                (cpf.length() != 11)) {
            throw new Exception("CPF is invelid, please verify this information");
        }

        int sm, i, r, num, peso;
        char dig10, dig11;
        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char) (r + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char) (r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            if (!(dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
                throw new Exception("CPF is invalid, verify tha last characters");

        } catch (InputMismatchException erro) {
            throw new Exception("Erro ao validar cpf: " + erro);
        }
    }


}
