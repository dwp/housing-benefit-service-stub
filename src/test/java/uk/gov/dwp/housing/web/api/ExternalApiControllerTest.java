package uk.gov.dwp.housing.web.api;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import uk.gov.dwp.housing.util.TestUtil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ExternalApiControllerTest extends AbstractExternalApiControllerTest {

    @Test
    public void post_claim_full() throws Exception {
        mockMvc.perform(post(EXTERNAL_CLAIM_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .header(CORRELATION_ID_HEADER, CORRELATION_ID)
                .header(API_KEY_HEADER, API_KEY)
                .characterEncoding("utf-8")
                .content(TestUtil.getResourceAsString("classpath:requests/claim-request-example-full.json")))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void post_claim_basic() throws Exception {
        mockMvc.perform(post(EXTERNAL_CLAIM_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .header(CORRELATION_ID_HEADER, CORRELATION_ID)
                .header(API_KEY_HEADER, API_KEY)
                .characterEncoding("utf-8")
                .content(TestUtil.getResourceAsString("classpath:requests/claim-request-example-basic.json")))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}
