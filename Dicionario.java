package com.arquitetura;

public class Dicionario {

    public String search(String[] instruction){
        String campo = instruction[0];
        String binaryResult = "0";
        
        /**
         * INSTRUÇÕES LOAD E STORE - TIPO I
         */
        if (campo.equals("lb")) {//32
            binaryResult = "100000";
            binaryResult += tipoI(instruction[3], instruction[1], instruction[2]);
        } else if(campo.equals("lh")) {//33
            binaryResult = "100001";
            binaryResult += tipoI(instruction[3], instruction[1], instruction[2]);
        } else if(campo.equals("lwl")) {//34 - voltar aqui depois
            binaryResult = "100010";
        } else if(campo.equals("lw")) {//35
            binaryResult = "100011";
            binaryResult += tipoI(instruction[3], instruction[1], instruction[2]);
        } else if(campo.equals("lbu")) {//36
            binaryResult = "100100";
            binaryResult += tipoI(instruction[3], instruction[1], instruction[2]);
        } else if(campo.equals("lhu")) {//37
            binaryResult = "100101";
            binaryResult += tipoI(instruction[3], instruction[1], instruction[2]);
        } else if(campo.equals("lwr")) {//38 - voltar aqui depois
            binaryResult = "100110";
        } else if(campo.equals("sb")) {//40
            binaryResult = "101000";
            binaryResult += tipoI(instruction[3], instruction[1], instruction[2]);
        } else if(campo.equals("sh")) {//41
            binaryResult = "101001";
            binaryResult += tipoI(instruction[3], instruction[1], instruction[2]);
        } else if(campo.equals("swl")) {//42 - voltar aqui depois
            binaryResult = "101010";
        } else if(campo.equals("sw")) {//43
            binaryResult = "101011";
            binaryResult += tipoI(instruction[3], instruction[1], instruction[2]);
        } else if(campo.equals("swr")) {//46 - voltar aqui depois
            binaryResult = "101110";
        }
        /**
         * INSTRUÇÕES LÓGICAS E ARITMÉTICAS - TIPO R
         */
        else if (campo.equals("add")) {
            binaryResult = "000000";
            binaryResult += tipoR(instruction[2], instruction[3], instruction[1], "00000", "100000");
        } 
        
        return binaryResult;
    }

    public String registrador(String reg) {
        String regBinary = "00000";
        if (reg.equals("$t0")) {
            regBinary = "01000";
        } else if (reg.equals("$t1")) {
            regBinary = "01001";
        } else if (reg.equals("$t2")) {
            regBinary = "01010";
        } else if (reg.equals("$t3")) {
            regBinary = "01011";
        } else if (reg.equals("$t4")) {
            regBinary = "01100";
        } else if (reg.equals("$t5")) {
            regBinary = "01101";
        } else if (reg.equals("$t6")) {
            regBinary = "01110";
        } else if (reg.equals("$t7")) {
            regBinary = "01111";
        } else if (reg.equals("$zero") || reg.equals("$r0")) {
            regBinary = "00000";
        } else if (reg.equals("$s0")) {
            regBinary = "10000";
        } else if (reg.equals("$s1")) {
            regBinary = "10001";
        } else if (reg.equals("$s2")) {
            regBinary = "10010";
        } else if (reg.equals("$s3")) {
            regBinary = "10011";
        } else if (reg.equals("$s4")) {
            regBinary = "10100";
        } else if (reg.equals("$s5")) {
            regBinary = "10110";
        } else if (reg.equals("$s6")) {
            regBinary = "10111";
        } else if (reg.equals("$s7")) {
            regBinary = "11000";
        }
        
        return regBinary;
    }

    public String tipoI(String rs, String rt, String immediate){
        String binary = "";
        binary += registrador(rt);
        binary += registrador(rs);
        binary += String.format("%1$"+16+"s",toBinary(immediate));
        return binary;
    }

    public String tipoR(String rs, String rt, String rd, String shamt, String funct){
        String binary = "";
        binary += registrador(rs);
        binary += registrador(rt);
        binary += registrador(rd);
        binary += shamt;
        binary += funct;
        return binary;
    }

    public String toBinary(String immediate){
        int aux = Integer.parseInt(immediate);
        immediate = String.format("%1$"+16+"s", Integer.toBinaryString(aux));
        while(immediate.contains(" ")){
            immediate = immediate.replace(" ", "0");
        }
        return immediate;
    }

}