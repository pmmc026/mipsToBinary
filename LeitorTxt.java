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
                linha = linha.replace(",", "");
                linha = linha.replace("(", " ");
                linha = linha.replace(")", "");
                linhaFatiada = linha.split(" ");
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
