package br.com.application.cleanarcexample.domain.entities.impl;

import br.com.application.cleanarcexample.domain.entities.Person;

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
        if (name.isEmpty() || name.isBlank()) {
            throw new Exception("The name can not be blank or empty");
        } else {
            this.name = name;
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws Exception {
        if (cpf.isEmpty() || cpf.isBlank()) {
            throw new Exception("The cpf can not be blank or empty");
        } else {
            isCpfValid(cpf);
            this.cpf = cpf;
        }
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) throws Exception {
        if (rg.isEmpty() || rg.isBlank()) {
            throw new Exception("The rg can not be blank or empty");
        } else {
            this.rg = rg;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {
        if (age == 0) {
            throw new Exception("The age must be informed");
        } else {
            this.age = age;
        }
    }

    public void isCpfValid(String cpf) throws Exception {

        int total = 0;

        total += Integer.valueOf(cpf.substring(0, 1)) * 10;
        total += Integer.valueOf(cpf.substring(1, 2)) * 9;
        total += Integer.valueOf(cpf.substring(2, 3)) * 8;
        total += Integer.valueOf(cpf.substring(3, 4)) * 7;
        total += Integer.valueOf(cpf.substring(4, 5)) * 6;
        total += Integer.valueOf(cpf.substring(5, 6)) * 5;
        total += Integer.valueOf(cpf.substring(6, 7)) * 4;
        total += Integer.valueOf(cpf.substring(7, 8)) * 3;
        total += Integer.valueOf(cpf.substring(8, 9)) * 2;

        //peguei o primeiro digito
        int digito1 = total%10;

        total = 0;

        total += Integer.valueOf(cpf.substring(0,1)) * 11;
        total += Integer.valueOf(cpf.substring(1,2)) * 10;
        total += Integer.valueOf(cpf.substring(2,3)) * 9;
        total += Integer.valueOf(cpf.substring(3,4)) * 8;
        total += Integer.valueOf(cpf.substring(4,5)) * 7;
        total += Integer.valueOf(cpf.substring(5,6)) * 6;
        total += Integer.valueOf(cpf.substring(6,7)) * 5;
        total += Integer.valueOf(cpf.substring(7,8)) * 4;
        total += Integer.valueOf(cpf.substring(8,9)) * 3;
        total += Integer.valueOf(cpf.substring(9,10)) * 2;

        int digito2 = total%11;

        if(!String.valueOf(digito1).equals(cpf.substring(9)) && String.valueOf(digito1).equals(cpf.substring(10))){
            throw new Exception("Cpf is invalid, please verify this information");
        }

    }


}
