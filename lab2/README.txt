LAB_2_TQS

1)
	1a) MOCKITO
	https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#1
	
	Depois de criar a classe Stock, StockPortfolio e a interface IStockmarketService, bem como depois de colocar as devidas dependências no pom.xml, criaram-se os testes para a classe StockPortfolio. 
	Instanciou-se o mock a partir das anotações, tendo de usar a MockitoExtension.
	O teste de getTotalValue() verifica se o resultado final dá 14, bem como se, ao chamar o getTotalValue(), a função getPrice() é chamada 2x - para verificar o bom funcionamento da implementação feita. 
	O código encontra-se comentado com a localização de cada uma das 5 etapas pedidas na alínea b) do 1a. 
	
	
	
	1b) HAMCREST
	https://www.baeldung.com/java-junit-hamcrest-guide
	
	De seguida, depois de adicionar a dependência do hamcrest, substitui-se o assertEquals do jUnit, pelo assertThat(..., is()) do hamcrest.
	
	
	
	
	
2) GPS coordinates
	
	a) Com base no código fornecido, https://gitlab.com/ico_gl/ua_tqs_gs20, foi possível começar o exercício.
	
	b) Verificar AddressResolver.findAddressForLocation(), que invoca um geocoding service remoto.
		Qual o serviço para fazer mock? 
		R: Interface ISimpleHttpClient.
	
	c) d) 
		Results: http://open.mapquestapi.com/geocoding/v1/reverse?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&location=40.640661,-8.656688&includeRoadMetadata=true
		Foi preciso construir uma String com a resposta esperada quando é chamado um url que contenha "location=40.640661%2C-8.656688".
		De seguida, o teste passou sem problemas.
		Usaram-se as anotações @Mock e @InjectMocks para criar uma solução mais clean. 

	
	e) Foi criado um teste para quando se passam más coordenadas (360, -360), tendo de se fazer uma expectation para quando o url contiver más coordenadas, neste caso "location=360.000000%2C-360.000000", sendo que o comportamento expectado é o throw de uma exceção do tipo IndexOutOfBounds. 
		Como sugerido, foi também criado um teste para ver se, quando o URL passado é null, é também lançada uma exceção. Verificou-se no MainGeocode qual seria a exceção lançada neste caso: 
		    TqsBasicHttpClient tqs = new TqsBasicHttpClient();
            tqs.get(null);
            
		Tendo sido verificado que era lançada uma NullPointerException: 
		Exception in thread "main" java.lang.NullPointerException
		
		Portanto o teste terá de apanhar uma exceção desse tipo (e o mock deve ser criado para dar throw dessa mesma exceção, para imitar o comportamento da API).
	
	
	
3) GeocodeTestIT
	
	Neste passo, em vez de se usar um mock para testar, deve usar-se a API em si. Criou-se o teste para o whenBadCoordidates_throwBadArrayindex, bem como um para o caso de ser passado um URL null: whenNullURL_throwNullPointer(). Ambos semelhantes aos criados na alínea 2, mas sem usar um mock para testar. 
	No caso de APIs, não se devem criar testes baseados em mocks porque a API, normalmente de terceiros, pode ser alterada. Quando isto acontece, os testes criados com mock continuaram a passar sem problemas, visto que nós é que decidimos como é que o mock se comporta em cada situação, e o código de produção falha porque usa a API em si. Portanto, nestes casos é melhor fazer testes de integração, não usando mocks. 
	
	
	Como são testes de integração, deve correr-se o seguinte comando: 
	
	$mvn install failsafe:integration-test
	Tendo sido obtidos os seguintes resultados >> 
	
		[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.185 s - in integration.AddressResolverIT
		[INFO] 
		[INFO] Results:
		[INFO] 
		[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
		[INFO] 
		[INFO] ------------------------------------------------------------------------
		[INFO] BUILD SUCCESS
		[INFO] ------------------------------------------------------------------------
		[INFO] Total time:  2.528 s
		[INFO] Finished at: 2021-03-25T10:25:02Z
		[INFO] ------------------------------------------------------------------------

		Process finished with exit code 0
	
	
	
	Enquanto que, com apenas $mvn test >> 
	
		[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.328 s - in geocoding.AddressResolverTest
		[INFO] 
		[INFO] Results:
		[INFO] 
		[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
		[INFO] 
		[INFO] ------------------------------------------------------------------------
		[INFO] BUILD SUCCESS
		[INFO] ------------------------------------------------------------------------
		[INFO] Total time:  2.075 s
		[INFO] Finished at: 2021-03-25T10:24:26Z
		[INFO] ------------------------------------------------------------------------

		Process finished with exit code 0
	
