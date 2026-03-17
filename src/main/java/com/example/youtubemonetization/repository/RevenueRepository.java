package com.example.youtubemonetization.repository;

import com.example.youtubemonetization.entity.Revenue;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RevenueRepository extends JpaRepository<Revenue, Long> {

    List<Revenue> findByVideoId(Long videoId);

    List<Revenue> findByVideoAuthorId(Long authorId);

    Optional<Revenue> findByVideoIdAndPeriodYearAndPeriodMonth(Long videoId, Integer periodYear, Integer periodMonth);

    @Query("""
            select coalesce(sum(r.amount), 0)
            from Revenue r
            where r.video.author.id = :authorId
            and r.periodYear = :periodYear
            and r.periodMonth = :periodMonth
            """)
    BigDecimal sumAuthorRevenueForPeriod(
            @Param("authorId") Long authorId,
            @Param("periodYear") Integer periodYear,
            @Param("periodMonth") Integer periodMonth
    );
}
