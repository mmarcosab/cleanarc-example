package br.com.application.cleanarcexample.adapters.gateways.model;

public class PersonDsRequestModel {
    private String name;
    private String cpf;
    private String rg;
    private int age;

    public PersonDsRequestModel() {
    }

    public PersonDsRequestModel(String name, String cpf, String rg, int age) {
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
