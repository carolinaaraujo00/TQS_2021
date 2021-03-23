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
	
	
	
	
	
3) GeocodeTestIT
