package uk.gov.dwp.housing.web.api;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static uk.gov.dwp.housing.util.TestUtil.getResourceAsString;

public class ExternalClaimControllerImplInvalidTimestampTest extends AbstractExternalApiControllerTest {

    @Test
    public void post_invalid_timestamp() throws Exception {
        mockMvc.perform(post(EXTERNAL_CLAIM_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .header(CORRELATION_ID_HEADER, CORRELATION_ID)
                .header(API_KEY_HEADER, API_KEY)
                .characterEncoding("utf-8")
                .content(getResourceAsString("classpath:requests/claim-request-example-invalid-timestamp.json")))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}
