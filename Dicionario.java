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

        }
        /**
         * INSTRUÇÕES LÓGICAS E ARITMÉTICAS - TIPO I
         */
        else if (campo.equals("addi")) {

            binaryResult = "001000";
            binaryResult += tipoI(instruction[2], instruction[1], instruction[3]);

        }else if (campo.equals("addiu")) {

            binaryResult = "001001";
            binaryResult += tipoI(instruction[2], instruction[1], instruction[3]);
            
        }else if (campo.equals("slti")) {
            
            binaryResult = "001010";
            binaryResult += tipoI(instruction[2], instruction[1], instruction[3]);
            
        }else if (campo.equals("sltiu")) {

            binaryResult = "001011";
            binaryResult += tipoI(instruction[2], instruction[1], instruction[3]);
            
        }else if (campo.equals("andi")) {

            binaryResult = "001100";
            binaryResult += tipoI(instruction[2], instruction[1], instruction[3]);
            
        }else if (campo.equals("ori")) {

            binaryResult = "001101";
            binaryResult += tipoI(instruction[2], instruction[1], instruction[3]);
            
        }else if (campo.equals("xori")) {

            binaryResult = "001110";
            binaryResult += tipoI(instruction[2], instruction[1], instruction[3]);
            
        }else if (campo.equals("lui")) {

            binaryResult = "001111";
            binaryResult += tipoI("$zero", instruction[1], instruction[2]);
            
        }
        /**
         * INSTRUÇÕES DE DESLOCAMENTO DE BITS - TIPO R
         */
        else if (campo.equals("sll")) {

            binaryResult = tipoR("00000", instruction[2], instruction[1], instruction[3], "000000"); // instrução shamt

        }else if (campo.equals("srl")) {

            binaryResult = tipoR("00000", instruction[2], instruction[1], instruction[3], "000010"); // instrução shamt
            
        }else if (campo.equals("sra")) {

            binaryResult = tipoR("00000", instruction[2], instruction[1], instruction[3], "000011"); // instrução shamt

        }else if (campo.equals("sllv")) {

            binaryResult = tipoR(instruction[3], instruction[2], instruction[1], "00000", "000100");

        }else if (campo.equals("srlv")) {

            binaryResult = tipoR(instruction[3], instruction[2], instruction[1], "00000", "000110");

        }else if (campo.equals("srav")) {

            binaryResult = tipoR(instruction[3], instruction[2], instruction[1], "00000", "000111");

        }
        /**
         * INSTRUÇÕES DE MULTIPLICAÇÃO E DIVISÃO - TIPO R
         */
        else if (campo.equals("mfhi")) {

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

        }
        /**
         * INSTRUÇÕES DE DESVIO - TIPO R
         */
        else if (campo.equals("jr")) {

            binaryResult = tipoR(instruction[1], "00000", "00000", "00000", "001000");

        }else if (campo.equals("jalr")) {
            
            binaryResult = tipoR(instruction[2], instruction[3], instruction[1], "00000", "001001");
        }

        /**
         * INSTRUÇÕES DE DESVIO - TIPO J
         */
        else if (campo.equals("j")) {
            
            binaryResult = "000010";
            binaryResult += tipoJ(instruction[1]);
            
        }else if (campo.equals("jal")) {

            binaryResult = "000011";
            binaryResult += tipoJ(instruction[1]);
            
        }

        /**
         * INSTRUÇÕES DE DESVIO - TIPO I
         */
        else if (campo.equals("bltz")) {

            binaryResult = "000001";
            binaryResult += branchTipoI(instruction[1], "00000", instruction[2]);
            
        }else if(campo.equals("bgez")){

            binaryResult = "000001";
            binaryResult += branchTipoI(instruction[1], "00001", instruction[2]);
            
        }else if(campo.equals("bltzal")){

            binaryResult = "000001";
            binaryResult += branchTipoI(instruction[1], "10000", instruction[2]);
            
        }else if(campo.equals("bgezal")){

            binaryResult = "000001";
            binaryResult += branchTipoI(instruction[1], "10001", instruction[2]);
            
        }else if(campo.equals("beq")){

            binaryResult = "000100";
            binaryResult += tipoI(instruction[1], instruction[2], instruction[3]);
            
        }else if(campo.equals("bne")){

            binaryResult = "000101";
            binaryResult += tipoI(instruction[1], instruction[2], instruction[3]);
            
        }else if(campo.equals("blez")){
            binaryResult = "000110";
            binaryResult += branchTipoI(instruction[1], "00000", instruction[2]);
            
        }else if(campo.equals("bgtz")){
            binaryResult = "000111";
            binaryResult += branchTipoI(instruction[1], "00000", instruction[2]);
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
        binary += toBinary(immediate, 16);
        return binary;
    }

    public String branchTipoI(String rs, String num, String immediate) {
        String binary = "";
        binary += registrador(rs);
        binary += num;
        binary += toBinary(immediate, 16);
        return binary;
    }

    public String tipoR(String rs, String rt, String rd, String shamt, String funct){
        String binary = "000000"; // opcode
        binary += registrador(rs);
        binary += registrador(rt);
        binary += registrador(rd);
        binary += toBinary(shamt, 5);
        binary += funct;
        return binary;
    }

    public String toBinary(String immediate, int bitAmount){
        int aux = Integer.parseInt(immediate);
        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < bitAmount; i++) {
            binary.insert(0, (aux & 1));
            aux >>= 1;
        }
        
        return binary.toString();
    }

    public String tipoJ(String instr_index){
        String binary = "";
        binary += toBinary(instr_index, 16);
        return binary;
    }
    
}