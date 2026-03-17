package com.example.youtubemonetization.service.impl;

import com.example.youtubemonetization.entity.Claim;
import com.example.youtubemonetization.enums.ClaimStatus;
import com.example.youtubemonetization.exception.EntityNotFoundException;
import com.example.youtubemonetization.repository.ClaimRepository;
import com.example.youtubemonetization.service.ClaimDataService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ClaimDataServiceImpl implements ClaimDataService {

    private final ClaimRepository claimRepository;

    @Override
    public Claim create(Claim claim) {
        return claimRepository.save(claim);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Claim> getByVideoId(Long videoId) {
        return claimRepository.findByVideoId(videoId);
    }

    @Override
    public Claim resolveClaim(Long claimId) {
        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new EntityNotFoundException("Claim with id=" + claimId + " not found"));
        claim.setStatus(ClaimStatus.RESOLVED);
        claim.setResolvedAt(LocalDateTime.now());
        return claimRepository.save(claim);
    }
}
