package com.mourarezendecas.csvgenerator;

import com.mourarezendecas.models.AlunoModel;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvUtils {
    public static void generateCSV(List<AlunoModel> alunos) throws IOException {
        String arquivoCSV = "src/main/resources/output/listaAlunos.csv";
        try (FileWriter writer = new FileWriter(arquivoCSV);
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Nome", "Matrícula", "Email", "Curso"))) {

            for (AlunoModel aluno : alunos) {
                csvPrinter.printRecord(aluno.getNome(), aluno.getMatricula(), aluno.getEmail(), aluno.getCurso());
            }

            csvPrinter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
