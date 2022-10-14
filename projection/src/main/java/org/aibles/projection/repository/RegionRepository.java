package org.aibles.projection.repository;

import java.util.Optional;
import org.aibles.projection.dto.response.ProvinceResponse;
import org.aibles.projection.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

}
