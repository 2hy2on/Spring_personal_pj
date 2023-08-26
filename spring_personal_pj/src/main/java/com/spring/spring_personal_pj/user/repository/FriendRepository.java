package com.spring.spring_personal_pj.user.repository;

import com.spring.spring_personal_pj.user.entity.FriendEntity;
import com.spring.spring_personal_pj.user.entity.ProfileEntity;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

//@Repository
//public class FriendRepository extends JpaRepository<FriendEntity, Long> {
//
//    @Override
//    public <S extends FriendEntity> S save(S entity) {
//        return null;
//    }
//
//    @Override
//    public Optional<FriendEntity> findById(Long aLong) {
//        return Optional.empty();
//    }
//
//    @Override
//    public void deleteById(Long aLong) {
//
//    }
//
//    @Override
//    public <S extends FriendEntity, R> R findBy(Example<S> example,
//        Function<FetchableFluentQuery<S>, R> queryFunction) {
//        return null;
//    }
//}
