PRÁTICA 01 DE TQS - 2020/2021

Carolina Simões Araújo, nmec93248

Exercício 1: 

	a) b) c) d) e) f) g) h) i):
	Para cada uma das funcionalidades que era necessário testar, criaram-se os testes correspondentes, com base no que foi exemplificado na aula. 
	
	
	
	
Exercício 2: 


	a) testFormat: O objetivo é apenas alterar a função format() na classe Dip; depois de analizar o código, entendi que era necessário trocar a impressão das estrelas de %d para %3d, como nos números, e acrescentar um parentesis reto no final. 
	
	   testContructorFromBadArrays: Alterar a função @Test public void testConstructorFromBadArrays() de modo a que teste se o construtor de Dip lança uma exceção quando o número de elementos nos arrays do construtor estão errados. Fez-se um teste quer para o array dos números, quer para o dos starts. 
	   
	   
	   
	b) Acrescentou-se, no testAddBadArray() testes para verificar se a tentativa de inserção de números não naturais dá throw de IllegalArgumentException e se a tentativa de inserção de um elemento duplicado (neste caso tentou add 10 ao setB, que já pertencia ao conjunto) também lançava a mesma exceção. Deste modo, penso que no caso da adição de elementos ao set, cobrem-se todas as opções. Dividiu-se o teste em 3 asserts diferentes para, caso um deles falhasse, fosse fácil de identificar qual (uma vez que se colocaram mensagens).
	Como o fromArray() utiliza o add, não é preciso criar testes adicionais, visto que a função acima já testa todos os casos de más adições (ou seja, se se tentar criar um set com elementos duplicados, como ele itera sobre os elementos e usa a função add, elementos duplicados ou fora do range vão dar throw de exceções). 
	Penso que não seja necessário testar a função size(), iterator(), contains() ou hashCode() porque são funções que utilizam funcionalidades da framework java.
	O teste de intersects já criado testa a interseção de setA e setB, que nada têm em comum. Como a função intersects retorna sempre false, penso que o teste esteja já completo.
	Inicialmente, criou-se um teste para a função de equals, que verifica caso dois sets sejam iguais se retorna true e, caso um set seja comparado a um objeto de outra classe retorna false. No entanto, este teste estaria a testar uma função que usa, também ela, funcionalidades da framework, portanto foi retirado porque não é necessário (deixei-o comentado). 
	
	
	
	c) Com base em https://refactoring.guru/replace-magic-number-with-symbolic-constant, entendeu-se que fazia sentido criar constantes para os seguintes 'magic numbers' de Dip:
    static final int LENGTH_STARTS = 2;
    static final int LENGTH_NUMBERS = 5;
    static final int LIMIT_NUMBERS = 49;
    static final int LIMIT_STARTS = 9;
    
    Alterando, depois, o código como necessário.
    
    
    
    d) src: https://www.baeldung.com/jacoco
    Depois de adicionar o seguinte plugin do maven, no pom.xml:
    
    <build>
    <plugins>
    <!-- JUnit 5 requires Surefire version 2.22.1 or higher -->
    <plugin>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>3.0.0-M5</version>
    </plugin>
    <plugin>
        <groupId>org.jacoco</groupId>
        <artifactId>jacoco-maven-plugin</artifactId>
        <version>0.8.6</version>
        <executions>
            <execution>
                <goals>
                    <goal>prepare-agent</goal>
                </goals>
            </execution>
            <execution>
                <id>report</id>
                <phase>prepare-package</phase>
                <goals>
                    <goal>report</goal>
                </goals>
            </execution>
        </executions>
    </plugin>
    </plugins>
    </build>
    
    $mvn test 				// para verificar que tudo corria sem problemas
    $mvn test jacoco:report // para obter os resultados 
    
    Na pasta TQS/lab1/P2Euromillions/tqs_labs_euromillion_unit/target/site/jacoco, encontra-se o ficheiro index.html onde é possível ver os resultados obtidos com os testes criados. 
	Num total de 573 instruções, apenas 153 não foram avaliadas, um coverage de 73%. 
	De 52 branches, 12 não foram avaliados, 76%. 
