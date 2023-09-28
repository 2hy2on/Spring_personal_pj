package com.spring.spring_personal_pj.user.service;

import com.spring.spring_personal_pj.user.dto.ProfileDto;
import com.spring.spring_personal_pj.user.dto.ProfileImageDto;
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

            ProfileEntity savedProfile = profileRepository.save(newProfile);

            ProfileImageEntity newProfImg = new ProfileImageEntity(profileDto.isCurrent(), false, profileDto.getProfileImg(), newProfile);
            ProfileImageEntity newProfileImg = profileImageRepository.save(newProfImg);

            BgImageEntity newBgImg = new BgImageEntity(profileDto.isBgCurrent(), false, profileDto.getBgImg(), newProfile);
            BgImageEntity newProfBgImg = profileBgRepository.save(newBgImg);

            return new ProfileDto(newProfile, newProfileImg, newProfBgImg);

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
        Optional<ProfileEntity> existingProfile = profileRepository.findById(id);
        //존재하면
        if(existingProfile.isPresent()){
            ProfileEntity updateProfile =existingProfile.get();
            //바꿀 dto 정보를 넣어줌
            updateProfile.setNickname(newProfileDto.getNickname());
            updateProfile.setStatusMsg(newProfileDto.getStatusMsg());
            updateProfile.setMulti(newProfileDto.isMulti());
            //저장 후
            profileRepository.save(updateProfile);

            return new ProfileDto(updateProfile);

            }
        return newProfileDto;

    }

    public void deleteProfile(Long id){
//        profileBgRepository.deleteByProfileId(id);
//        profileImageRepository.deleteByProfileId(id);
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

    public ProfileImageDto saveProfileImage(ProfileImageDto profileImgDto) {
        ProfileEntity pe = profileRepository.findById(profileImgDto.getProfileId()).get();
        ProfileImageEntity profileImageEntity = new ProfileImageEntity(pe, profileImgDto);
        ProfileImageEntity imageEntity = profileImageRepository.save(profileImageEntity);

        return new ProfileImageDto(imageEntity);
    }

    public String removeProfileImg(Long profileImgId) {
        profileImageRepository.deleteById(profileImgId);
        return "삭제했습니다";
    }

    public ProfileImageDto updateProfileImg(Long profileImgId, ProfileImageDto profileImageDto) {
        Optional<ProfileImageEntity> existingProfileImg = profileImageRepository.findById(profileImgId);
        //존재하면
        if(existingProfileImg.isPresent()){
            ProfileImageEntity updateProfileImg =existingProfileImg.get();
            //바꿀 dto 정보를 넣어줌
            System.out.println("============"+ profileImageDto.isHidden());
            updateProfileImg.setHidden(profileImageDto.isHidden());
            updateProfileImg.setCurrent(profileImageDto.isCurrent());

            System.out.println("============"+ updateProfileImg.isHidden());
            //저장 후
            ProfileImageEntity newProfileImg = profileImageRepository.save(updateProfileImg);

            return new ProfileImageDto(newProfileImg);

        }
        return null;
    }
}
