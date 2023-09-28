//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.spring.spring_personal_pj.user.service;

import static com.spring.spring_personal_pj.exception.base.ErrorCode.CHECK_PASSWORD_SAME;
import static com.spring.spring_personal_pj.exception.base.ErrorCode.EMAIL_NOT_FOUND;
import static com.spring.spring_personal_pj.exception.base.ErrorCode.MEMBER_NOT_FOUND;

import com.spring.spring_personal_pj.exception.base.BaseException;
import com.spring.spring_personal_pj.exception.base.BaseResponse;
import com.spring.spring_personal_pj.user.dto.UpdatePasswordDto;
import com.spring.spring_personal_pj.user.dto.UserDto;
import com.spring.spring_personal_pj.user.entity.UserEntity;
import com.spring.spring_personal_pj.user.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService() {
    }

    public UserDto save(UserDto userDto) {
        UserEntity newUser = userRepository.save(userDto.toEntity());
        return new UserDto(newUser);
    }

    public UserDto getUserById(Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if(userEntity.isPresent()){
            System.out.println("service  통과함");
            return new UserDto(userEntity.get());
        }else{
            System.out.println("service else 통과함");
            throw new BaseException(MEMBER_NOT_FOUND);
        }

    }

    public boolean updateUser(Long userId, UserDto updatedUserDto) {
        UserEntity existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser != null) {
            existingUser.setEmail(updatedUserDto.getEmail());
            existingUser.setPhone(updatedUserDto.getPhone());
            existingUser.setName(updatedUserDto.getName());
            existingUser.setPassword(updatedUserDto.getPassword());
            existingUser.setBirth(updatedUserDto.getBirth());
            this.userRepository.save(existingUser);

            return true;
        }
        else { //해당 멤버가 없을 때
            throw new BaseException(MEMBER_NOT_FOUND);
        }

    }

    public UserDto updatePassword(UpdatePasswordDto updatePasswordDto){

        UserEntity existingUser = userRepository.findByEmail(updatePasswordDto.getEmail()).orElse( null);

        if(existingUser != null){
            if(existingUser.getPassword().equals(updatePasswordDto.getPw())) { //비번이 같으면
                throw new BaseException(CHECK_PASSWORD_SAME);
            }
            else{
                existingUser.setPassword(updatePasswordDto.getNewPw());
                userRepository.save(existingUser);
                return new UserDto(existingUser);
            }
        }
        else{ //없는 이메일 입니다.
            throw new BaseException(EMAIL_NOT_FOUND);
        }
    }
}
