package uk.gov.dwp.housing.web.api;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import uk.gov.dwp.housing.web.dto.ClaimRequest;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@WebMvcTest(controllers = ExternalHousingBenefitApiController.class)
public abstract class AbstractExternalApiControllerTest {

    protected static final String EXTERNAL_CLAIM_PATH = "/housing-benefit/v1/external/claim";
    protected static final String CORRELATION_ID_HEADER = "correlationId";
    protected static final String API_KEY_HEADER = "apiKey";
    protected static final String CORRELATION_ID = "1d69de6d-ef8e-4a83-95d5-01207dd5cac3";
    protected static final String API_KEY = "xQFmnA7KAO6705R52AmCVzH5JmklyaDf";

    @MockBean
    protected ExternalHousingBenefitApiDelegate mockExternalHousingBenefitApiDelegate;

    @Autowired
    protected MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        given(mockExternalHousingBenefitApiDelegate.submitClaim(anyString(), any(UUID.class), any(ClaimRequest.class)))
                .willReturn(ResponseEntity.noContent().build());
    }
}
