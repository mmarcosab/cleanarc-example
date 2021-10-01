package br.com.application.cleanarcexample.domain.entities.impl;


//Essa classe é um value object
public class Cpf {

    private String numero;

    public Cpf(String numero) throws Exception {
        isCpfValid(numero);
        this.numero = numero;
    }

    public String getNumero(){
        return numero;
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

        int digito1 = (11 - total%11) < 2 ? 0: 11 - total%11;

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

        int digito2 = (11 - total%11) < 2 ? 0: 11 - total%11;

        if(!String.valueOf(digito1).equals(cpf.substring(9,10)) && !String.valueOf(digito2).equals(cpf.substring(10,11))){
            throw new Exception("Cpf is invalid, please verify this information");
        }

    }


}
