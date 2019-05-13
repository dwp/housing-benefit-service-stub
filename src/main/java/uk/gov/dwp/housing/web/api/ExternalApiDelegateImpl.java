package uk.gov.dwp.housing.web.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uk.gov.dwp.housing.web.dto.ClaimRequest;

@Service
public class ExternalApiDelegateImpl implements ExternalApiDelegate {
    @Override
    public ResponseEntity<Void> submitClaim(String apiKey, String correlationId, ClaimRequest claimRequest) {
        return ResponseEntity.noContent().build();
    }
}
