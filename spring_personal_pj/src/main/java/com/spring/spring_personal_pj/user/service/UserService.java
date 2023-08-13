package com.spring.spring_personal_pj.user.service;


import com.spring.spring_personal_pj.user.dto.UserDto;
import com.spring.spring_personal_pj.user.entity.UserEntity;
import com.spring.spring_personal_pj.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDto save(UserDto userDto){
        UserEntity newUser = userRepository.save(userDto.toEntity());
        return new UserDto(
            newUser.getEmail(),
            newUser.getPhone(),
            newUser.getName(),
            newUser.getPassword(),
            newUser.getBirth()
        );
    }

//    public List<UserEntity> getUsers() throws IllegalAccessException {
//        List<UserEntity> users = userRepository.findAll();
//
//        if(!users.isEmpty()) return users;
//        else throw new IllegalAccessException("no such data");
//    }
//
    public UserDto getUserById(Long id){
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());

        if (userEntity != null) {
            return new UserDto(
                userEntity.getEmail(),
                userEntity.getPhone(),
                userEntity.getName(),
                userEntity.getPassword(),
                userEntity.getBirth());
        } else {
            // 사용자가 없을 경우에 대한 처리
            return null;
        }
    }
//
//    public void createUser(final UserEntity user) throws IllegalAccessException {
//        if(user == null) throw new IllegalAccessException("user cannot be null");
//        else userRepository.save(user);
//    }
//
public boolean updateUser(Long userId, UserDto updatedUserDto) {
    UserEntity existingUser = userRepository.findById(userId).orElse(null);

    if (existingUser != null) {
        // Update the fields with values from updatedUserDto
        existingUser.setEmail(updatedUserDto.getEmail());
        existingUser.setPhone(updatedUserDto.getPhone());
        existingUser.setName(updatedUserDto.getName());
        existingUser.setPassword(updatedUserDto.getPassword());
        existingUser.setBirth(updatedUserDto.getBirth());

        userRepository.save(existingUser);
        return true;
    } else {
        return false;
    }
}
}
