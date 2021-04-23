BEHAVIOR-DRIVEN DEVELOPMENT (CUCUMBER IN JAVA)
##############################################

1. CREATE A SIMPLE CUCUMBER-ENABLED PROJECT
src: https://www.oreilly.com/library/view/mastering-software-testing/9781787285736/6e1c1a32-79a7-492e-xhtml-a452.894c9f646bfd
     https://github.com/bonigarcia/mastering-junit5/tree/master/junit5-cucumber
     


Com base no repositório git que nos é fornecido como exemplo, teve-se em atenção que o .feature tinha de ficar nos resources do diretório de testes, com o mesmo path que os testes no diretorio java. Alterou-se a versão do java no pom.xml para 11. 


Adicionaram-se features e staps para os casos da multiplicação e divisão, bem como um para vários casos de multiplicação. 
>> [INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0





Apontamentos: 

	1. @Cucumber serve para fazer a ativação, o ficheiro em si pode ficar vazio, sendo que os testes ficam noutros ficheiros - simplesmente há uma procura inicial nesta pasta para ver se há testes cucumber para realizar. 

	2. Remover os sinais ^ e $, alterar (\\d+) para {int}

	3. @Given: preciso de uma calculadora que acabei de ligar, como vamos traduzir isto no nosso código? Preciso de uma nova instância de uma calculadora, portanto é neste passo que se instancia. Pode-se colocar isto na secção background para que corra sempre no início, tipo @BeforeEach do jUnit. 

	4. Isto é uma calculadora em stack, pelo que a adição leva 3 pushes (cada variável + resultado)
	
	
