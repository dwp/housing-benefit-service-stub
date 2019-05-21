package uk.gov.dwp.housing.web.api;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import uk.gov.dwp.housing.util.TestUtil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ExternalApiControllerBadRequestTest extends AbstractExternalApiControllerTest {

    @Test
    public void post_missing_request_body() throws Exception {
        mockMvc.perform(post(EXTERNAL_CLAIM_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .header(CORRELATION_ID_HEADER, CORRELATION_ID)
                .header(API_KEY_HEADER, API_KEY)
                .characterEncoding("utf-8"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void post_missing_claimant() throws Exception {
        mockMvc.perform(post(EXTERNAL_CLAIM_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .header(CORRELATION_ID_HEADER, CORRELATION_ID)
                .header(API_KEY_HEADER, API_KEY)
                .characterEncoding("utf-8")
                .content(TestUtil.getResourceAsString("classpath:requests/claim-request-example-missing-claimant.json")))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void post_missing_software_provider() throws Exception {
        mockMvc.perform(post(EXTERNAL_CLAIM_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .header(CORRELATION_ID_HEADER, CORRELATION_ID)
                .header(API_KEY_HEADER, API_KEY)
                .characterEncoding("utf-8")
                .content(TestUtil.getResourceAsString("classpath:requests/claim-request-example-missing-software-provider.json")))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void post_invalid_software_provider() throws Exception {
        mockMvc.perform(post(EXTERNAL_CLAIM_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .header(CORRELATION_ID_HEADER, CORRELATION_ID)
                .header(API_KEY_HEADER, API_KEY)
                .characterEncoding("utf-8")
                .content(TestUtil.getResourceAsString("classpath:requests/claim-request-example-invalid-software-provider.json")))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void post_invalid_monetary_value() throws Exception {
        mockMvc.perform(post(EXTERNAL_CLAIM_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .header(CORRELATION_ID_HEADER, CORRELATION_ID)
                .header(API_KEY_HEADER, API_KEY)
                .characterEncoding("utf-8")
                .content(TestUtil.getResourceAsString("classpath:requests/claim-request-example-invalid-monetary-value.json")))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void post_invalid_surname() throws Exception {
        mockMvc.perform(post(EXTERNAL_CLAIM_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .header(CORRELATION_ID_HEADER, CORRELATION_ID)
                .header(API_KEY_HEADER, API_KEY)
                .characterEncoding("utf-8")
                .content(TestUtil.getResourceAsString("classpath:requests/claim-request-example-invalid-surname.json")))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void post_claim_containing_float_where_expecting_integer() throws Exception {
        mockMvc.perform(post(EXTERNAL_CLAIM_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .header(CORRELATION_ID_HEADER, CORRELATION_ID)
                .header(API_KEY_HEADER, API_KEY)
                .characterEncoding("utf-8")
                .content(TestUtil.getResourceAsString("classpath:requests/claim-request-example-invalid-float-as-integer.json")))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void post_claim_containing_integer_where_expecting_boolean() throws Exception {
        mockMvc.perform(post(EXTERNAL_CLAIM_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .header(CORRELATION_ID_HEADER, CORRELATION_ID)
                .header(API_KEY_HEADER, API_KEY)
                .characterEncoding("utf-8")
                .content(TestUtil.getResourceAsString("classpath:requests/claim-request-example-invalid-integer-as-boolean.json")))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}
