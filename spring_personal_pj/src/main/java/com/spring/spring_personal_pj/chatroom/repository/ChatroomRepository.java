package com.spring.spring_personal_pj.chatroom.repository;

import com.spring.spring_personal_pj.chatroom.entity.ChatroomEntity;
import com.spring.spring_personal_pj.user.entity.BgImageEntity;
import com.spring.spring_personal_pj.user.entity.ProfileImageEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatroomRepository extends JpaRepository<ChatroomEntity, Long> {
    @Override
    Optional<ChatroomEntity> findById(Long aLong);

    @Override
    <S extends ChatroomEntity> S save(S entity);
}
