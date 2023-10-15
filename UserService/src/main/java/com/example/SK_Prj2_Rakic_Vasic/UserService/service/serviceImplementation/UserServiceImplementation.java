package com.example.SK_Prj2_Rakic_Vasic.UserService.service.serviceImplementation;

import com.example.SK_Prj2_Rakic_Vasic.UserService.controller.helper.MessageHelper;
import com.example.SK_Prj2_Rakic_Vasic.UserService.domain.Role;
import com.example.SK_Prj2_Rakic_Vasic.UserService.domain.User;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.notification.ActivationEmailDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.users.UserCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.users.UserDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.exception.NotFoundException;
import com.example.SK_Prj2_Rakic_Vasic.UserService.mapper.UserMapper;
import com.example.SK_Prj2_Rakic_Vasic.UserService.repository.RoleRepository;
import com.example.SK_Prj2_Rakic_Vasic.UserService.repository.UserRepository;
import com.example.SK_Prj2_Rakic_Vasic.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class UserServiceImplementation implements UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;

    private String activationEmail;
    private String changePasswordEmail;
    private JmsTemplate jmsTemplate;
    private MessageHelper messageHelper;
    private final RoleRepository roleRepository;

    public UserServiceImplementation(UserRepository userRepository, UserMapper userMapper,
                                     @Value("${destination.activationEmail}") String activationEmail,
                                     @Value("${destination.changePassword}") String changePasswordEmail, JmsTemplate jmsTemplate, MessageHelper messageHelper,
                                     RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.activationEmail = activationEmail;
        this.changePasswordEmail = changePasswordEmail;
        this.jmsTemplate = jmsTemplate;
        this.messageHelper = messageHelper;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDto findById(Long id) {
        return userRepository.findById(id).map(userMapper::userToUserDto).orElseThrow(()-> new NotFoundException("User ciji je id:" + id + "nije pronadjen"));
    }

    @Override
    public List<UserDto> findAll() {
        List<UserDto> userDtos = new ArrayList<>();

        userRepository.findAll().forEach(manager -> {
            if(manager.getRole().getRoleName().equals("ROLE_USER"))
                userDtos.add(userMapper.userToUserDto(manager));
        });

        return userDtos;
    }

    @Override
    public UserDto add(UserCreateDto userCreateDto) {
        Role role = roleRepository.findRoleByRoleName("ROLE_USER").orElseThrow(() -> new NotFoundException("User with ROLE_USER has not been found"));

        User user = userMapper.userCreateDtoToUser(userCreateDto);
        user.setRole(role);

        userRepository.save(user);

        ActivationEmailDto activationEmailDto = new ActivationEmailDto();
        activationEmailDto.setFirstName(user.getFirstName());
        activationEmailDto.setLastName(user.getLastName());
        activationEmailDto.setEmail(user.getEmail());
        activationEmailDto.setLink(user.getActivatedAccount());


        jmsTemplate.convertAndSend(activationEmail,messageHelper.createTextMessage(activationEmailDto));
        return userMapper.userToUserDto(user);
    }

    @Override
    public Boolean delete(Long id) {
        User userToDelete = userRepository.findById(id).orElseThrow(()-> new NotFoundException("User ciji je id:" + id + "nije pronadjen"));

        userRepository.delete(userToDelete);
        return true;
    }

    @Override
    public UserDto update(UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).orElseThrow(()->new NotFoundException("User ciji je id:" + userDto.getId() + "nije pronadjen"));

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setTotalRentDuration(userDto.getTotalRentDuration());
        user.setPassport(userDto.getPassport());

        userRepository.save(user);
        return userDto;
    }
}
