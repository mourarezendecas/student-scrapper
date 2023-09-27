package com.mourarezendecas;


import com.mourarezendecas.contentreader.ContentHelper;
import com.mourarezendecas.csvgenerator.CsvUtils;
import com.mourarezendecas.models.AlunoModel;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> conteudoBruto =  ContentHelper.retiraTabelaUsuarios(ContentHelper.lerConteudo("src/main/resources/input/pagina.txt"));

        List<AlunoModel> alunos = ContentHelper.constroiAlunos(conteudoBruto);

        CsvUtils.generateCSV(alunos);
    }
}