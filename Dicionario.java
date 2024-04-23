package com.arquitetura;

public class Dicionario {

    public String search(String[] instruction){
        String campo = instruction[0];
        String opcode = "0";

        /**
         * INSTRUÇÕES LOAD E STORE - TIPO I
         */
        if (campo.equals("lb")) {//32
            opcode = "100000";
        } else if(campo.equals("lh")) {//33
            opcode = "100001";
        } else if(campo.equals("lwl")) {//34
            opcode = "100010";
        } else if(campo.equals("lw")) {//35
            opcode = "100011";
        } else if(campo.equals("lbu")) {//36
            opcode = "100100";
        } else if(campo.equals("lhu")) {//37
            opcode = "100101";
        } else if(campo.equals("lwr")) {//38
            opcode = "100110";
        } else if(campo.equals("sb")) {//40
            opcode = "101000";
        } else if(campo.equals("sh")) {//41
            opcode = "101001";
        } else if(campo.equals("swl")) {//42
            opcode = "101010";
        } else if(campo.equals("sw")) {//43
            opcode = "101011";
        } else if(campo.equals("swr")) {//46
            opcode = "101110";
        }
        
        return opcode;
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
        } else if (reg.equals("$s2")) {
            regBinary = "10001";
        } else if (reg.equals("$s3")) {
            regBinary = "10010";
        } else if (reg.equals("$s4")) {
            regBinary = "10011";
        } else if (reg.equals("$s5")) {
            regBinary = "10100";
        } else if (reg.equals("$s6")) {
            regBinary = "10110";
        } else if (reg.equals("$s7")) {
            regBinary = "10111";
        }
        
        return regBinary;
    }

    public void tipoI(String[] campo){
        String binary = "";
        binary += registrador(campo[2]);
    }
}