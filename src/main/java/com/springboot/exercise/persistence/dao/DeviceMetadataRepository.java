package com.springboot.exercise.persistence.dao;

import com.springboot.exercise.persistence.model.DeviceMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceMetadataRepository extends JpaRepository<DeviceMetadata, Long> {
    List<DeviceMetadata> findByUserId(Long userId);
}