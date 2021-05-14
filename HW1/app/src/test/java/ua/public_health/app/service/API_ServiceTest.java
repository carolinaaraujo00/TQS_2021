package ua.public_health.app.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;
import ua.public_health.app.model.Covid19_Information;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class API_ServiceTest {
    private Logger logger = Logger.getLogger(API_ServiceTest.class.getName());

    private static final String baseURL = "https://covid19-api.vost.pt/Requests/";
    private Covid19_Information response;

    @InjectMocks
    private API_Service service;

    @Mock(lenient = true)
    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp() {

        this.response = new Covid19_Information();
        this.response.setData("06-05-2021");
        this.response.setArs("Centro");
        this.response.setConcelho("AVEIRO");
        this.response.setConfirmados_1(3);
        this.response.setConfirmados_14(41);
        this.response.setIncidencia(52);
        this.response.setIncidencia_categoria("[0,120]");
        this.response.setIncidencia_risco("Baixo a Moderado");
        this.response.setCasos_14dias(41);
        this.response.setPopulacao_total(78734);
        this.response.setPopulacao_65_mais(15927);
        this.response.setDensidade_populacional(398.49);

    }

    @Disabled
    public void existingLocationReturnsCovid19_Information() {
        logger.log(Level.INFO, "API Service TEST");

        String cidade = "aveiro";
        String url = baseURL + "get_last_update_specific_county/" + cidade;

        Mockito.when(restTemplate.getForObject(url, Covid19_Information.class)).thenReturn(this.response);
        Mockito.verify(restTemplate, VerificationModeFactory.times(1)).getForObject(url, Covid19_Information.class);

        Covid19_Information test = service.getInfoByLocation(cidade);

        assertThat(this.response).isEqualTo(test);
    }


}