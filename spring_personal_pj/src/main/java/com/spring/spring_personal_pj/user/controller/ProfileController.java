package com.spring.spring_personal_pj.user.controller;

import com.fasterxml.jackson.databind.ser.Serializers.Base;
import com.spring.spring_personal_pj.exception.base.BaseResponse;
import com.spring.spring_personal_pj.user.dto.ProfileDto;
import com.spring.spring_personal_pj.user.dto.ProfileImageDto;
import com.spring.spring_personal_pj.user.entity.ProfileEntity;
import com.spring.spring_personal_pj.user.service.ProfileService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    //변수로 빼는게 좋음


    //쿼리에 DTO 넣기 가능
    //common 파일 만들기
    //friend 따로 빼기

    @Autowired
    ProfileService profileService;

    //프로필 생성
    @PostMapping("/users/profiles")
    @ResponseBody
    BaseResponse<ProfileDto> addProfile(@RequestBody ProfileDto profile){
        ProfileDto profileDto = profileService.save(profile.getUserId(), profile);
        return BaseResponse.onSuccess(profileDto);
    }

    //프로필 부분 조회, 클릭 시 image가 current에 해당하는 이미지가 나와야함

    @GetMapping("/users/profiles/{profileId}")
    @ResponseBody
    BaseResponse<ProfileDto> getProfile(@PathVariable("profileId") Long id){
        ProfileDto profileDto = profileService.getProfileById(id);
        return BaseResponse.onSuccess(profileDto);
    }

    //프로필 전체 조회
    @GetMapping("/users/profile-lists/{userId}")
    @ResponseBody
    BaseResponse<List<ProfileDto>> getAllProfile(@PathVariable("userId") long userId){
        List<ProfileDto> profileDto = profileService.findAllByUserId(userId);
        return BaseResponse.onSuccess(profileDto);
   }

   //프로필 수정
   @PatchMapping("/users/profiles/{profileId}")
   @ResponseBody
   public BaseResponse<ProfileDto> updateProfile(@PathVariable("profileId") Long profileId, @RequestBody ProfileDto profileDto){
        ProfileDto updateProfile = profileService.updateProfile(profileId, profileDto);
        return BaseResponse.onSuccess(updateProfile);
    }



    //프로필 이미지 추가

    @PostMapping("/users/profileImages")
    @ResponseBody
    public BaseResponse<ProfileImageDto> addProfileImg(@RequestBody ProfileImageDto profileImgDto){
        ProfileImageDto profileImageDto = profileService.saveProfileImage(profileImgDto);
        return BaseResponse.onSuccess(profileImageDto);
    }
    //프로필 이미지 삭제
    @DeleteMapping("/users/profileImages/{profileImgId}")
    @ResponseBody
    public BaseResponse<String> removeProfileImg(@PathVariable("profileImgId") Long profileImgId){
        return BaseResponse.onSuccess(profileService.removeProfileImg(profileImgId));
       // return BaseResponse.onSuccess();
    }

    @PatchMapping("/users/profileImages/{profileImgId}")
    @ResponseBody
    public BaseResponse<ProfileImageDto> updateProfileImg(@PathVariable("profileImgId") Long profileImgId, @RequestBody ProfileImageDto profileImageDto){
        ProfileImageDto profileDto = profileService.updateProfileImg(profileImgId, profileImageDto);
        return BaseResponse.onSuccess(profileDto);

    }



    //fk떄문에 delete안됨, 프사 배경 삭제 후 삭제해야함
    @ResponseBody
    @DeleteMapping("/users/profiles/{profileId}")
    public void deleteProfile(@PathVariable("profileId") Long profileId){
        profileService.deleteProfile(profileId);
    }

}


