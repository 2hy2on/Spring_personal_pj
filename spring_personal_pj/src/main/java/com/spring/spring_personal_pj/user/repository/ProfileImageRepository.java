package com.spring.spring_personal_pj.user.repository;

import com.spring.spring_personal_pj.user.entity.ProfileEntity;
import com.spring.spring_personal_pj.user.entity.ProfileImageEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileImageRepository extends JpaRepository<ProfileImageEntity, Long> {

    @Override
    <S extends ProfileImageEntity> S save(S entity);

    @Override
    Optional<ProfileImageEntity> findById(Long aLong);

    @Query(value = "SELECT * FROM profileimage WHERE profile_id = :profileId and is_current = true", nativeQuery = true)
    ProfileImageEntity getCurrentImage(@Param("profileId") long profileId);

    @Query(value = "SELECT * FROM profileimage WHERE user_id = :userId and is_current = true", nativeQuery = true)
    ProfileImageEntity getCurrentImageByUserId(@Param("userId") long userId);
//    void deleteByProfileId(Long id);
}
