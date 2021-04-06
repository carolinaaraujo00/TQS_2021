ACCEPTANCE TESTING WITH WEB AUTOMATION

################################################################################
2. Create a web automation with Selenium IDE recorder

Criei um teste que percorresse o site, introduzisse informação e fizesse um assert final sobre o texto que aparecia na página de login. Depois de dar replay ao teste e ver que tudo passou sem problemas, exportei o teste e incluí-o no projeto maven criado para o exercício 1. 

Copiou-se o AutomationTest.java para a pasta de testes do projeto WebDriver, tendo sido necessário criar a classe Automation, vazia.
Foi preciso alterar os imports que correspondiam a coisas do junit 4 e que são diferentes no junit 5:
	import org.junit.jupiter.api.AfterEach;
	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;
	
Bem como a última linha do teste, onde tinha um assertThat, que também deixou de existir; foi substituído por um assertEquals, removendo o *is* e colocando simplesmente a string "Login". 
Depois disto, os testes passaram sem problemas. 
