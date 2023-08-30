package com.spring.spring_personal_pj.user.repository;

import com.spring.spring_personal_pj.user.entity.ProfileEntity;
import com.spring.spring_personal_pj.user.entity.ProfileImageEntity;
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

    @Query(value = "SELECT * FROM profile WHERE user_id = :userId", nativeQuery = true) //user는 db에 있는 값, 엔티티가 아님
    List<ProfileEntity> getAllByUserId(@Param("userId") long userId); //쿼리문안에 들어감!!!!

}
