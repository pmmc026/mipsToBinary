package com.arquitetura;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class LeitorTxt {
    private String diretorioArquivo;
    BufferedReader entradaDeDados;
    
    public LeitorTxt(String diretorioArquivo) throws FileNotFoundException {

        this.diretorioArquivo = diretorioArquivo;
        this.entradaDeDados = new BufferedReader(new FileReader(diretorioArquivo));

    }

    public String[] proximaLinha() {
        String[] linhaFatiada = null;
        try {
            String linha = entradaDeDados.readLine();
            if (linha != null) {
                linhaFatiada = linha.split(" ");
                for(int i=0; i<linhaFatiada.length; i++){
                    linhaFatiada[i] = linhaFatiada[i].replace(",", "");
                    linhaFatiada[i] = linhaFatiada[i].replace("(", ", ");
                    linhaFatiada[i] = linhaFatiada[i].replace(")", "");
                }
            } else {
                entradaDeDados.close();
                linhaFatiada = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhaFatiada;
    }
}
