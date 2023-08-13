package com.spring.spring_personal_pj.user.repository;

import com.spring.spring_personal_pj.user.entity.UserEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Override
    Optional<UserEntity> findById(Long aLong);

    @Override
    <S extends UserEntity> S
    save(S entity);

    @Override
    List<UserEntity> findAll();

    @Override
    void deleteById(Long aLong);

//    @Override
//    <S extends UserEntity> S save(S entity);
}
