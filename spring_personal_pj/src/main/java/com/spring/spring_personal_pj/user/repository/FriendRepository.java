package com.spring.spring_personal_pj.user.repository;

import com.spring.spring_personal_pj.user.entity.FriendEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//필등명에 *에 안씀 필드명 일일히 써주기- 그래야 디비에 컬럼이 추가되어도 영향안감

@Repository
public interface FriendRepository extends JpaRepository<FriendEntity, Long> {

    @Override
    List<FriendEntity> findAllById(Iterable<Long> longs);

    @Query(value = "SELECT * FROM friend WHERE user_id = :userId ", nativeQuery = true)
    List<FriendEntity> getAllByUserId(@Param("userId") long userId);

    @Query(value = "SELECT * FROM friend WHERE user_id = :userId and friend_user_id = :friendUserId ", nativeQuery = true)
    FriendEntity getFriendByUserId(@Param("userId") long userId ,@Param("friendUserId") long friendUserId);

    @Override
    <S extends FriendEntity> S save(S entity);
}
