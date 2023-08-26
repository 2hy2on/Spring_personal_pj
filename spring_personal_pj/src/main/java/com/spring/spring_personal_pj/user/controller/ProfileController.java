package com.spring.spring_personal_pj.user.controller;

import com.spring.spring_personal_pj.user.dto.ProfileDto;
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


    @Autowired
    ProfileService profileService;

    //프로필 생성
    @PostMapping("/users/profiles")
    public ProfileDto createProfile(@RequestBody ProfileDto profile){
        return profileService.save(profile.getUserId(), profile);
    }

    //프로필 부분 조회
    @ResponseBody
    @GetMapping("/users/profiles/{profileId}")
    public ProfileDto getProfile(@PathVariable("profileId") Long id){
        System.out.println(profileService.getProfileById(id));
        return profileService.getProfileById(id);
    }

    //프로필 전체 조회
    @ResponseBody
    @GetMapping("/users/profile-lists/{userId}")
    public List<ProfileDto> getAllProfile(@PathVariable("userId") Long userId){
        return profileService.findAllByUserId(userId);
   }

   //프로필 수정
    @ResponseBody
    @PatchMapping("/users/profiles/{profileId}")
    public ProfileDto updateProfile(@PathVariable("profileId") Long profileId, @RequestBody ProfileDto profileDto){
        return profileService.updateProfile(profileId, profileDto);
    }

    //프로필 삭제
    @ResponseBody
    @DeleteMapping("/users/profiles/{profileId}")
    public void deleteProfile(@PathVariable("profileId") Long profileId){
        profileService.deleteProfile(profileId);
    }

}


