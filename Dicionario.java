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

        } else if(campo.equals("lwl")) {//34
        
            binaryResult = "100010";
            binaryResult += tipoI(instruction[3], instruction[1], instruction[2]);

        } else if(campo.equals("lw")) {//35

            binaryResult = "100011";
            binaryResult += tipoI(instruction[3], instruction[1], instruction[2]);

        } else if(campo.equals("lbu")) {//36

            binaryResult = "100100";
            binaryResult += tipoI(instruction[3], instruction[1], instruction[2]);

        } else if(campo.equals("lhu")) {//37

            binaryResult = "100101";
            binaryResult += tipoI(instruction[3], instruction[1], instruction[2]);

        } else if(campo.equals("lwr")) {//38

            binaryResult = "100110";
            binaryResult += tipoI(instruction[3], instruction[1], instruction[2]);

        } else if(campo.equals("sb")) {//40

            binaryResult = "101000";
            binaryResult += tipoI(instruction[3], instruction[1], instruction[2]);

        } else if(campo.equals("sh")) {//41

            binaryResult = "101001";
            binaryResult += tipoI(instruction[3], instruction[1], instruction[2]);

        } else if(campo.equals("swl")) {//42

            binaryResult = "101010";
            binaryResult += tipoI(instruction[3], instruction[1], instruction[2]);

        } else if(campo.equals("sw")) {//43

            binaryResult = "101011";
            binaryResult += tipoI(instruction[3], instruction[1], instruction[2]);

        } else if(campo.equals("swr")) {//46

            binaryResult = "101110";
            binaryResult += tipoI(instruction[3], instruction[1], instruction[2]);

        }
        /**
         * INSTRUÇÕES LÓGICAS E ARITMÉTICAS - TIPO R
         */
        else if (campo.equals("add")) {

            binaryResult = tipoR(instruction[2], instruction[3], instruction[1], "00000", "100000");

        }else if (campo.equals("addu")) {

            binaryResult = tipoR(instruction[2], instruction[3], instruction[1], "00000", "100001");

        }else if (campo.equals("sub")) {

            binaryResult = tipoR(instruction[2], instruction[3], instruction[1], "00000", "100010");

        }else if (campo.equals("subu")) {

            binaryResult = tipoR(instruction[2], instruction[3], instruction[1], "00000", "100011");
            
        }else if (campo.equals("and")) {
            
            binaryResult = tipoR(instruction[2], instruction[3], instruction[1], "00000", "100100");
            
        }else if (campo.equals("or")) {

            binaryResult = tipoR(instruction[2], instruction[3], instruction[1], "00000", "100101");

        }else if (campo.equals("xor")) {

            binaryResult = tipoR(instruction[2], instruction[3], instruction[1], "00000", "100110");
        
        }else if (campo.equals("nor")) {

            binaryResult = tipoR(instruction[2], instruction[3], instruction[1], "00000", "100111");

        }else if (campo.equals("slt")) {

            binaryResult = tipoR(instruction[2], instruction[3], instruction[1], "00000", "101010");

        }else if (campo.equals("sltu")) {

            binaryResult = tipoR(instruction[2], instruction[3], instruction[1], "00000", "101011");

        }else if (campo.equals("sll")) {

            binaryResult = tipoR("00000", instruction[3], instruction[1], instruction[2], "000000"); // instrução shamt - registrador "rs" é lido como "sa"

        }else if (campo.equals("srl")) {

            binaryResult = tipoR("00000", instruction[3], instruction[1], instruction[2], "000010"); // instrução shamt - registrador "rs" é lido como "sa"
            
        }else if (campo.equals("sra")) {

            binaryResult = tipoR("00000", instruction[3], instruction[1], instruction[2], "000011"); // instrução shamt - registrador "rs" é lido como "sa"

        }else if (campo.equals("sllv")) {

            binaryResult = tipoR(instruction[2], instruction[3], instruction[1], "00000", "000100");

        }else if (campo.equals("srlv")) {

            binaryResult = tipoR(instruction[2], instruction[3], instruction[1], "00000", "000110");

        }else if (campo.equals("srav")) {

            binaryResult = tipoR(instruction[2], instruction[3], instruction[1], "00000", "000111");

        }else if (campo.equals("mfhi")) {

            binaryResult = tipoR("00000", "00000", instruction[1], "00000", "010000");

        }else if (campo.equals("mthi")) {

            binaryResult = tipoR(instruction[2], "00000", "00000", "00000", "010001");
        
        }else if (campo.equals("mflo")) {
        
            binaryResult = tipoR("00000", "00000", instruction[1], "00000", "010010");

        }else if (campo.equals("mtlo")) {

            binaryResult = tipoR(instruction[2], "00000", "00000", "00000", "010011");

        }else if (campo.equals("mult")) {

            binaryResult = tipoR(instruction[1], instruction[2], "00000", "00000", "011000");

        }else if (campo.equals("multu")) {

            binaryResult = tipoR(instruction[1], instruction[2], "00000", "00000", "011001");

        }else if (campo.equals("div")) {

            binaryResult = tipoR(instruction[1], instruction[2], "00000", "00000", "011010");

        }else if (campo.equals("divu")) {

            binaryResult = tipoR(instruction[1], instruction[2], "00000", "00000", "011011");

        }else if (campo.equals("jr")) {

            binaryResult = tipoR(instruction[1], "00000", "00000", "00000", "001000");

        }else if (campo.equals("jalr")) {
            
            binaryResult = tipoR(instruction[2], instruction[3], instruction[1], "00000", "001001");
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
            regBinary = "10101";
        } else if (reg.equals("$s6")) {
            regBinary = "10110";
        } else if (reg.equals("$s7")) {
            regBinary = "10111";
        }
        
        return regBinary;
    }

    public String tipoI(String rs, String rt, String immediate){
        String binary = "";
        binary += registrador(rs);
        binary += registrador(rt);
        binary += String.format("%1$"+16+"s",toBinary(immediate));
        return binary;
    }

    public String tipoR(String rs, String rt, String rd, String shamt, String funct){
        String binary = "000000"; // opcode
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