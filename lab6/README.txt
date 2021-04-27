TQS LAB6
Universidade de Aveiro, 2020/2021

Realizado por: Carolina Simões Araújo

######################################################
Task 1: ANALYZE AN EXISTING PROJECT (LOCAL SONAR QUBE)

https://docs.sonarqube.org/latest/setup/get-started-2-minutes/
	1. instalei a partir de uma imagem do docker, usando o comando providenciado. 

	2. alterei o ficheiro settings.xml do maven conforme

	3. gerei um token para utilizar
	
	$mvn clean verify sonar:sonar -Dsonar.login=8cc618a715a6eb4c8d66dce82b77d60aaa612d49
	(...)
	[INFO] ANALYSIS SUCCESSFUL, you can browse http://127.0.0.1:9000/dashboard?id=tqslabs%3Aeuromillions-play
	[INFO] Note that you will be able to access the updated dashboard once the server has processed the submitted analysis report
	[INFO] More about the report processing at http://127.0.0.1:9000/api/ce/task?id=AXkTLuwHK6ToJo4plYS3
	[INFO] Analysis total time: 5.015 s
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time:  11.641 s
	[INFO] Finished at: 2021-04-27T12:55:12+01:00
	[INFO] ------------------------------------------------------------------------


	Overall Code: 
	1 bug
	0 vulnerabilities
	1 security hotstop
	2h 5min debt
	23 code smells 
	72.4% coverage on 136 lines, 8 unit tests 
	0% duplications on 287 lines 
	0 duplicated blocks
	
	
	Security Hotspot: usei um pseudorandom number generator e é preciso verificar se é seguro, porque, pelos vistos, há CVEs associados a alguns dos mesmos. 
	
	Bug: Novamente relacionado ao random, diz que gerar um random cada vez que um valor é requirido é ineficiente e pode gerar que nem são random, dependendo do JDK. É necessário criar apenas 1 random, guardá-lo e reutiliza-lo.
	
	Code smells: 2x loop counter from within the loop (MAJOR)
				 reordenar modifiers para estar de acordo com a Java Language Specification
				 return de ArrayList em vez da interface List
				 substituir o tipo num construtor com o diamond operator <>
				 7x substituir System.out/System.err com loggers (MAJOR)
				 11x remover o public modifier 
				 

######################################################
Task 2: RESOLVE TECHNICAL DEBT

	2a. 2h 5min debt significa que, para resolver os problemas encontrados, i.e code smells, estima-se que vá demorar cerca de 2h 5min. É a dívida em termos da qualidade do projeto que podíamos ter. 
	
	2b. Para resolver os problemas tenho de: 
		
		1. substituir System.out/System.err com loggers
		2. remover o i++ no meio do loop no Dip.java
		   Why is this an issue? A for loop stop condition should test the loop counter against an invariant value (i.e. one that is true at both the beginning and ending of every loop iteration). Ideally, this means that the stop condition is set to a local variable just before the loop begins. 
		3. o problema do random 
		
		
Depois de resolver os problemas e voltar a submeter o código para análise, debt passou para 35min, fiquei com apenas 14 code smells e a overall coverage ficou nos 71.1%. 
Deixarei na pasta lab6 um print destes resultados, como forma de comprovar, bem como o código refactored. 
