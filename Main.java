package com.arquitetura;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        LeitorTxt leitor = new LeitorTxt("demo\\src\\main\\java\\com\\programa1.txt");
        Dicionario dic = new Dicionario();
        String[] line;
        while((line = leitor.proximaLinha())!=null){
            System.out.println(Arrays.toString(line));
            System.out.println(dic.search(line));
        }
    }
}