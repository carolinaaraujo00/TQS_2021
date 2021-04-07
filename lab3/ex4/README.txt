ACCEPTANCE TESTING WITH WEB AUTOMATION

################################################################################
4. Separation of concerns with Page Object pattern

Foi apenas seguir o tutorial: https://www.toptal.com/selenium/test-automation-in-selenium-using-page-object-model-and-page-factory

Foi necessário mudar os ids dos elementos, bem como a string dos headings na HomePage e ApplyPage
	HOME PAGE
	@FindBy(how = How.LINK_TEXT, using = "Apply as a Freelancer")



	APPLY
    @FindBy(id="talent_create_applicant_email")
    WebElement developer_email;

    @FindBy(id = "talent_create_applicant_password")
    WebElement developer_password;

    @FindBy(id = "talent_create_applicant_password_confirmation")
    WebElement developer_password_confirmation;

    @FindBy(id = "talent_create_applicant_full_name")
    WebElement developer_full_name;

    @FindBy(id ="save_new_talent_create_applicant")
    WebElement join_toptal_button;
    
Já não havia nada para o skype, a isOpened também teve de ser trocada por causa da string: 
    public boolean isPageOpened(){
        return heading.getText().contains("Apply to Join\nthe World's Top Talent Network");
    }
    
E, com as dependências necessárias, o teste correu sem problemas. 
O clickOnJoin() continua comentado para criar uma inscrição...
