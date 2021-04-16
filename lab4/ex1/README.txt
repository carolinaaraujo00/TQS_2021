MULTI-LAYER APPLICATION TESTING (WITH SPRING BOOT)
##################################################

1. STUDY THE EXAMPLE 


	a) Identify a couple of examples on the use of AssertJ expressive methods chaining.
	
		1. EmployeeService_UnitTest.java: 
		 	assertThat(allEmployees).hasSize(3).extracting(Employee::getName).contains(alex.getName(), john.getName(), bob.getName());
		 	
		2. EmployeeRestControllerTemplateIT.java:
		 
		 	assertThat(found).extracting(Employee::getName).containsOnly("bob");
		 	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
			assertThat(response.getBody()).extracting(Employee::getName).containsExactly("bob", "alex");
					
		
		
	b) Identify an example in which you mock the behavior of the repository (and avoid involving a database). 
	
		In the file EmployeeService_UnitTest.java its created a mock of the employeeRepository, which means that it isn't necessary to use a real database, in this context:
		
			Mockito.when(employeeRepository.findByName(john.getName())).thenReturn(john;
			Mockito.when(employeeRepository.findByName(alex.getName())).thenReturn(alex);
			Mockito.when(employeeRepository.findByName("wrong_name")).thenReturn(null);
			Mockito.when(employeeRepository.findById(john.getId())).thenReturn(Optional.of(john));
			Mockito.when(employeeRepository.findAll()).thenReturn(allEmployees);
			Mockito.when(employeeRepository.findById(-99L)).thenReturn(Optional.empty());



	c) What is the difference between standard @Mock and @MockBean?
	source: https://rieckpil.de/difference-between-mock-and-mockbean-spring-boot-applications/
	        https://stackoverflow.com/questions/44200720/difference-between-mock-mockbean-and-mockito-mock
	
		@Mock: used when unit testing business logic, using JUnit and Mockito. Mocks a class or interface and verifies its behaviour. Its not limited to the Spring Framework, as it can be used elsewhere.
		
		
		@MockBean: allows to add Mockito mocks in a Spring ApplicationContext, its used in a Spring Framework environment. When the annotation is used, the mock is injected in the code as a bean. 
		
	

	d) What is the role of the file “application-integrationtest.properties”? In which conditions will it be used?
	source: https://docs.spring.io/spring-framework/docs/4.2.x/spring-framework-reference/html/integration-testing.html
	
	Its used when the @TestPropertySource annotation is used and the locations argument points to the application-integrationtest.properties file. In this case it says what the DB used is, but it can also contain other information about the configuration of the application context.
