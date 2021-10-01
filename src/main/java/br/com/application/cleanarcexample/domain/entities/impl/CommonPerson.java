package br.com.application.cleanarcexample.domain.entities.impl;

import br.com.application.cleanarcexample.domain.entities.Person;

import java.util.ArrayList;
import java.util.List;

public class CommonPerson implements Person {

    private String name;
    private Cpf cpf;
    private String rg;
    private int age;
    private List<Telefone> telefones;


    public CommonPerson() {
    }

    public CommonPerson(String name, String cpf, String rg, int age) throws Exception {
        this.name = name;
        this.cpf = new Cpf(cpf);
        this.rg = rg;
        this.age = age;
        telefones = new ArrayList<>();
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
        return cpf.getNumero();
    }

    public void setCpf(String cpf) throws Exception {
        if (cpf.isEmpty() || cpf.isBlank()) {
            throw new Exception("The cpf can not be blank or empty");
        } else {
            this.cpf = new Cpf(cpf);
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

    public void adicionarTelefone(String ddd, String numero) throws Exception {
        if(telefones.size() >= 2){
            throw new Exception("Numero maximo de telefones permitido já atingido");
        }
        telefones.add(new Telefone(ddd, numero));
    }

}
