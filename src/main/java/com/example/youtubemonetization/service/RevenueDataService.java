package com.example.youtubemonetization.service;

import com.example.youtubemonetization.entity.Revenue;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface RevenueDataService {

    Revenue save(Revenue revenue);

    List<Revenue> getByVideoId(Long videoId);

    List<Revenue> getByAuthorId(Long authorId);

    Optional<Revenue> findByVideoIdAndPeriod(Long videoId, Integer periodYear, Integer periodMonth);

    BigDecimal sumAuthorRevenueForPeriod(Long authorId, Integer periodYear, Integer periodMonth);
}
