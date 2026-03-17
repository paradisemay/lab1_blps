package com.example.youtubemonetization.service;

import com.example.youtubemonetization.entity.Claim;
import java.util.List;

public interface ClaimDataService {

    Claim create(Claim claim);

    List<Claim> getByVideoId(Long videoId);

    Claim resolveClaim(Long claimId);
}
