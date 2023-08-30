package com.spring.spring_personal_pj.user.service;

import com.spring.spring_personal_pj.user.dto.ProfileDto;
import com.spring.spring_personal_pj.user.entity.BgImageEntity;
import com.spring.spring_personal_pj.user.entity.ProfileEntity;
import com.spring.spring_personal_pj.user.entity.ProfileImageEntity;
import com.spring.spring_personal_pj.user.entity.UserEntity;
import com.spring.spring_personal_pj.user.repository.ProfileBgRepository;
import com.spring.spring_personal_pj.user.repository.ProfileImageRepository;
import com.spring.spring_personal_pj.user.repository.ProfileRepository;
import com.spring.spring_personal_pj.user.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProfileImageRepository profileImageRepository;
    @Autowired
    private ProfileBgRepository profileBgRepository;

    //프로필 생성
    public ProfileDto save(Long userId, ProfileDto profileDto){
        Optional<UserEntity> user = userRepository.findById(userId);

        if(user.isPresent()){
            ProfileEntity newProfile = ProfileEntity.builder()
                .user(user.get())
                .nickname(profileDto.getNickname())
                .statusMsg(profileDto.getStatusMsg())
                .isMulti(profileDto.isMulti())
                .profileQr(profileDto.getProfileQr())
                .build();

            return new ProfileDto(profileRepository.save(newProfile));

            //????
            //userRepository.save(user.get());

        }

        throw new RuntimeException("User with Id" + userId+"not fund");
    }
    //프로필 조회

    public ProfileDto getProfileById(Long id){
        Optional<ProfileEntity> profileEntity = profileRepository.findById(id);
        if(profileEntity.isPresent()){
            ProfileEntity profileExisting = profileEntity.get();
            ProfileImageEntity profileImg = profileImageRepository.getCurrentImage((long)id);
            BgImageEntity profileBg = profileBgRepository.getCurrentImage((long)id);

            return new ProfileDto(profileExisting,profileImg, profileBg);
        }

        return null;
    }

    public ProfileDto updateProfile(Long id, ProfileDto newProfileDto){
        System.out.println("왜 안받아져와"+newProfileDto.getNickname());

        Optional<ProfileEntity> existingProfile = profileRepository.findById(id);
        if(existingProfile.isPresent()){
            ProfileEntity uploadProfile =existingProfile.get();

            System.out.println("아이디로 찾음"+uploadProfile.getNickname());
            System.out.println("==============");
            uploadProfile.setNickname(newProfileDto.getNickname());
            uploadProfile.setStatusMsg(newProfileDto.getStatusMsg());
            uploadProfile.setMulti(newProfileDto.isMulti());
                profileRepository.save(uploadProfile);
            System.out.println("아이디로 찾음"+uploadProfile.getNickname());
     //           return new ProfileDto(existingProfile.getProfileId(), existingProfile.getNickname(),
       //             existingProfile.getStatusMsg(), existingProfile.isMulti(),existingProfile.getProfileQr());
            }
        return newProfileDto;

    }

    public void deleteProfile(Long id){
        profileRepository.deleteById(id);
    }

    public List<ProfileDto> findAllByUserId(long userId){
        List<ProfileEntity> profileListEnt = profileRepository.getAllByUserId(userId);
        List<ProfileDto> profileListDto = new ArrayList<>();
        System.out.println("========리스트 돌리기 전");
        for (ProfileEntity profileEntity : profileListEnt) {
            System.out.println("========리스트 돌리기 "+ profileEntity.getProfileId());
            ProfileDto profileDto = new ProfileDto(profileEntity);

            profileListDto.add(profileDto);
        }

        return profileListDto;

    }

}
