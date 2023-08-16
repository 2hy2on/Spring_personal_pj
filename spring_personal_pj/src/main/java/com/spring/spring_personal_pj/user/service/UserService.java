//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.spring.spring_personal_pj.user.service;

import com.spring.spring_personal_pj.user.dto.UserDto;
import com.spring.spring_personal_pj.user.entity.UserEntity;
import com.spring.spring_personal_pj.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService() {
    }

    public UserDto save(UserDto userDto) {
        UserEntity newUser = this.userRepository.save(userDto.toEntity());
        return new UserDto(newUser.getEmail(), newUser.getPhone(), newUser.getName(), newUser.getPassword(), newUser.getBirth());
    }

    public UserDto getUserById(Long id) {
        UserEntity userEntity = (UserEntity)this.userRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException();
        });
        return userEntity != null ? new UserDto(userEntity.getEmail(), userEntity.getPhone(), userEntity.getName(), userEntity.getPassword(), userEntity.getBirth()) : null;
    }

    public boolean updateUser(Long userId, UserDto updatedUserDto) {
        UserEntity existingUser = (UserEntity)this.userRepository.findById(userId).orElse(
            (UserEntity) null);
        if (existingUser != null) {
            existingUser.setEmail(updatedUserDto.getEmail());
            existingUser.setPhone(updatedUserDto.getPhone());
            existingUser.setName(updatedUserDto.getName());
            existingUser.setPassword(updatedUserDto.getPassword());
            existingUser.setBirth(updatedUserDto.getBirth());
            this.userRepository.save(existingUser);
            return true;
        } else {
            return false;
        }
    }
}
