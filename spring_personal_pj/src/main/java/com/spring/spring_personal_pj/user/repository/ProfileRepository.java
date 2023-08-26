package com.spring.spring_personal_pj.user.repository;

import com.spring.spring_personal_pj.user.entity.ProfileEntity;
import com.spring.spring_personal_pj.user.entity.UserEntity;
import java.util.List;
import java.util.Optional;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {

    @Override
    <S extends ProfileEntity> S save(S entity);

    @Override
    Optional<ProfileEntity> findById(Long aLong);

    @Override
    List<ProfileEntity> findAll();

    @Override
    void deleteById(Long aLong);

    @Query("SELECT p FROM ProfileEntity p WHERE p.user.id = :userId")
    List<ProfileEntity> findAllByUserId(Long userId);

}
