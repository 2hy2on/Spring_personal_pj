package com.spring.spring_personal_pj.user.repository;

import com.spring.spring_personal_pj.user.entity.BgImageEntity;
import com.spring.spring_personal_pj.user.entity.ProfileImageEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileBgRepository extends JpaRepository<BgImageEntity, Long> {

    @Override
    <S extends BgImageEntity> S save(S entity);

    @Override
    Optional<BgImageEntity> findById(Long aLong);

    @Query(value = "SELECT * FROM bgimage WHERE profile_id = :profileId and is_current = true", nativeQuery = true)
    BgImageEntity getCurrentImage(@Param("profileId") long profileId);

//    @Query(value = "SELECT * FROM bgimage WHERE profile_id = :profileId and is_current = true", nativeQuery = true)
//    void deleteByProfileId(Long id);

}
