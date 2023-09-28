package com.spring.spring_personal_pj.user.service;

import com.spring.spring_personal_pj.user.dto.FriendDto;
import com.spring.spring_personal_pj.user.dto.ProfileDto;
import com.spring.spring_personal_pj.user.entity.FriendEntity;
import com.spring.spring_personal_pj.user.entity.ProfileEntity;
import com.spring.spring_personal_pj.user.entity.ProfileImageEntity;
import com.spring.spring_personal_pj.user.entity.UserEntity;
import com.spring.spring_personal_pj.user.repository.FriendRepository;
import com.spring.spring_personal_pj.user.repository.ProfileImageRepository;
import com.spring.spring_personal_pj.user.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendService  {

    @Autowired
    private FriendRepository friendRepository;
    @Autowired
    private ProfileImageRepository profileImageRepository;

    @Autowired
    private UserRepository userRepository;

    public List<FriendDto> getAllByUserId(Long id) {
        List<FriendEntity> friendEnt = friendRepository.getAllByUserId((long)id);
        List<FriendDto> friendListDto = new ArrayList<>();

        for(FriendEntity f: friendEnt){
        //    ProfileImageEntity prfImg = profileImageRepository
         //       .getCurrentImageByUserId(f.getFriendUser().getUserId());
            friendListDto.add(new FriendDto(f));
        }
        return  friendListDto;
    }

    public FriendDto updateFriend(FriendDto friendDto) {
        FriendEntity friendEnt = friendRepository
            .getFriendByUserId(friendDto.getUserId(), friendDto.getFriendUserId());
        friendEnt.setFriendName(friendDto.getFriendName());
        friendEnt.setFavorite(friendDto.isFavorite());
        friendEnt.setHidden(friendDto.isHidden());
        friendEnt.setBlocked(friendDto.isBlocked());
        friendEnt.setProfileChecked(friendDto.isProfileChecked());

        return new FriendDto(friendEnt);
    }

    //userId, friendUserId 중복 안되게 해야함
    public FriendDto addFriendByPhone(long userId, String phoneNum) {
        UserEntity newFriend = userRepository.findByPhone(phoneNum).get();
        UserEntity userEntity = userRepository.findById(userId).get();

        FriendEntity newFriendEnt = new FriendEntity(false, false,
            false, false, newFriend.getName(), userEntity,newFriend);
        return new FriendDto(friendRepository.save(newFriendEnt));
    }

    public FriendDto addFriendById(long userId, String id){
        UserEntity newFriend = userRepository.getUserById(id);
        UserEntity userEntity = userRepository.findById(userId).get();

        FriendEntity newFriendEnt = new FriendEntity(false,false,false,
            false, newFriend.getName(), userEntity, newFriend);

        return new FriendDto(friendRepository.save(newFriendEnt));
    }
}
