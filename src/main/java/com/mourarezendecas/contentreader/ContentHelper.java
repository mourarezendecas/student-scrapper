package com.mourarezendecas.contentreader;

import com.mourarezendecas.models.AlunoModel;
import org.apache.commons.text.StringEscapeUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContentHelper {
    static String REGEX_CAPTURA_TD_USER = "(?<=<td valign=\"top\">)([^<]*(?:(?!<td valign=\"top\">)<[^<]*)*)";
    static String REGEX_CAPTURA_NOME_ALUNO = "<strong>\\s*([^<]+)\\s*<";
    static String REGEX_CAPTURA_CURSO = "(?<=Curso: <em>)[^<]+";
    static String REGEX_CAPTURA_MATRICULA = "(?<=Matr&#237;cula: <em>)[^<]+";
    static String REGEX_CAPTURA_EMAIL = "(?<=E-mail: <em>)[^<]+";

    public static String lerConteudo(String path) throws Exception {
        File file = new File(path);

        BufferedReader br = new BufferedReader(new FileReader(file));

        StringBuilder contentBuilder = new StringBuilder();
        String line;

        while((line = br.readLine())!=null){
            contentBuilder.append(line).append("\n");
        }

        String content = contentBuilder.toString();

        return content;
    }

    public static List<String> retiraTabelaUsuarios(String conteudo) throws Exception {
        List<String> conteudoBruto = new ArrayList<>();

        Pattern pattern = Pattern.compile(REGEX_CAPTURA_TD_USER, Pattern.DOTALL);

        Matcher matcher = pattern.matcher(conteudo);

        while (matcher.find()){

            String retorno = matcher.group(1).trim();

            conteudoBruto.add(retorno);
        }

        return conteudoBruto;
    }

    public static List<AlunoModel> constroiAlunos(List<String> conteudos){
        List<AlunoModel> alunoList = new ArrayList<>();
        for(String conteudo : conteudos){
            if(verificaSeEhProfessor(conteudo)){
                System.out.println("Professor encontrado! Pulando para próximo conteúdo.");
            }
            else{
                String nome = extrairNomeDoAluno(conteudo);
                String curso = extrairCursoDoAluno(conteudo);
                String matricula = extrairMatriculaDoAluno(conteudo);
                String email = extrairEmailDoAluno(conteudo);

                AlunoModel alunoModel = new AlunoModel(nome, curso, matricula, email);

                System.out.println("NOME: " + nome + " - CURSO: " + curso + " - MATRICULA: " + matricula + " - EMAIL: " + email);

                alunoList.add(alunoModel);
            }
        }

        return alunoList;
    }

    public static String extrairEmailDoAluno(String conteudo){
        Pattern pattern = Pattern.compile(REGEX_CAPTURA_EMAIL, Pattern.DOTALL);

        Matcher matcher = pattern.matcher(conteudo);

        String email = "";

        while (matcher.find()){
            email = matcher.group().trim();
        }

        return email;
    }

    public static String extrairMatriculaDoAluno(String conteudo){
        Pattern pattern = Pattern.compile(REGEX_CAPTURA_MATRICULA, Pattern.DOTALL);

        Matcher matcher = pattern.matcher(conteudo);

        String matricula = "";

        while (matcher.find()){
            matricula = matcher.group().trim();
        }

        return matricula;
    }

    public static String extrairCursoDoAluno(String conteudo){
        Pattern pattern = Pattern.compile(REGEX_CAPTURA_CURSO, Pattern.DOTALL);

        Matcher matcher = pattern.matcher(conteudo);

        String curso = "";

        while (matcher.find()){
            curso = matcher.group().trim();
        }

        return corrigeEnconder(curso);
    }

    public static String corrigeEnconder(String nomeCurso){
        String decodedString = StringEscapeUtils.unescapeHtml4(nomeCurso);

        return decodedString;
    }

    public static String extrairNomeDoAluno(String conteudo){
        Pattern pattern = Pattern.compile(REGEX_CAPTURA_NOME_ALUNO, Pattern.DOTALL);

        Matcher matcher = pattern.matcher(conteudo);

        String nome = "";

        while (matcher.find()){
            nome = matcher.group(1).trim();
        }

        return corrigeEnconder(nome);
    }

    public static boolean verificaSeEhProfessor(String conteudo){
        if(conteudo.contains("deste docente")){
            return true;
        }
        else{
            return false;
        }
    }

}
