package com.example.youtubemonetization.repository;

import com.example.youtubemonetization.entity.Claim;
import com.example.youtubemonetization.enums.ClaimStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Long> {

    List<Claim> findByVideoId(Long videoId);

    List<Claim> findByStatus(ClaimStatus status);
}
