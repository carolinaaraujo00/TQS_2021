BEHAVIOR-DRIVEN DEVELOPMENT (CUCUMBER IN JAVA)
##############################################

3. INTEGRATE CUCUMBER WITH SELENIUM WEBDRIVER

src:  https://cucumber.io/docs/guides/browser-automation/
      https://github.com/bonigarcia/mastering-junit5/tree/master/junit5-cucumber-selenium
     

demo: https://blazedemo.com/

Comecei por utilizar o exemplo fornecido pelo professor (github), alterando depois os testes, tanto a feature como os search steps para: 

1. usar o firefox como driver
2. ir para  o blazedemo.com em vez de google.com
3. escolher departure Philadelphia
4. escolher destination New York
5. clicar Find Flights
6. verificar se a página onde se encontra agora tem o voo Lufthansa na última linha da tabela
7. escolher esse voo para Lufthansa, id = 4346
8. clicar Purchase 
9. verificar se o texto que aparece na página depois de finalizar é "Thank you for your purchase today!"
10. fechar driver 

Todos os testes passaram :) foi usado como ajuda o selenium IDE para não ter de escrever os clicks e findElementBy(...) à mão 
