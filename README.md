Student Scrapper 

Projeto criado com o intuito de auxiliar no resgate de informações dos alunos cadastrados em certas disciplinas no SIGAA. 

Como rodar? 

- Primeiramente o usuário deve logar no sistema SIGAA e navegar até a disciplina desejada.
- Após isso, navegar até a aba de participantes e então clicar com o botão direito do mouse e clicar em "View Page Source"
- Copiar o conteudo retornado e colar no arquivo pagina.txt presente no diretório 'src/main/resources/input'
- Executar a classe Main presente em 'src/main/java/com/mourarezendecas/Main.java'
- O arquivo gerado se chama listaAlunos.csv e o mesmo se encontra presente em 'src/main/resources/output/listaAlunos.csv'

Após a execução se feita com sucesso, o contéudo retornado será um csv contendo matrícula, nome, curso e e-mail de cada aluno presente na disciplina analisada. 