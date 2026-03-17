package com.example.youtubemonetization.service.impl;

import com.example.youtubemonetization.entity.Revenue;
import com.example.youtubemonetization.repository.RevenueRepository;
import com.example.youtubemonetization.service.RevenueDataService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RevenueDataServiceImpl implements RevenueDataService {

    private final RevenueRepository revenueRepository;

    @Override
    public Revenue save(Revenue revenue) {
        return revenueRepository.save(revenue);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Revenue> getByVideoId(Long videoId) {
        return revenueRepository.findByVideoId(videoId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Revenue> getByAuthorId(Long authorId) {
        return revenueRepository.findByVideoAuthorId(authorId);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Revenue> findByVideoIdAndPeriod(Long videoId, Integer periodYear, Integer periodMonth) {
        return revenueRepository.findByVideoIdAndPeriodYearAndPeriodMonth(videoId, periodYear, periodMonth);
    }

    @Override
    @Transactional(readOnly = true)
    public BigDecimal sumAuthorRevenueForPeriod(Long authorId, Integer periodYear, Integer periodMonth) {
        return revenueRepository.sumAuthorRevenueForPeriod(authorId, periodYear, periodMonth);
    }
}
