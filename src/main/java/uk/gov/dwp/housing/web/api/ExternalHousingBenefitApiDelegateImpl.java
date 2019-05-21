package uk.gov.dwp.housing.web.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uk.gov.dwp.housing.web.dto.ClaimRequest;

import java.util.UUID;

@Service
public class ExternalHousingBenefitApiDelegateImpl implements ExternalHousingBenefitApiDelegate {

    @Override
    public ResponseEntity<Void> submitClaim(String apiKey, UUID correlationId, ClaimRequest claimRequest) {
        return ResponseEntity.noContent().build();
    }
}
