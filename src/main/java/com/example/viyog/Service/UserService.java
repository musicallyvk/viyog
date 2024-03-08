package com.example.viyog.Service;


import com.example.viyog.Dto.UserDto;
import com.example.viyog.entity.User;
import com.example.viyog.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;


  public UserDto createUser(UserDto userDto){
      System.out.println(userDto.toString()); ;
//      userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
//      userDto.setEmail(userDto.getEmail());
//      userDto.setMobileNumber(userDto.getMobileNumber());
//      userDto.setName(userDto.getName());
      User user = modelMapper.map(userDto,User.class);
      //fetch role of normal and set it to user
//        Role role = roleRepository.findById(normalRoleId).get();
//        user.getRoles().add(role);
      User savedUser = userRepository.save(user);
      //entity -> dto
      UserDto newDto = modelMapper.map(savedUser,UserDto.class);
      return newDto;

   }

}
