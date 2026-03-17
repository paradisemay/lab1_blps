package com.example.youtubemonetization.repository;

import com.example.youtubemonetization.entity.Video;
import com.example.youtubemonetization.enums.MonetizationStatus;
import com.example.youtubemonetization.enums.UploadStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VideoRepository extends JpaRepository<Video, Long> {

    List<Video> findByAuthorId(Long authorId);

    List<Video> findByUploadStatus(UploadStatus uploadStatus);

    List<Video> findByMonetizationStatus(MonetizationStatus monetizationStatus);

    @Query("select v from Video v where v.publishedAt is not null")
    List<Video> findPublishedVideos();
}
