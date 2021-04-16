MULTI-LAYER APPLICATION TESTING (WITH SPRING BOOT)
##################################################

2. API FOR CAR INFORMATION SYSTEM

	Usando o Spring Boot Initializr, criou-se um projeto com as seguintes dependências: 
	- Spring Boot DevTools
	- Spring Web
	- Spring Data JPA
	- H2 Database
	- Lombok

a) Criar testes para o CarController com um mock do CarService bean:
	- testar a função de postar um carro e confirmar a informação do mesmo
	- testar o getAllCars
	- validar o id de um carro 
	

b) Criar testes para o CarService com um mock do CarRepository: 
	criou-se um beforeEach para criar mocks dos 3 carros usados em cada um dos testes, bem como um mock de o que acontece quando se procura por um id que não está associado a nenhum carro. 
	
	- testar ids validos e verificar se o findByCarId é apenas chamado 1x
	- testar ids invalidos e verificar o throw da exceção resourceNotFound, bem como se a função findByCarId é apenas chamada 1x
	- verificar se o findAll é apenas chamado 1x, se o serviço retorna uma lista com 3 elementos e se os elementos estão corretamente guardados
	

c) Criar testes para o CarRepository
	(a dependência da base de dados h2 está no pom.xml)
	
	- testar ids validos
	- testar ids invalidos
	- testar todos os carros, tamanho da lista.... same old, same old


d) Integration Test (E)
	agora testar sem mocks.. 




##################################################
3. ADAPTING THE INTEGRATION TEST TO USE A REAL DB

e) 

	1. Add SQL dependency: 
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>


	2. Run mysql image in docker with the following: 
		$docker run --name mysql5tqs -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=tqsdemo -e MYSQL_USER=demo -e MYSQL_PASSWORD=demo -p 33060:3306 -d mysql/mysql-server:5.7


	3. Create application-integrationtest.properties file, and add it to the proper directory in the tests (resources/carAPI/app/controller/):

		## note changed port 3306 --> 33060
		spring.datasource.url=jdbc:mysql://localhost:33060/tqsdemo
		spring.jpa.hibernate.ddl-auto=create-drop
		spring.datasource.username=demo
		spring.datasource.password=demo

		## db
		## docker run --name mysql5tqs -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=tqsdemo -e MYSQL_USER=demo -e MYSQL_PASSWORD=demo -p 33060:3306 -d mysql/mysql-server:5.7


	4. Change @AutoConfigureTestDatabase for @TestPropertySource(locations = "application-integrationtest.properties")
	
	
	   
