package com.example.youtubemonetization.service;

import com.example.youtubemonetization.entity.Payout;
import com.example.youtubemonetization.enums.PayoutStatus;
import java.util.List;
import java.util.Optional;

public interface PayoutDataService {

    Payout save(Payout payout);

    List<Payout> getByUserId(Long userId);

    List<Payout> getByStatus(PayoutStatus status);

    Optional<Payout> findByUserIdAndPeriod(Long userId, Integer periodYear, Integer periodMonth);
}
