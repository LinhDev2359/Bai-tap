package org.aibles.projection.repository;

import java.util.Optional;
import org.aibles.projection.dto.response.ProvinceResponse;
import org.aibles.projection.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {

  @Query("select new org.aibles.projection.dto.response.ProvinceResponse(P.id, P.code, P.name, R.id, R. code, R.name)" +
  "From Province P inner join Region R on R.regionId = p.id and R.id = :id")
  Optional<ProvinceResponse> find(@Param("id") long id);

}
