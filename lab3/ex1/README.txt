ACCEPTANCE TESTING WITH WEB AUTOMATION

################################################################################
1. Run web automation tests with WebDriver(locally)

a) 
Para instalar o GeckoDriver para o firefox no linux, fiz download e segui os seguintes passos:

"Manual steps to install geckodriver on Ubuntu:

    download the latest version of "geckodriver-vX. XX. X-linux64. ...
    unarchive the tarball ( tar -xvzf geckodriver-vX. XX. ...
    give executable permissions to geckodriver ( chmod +x geckodriver )
    move the geckodriver binary to /usr/local/bin or any location on your system PATH."
    

De seguida foi preciso criar um projeto maven novo - WebDriver
E seguir o exemplo: https://saucelabs.com/resources/articles/getting-started-with-webdriver-selenium-for-java-in-eclipse

Primeiramente o teste falhou...porque não estava a usar chrome, então foi preciso fazer as seguintes alterações para funcionar: 


>> import org.openqa.selenium.firefox.FirefoxDriver;
(...)
		WebDriver browser = new FirefoxDriver();




b) 
Foi preciso criar as funções, com base no código anterior
	@BeforeEach init_driver()
	@AfterEach close_browser() 
	
Outras coisas que podem ser interessantes quando se faz automação de interação com o browser: 
	NAVEGAÇÃO - https://www.selenium.dev/documentation/en/webdriver/browser_manipulation/ 
	FIND ELEMENTS - https://www.selenium.dev/documentation/en/webdriver/locating_elements/
