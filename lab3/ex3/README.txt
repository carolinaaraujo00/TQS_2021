ACCEPTANCE TESTING WITH WEB AUTOMATION

################################################################################
3. Refactor to use Selenium extensions for JUnit 5

src: https://bonigarcia.github.io/selenium-jupiter/

a) 
Uma vez que não tenho chrome, não consegui fazer testes para esse browser, apenas para o firefox. 
Criei um teste para ir google e verificar se o title da página era "Google".



b) 
Para os headless browsers, fizeram-se dois testes, um para o PhantomJS e outro para o HTMLUnit. 
Para o primeiro, verifica-se se a source code da página não é null; para o HTMLUnit verifica-se se o título contém a string indicada. 



c)
Com base no exercício 2, no código gerado pelo IDE, fez-se um novo teste mas agora com base nas anotações do Selenium-Jupiter extension. 



d) OPCIONAL
Com base nos exemplos para testar em browsers que estejam a ser suportados por docker, foram criados testes para o Chrome (com versão) e Opera - os testes são basicamente os mesmos que foram feitos para o firefox. 
