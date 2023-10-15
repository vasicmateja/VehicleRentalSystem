package com.example.SK_Prj2_Rakic_Vasic.UserService.mapper;

import com.example.SK_Prj2_Rakic_Vasic.UserService.domain.User;
import com.example.SK_Prj2_Rakic_Vasic.UserService.domain.UserDiscountLevel;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.users.UserCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.users.UserDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.repository.RoleRepository;
import com.example.SK_Prj2_Rakic_Vasic.UserService.repository.UserDiscountLevelRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class UserMapper {

    private RoleRepository roleRepository;
    private UserDiscountLevelRepository userDiscountLevelRepository;

    private DiscountLevelMapper discountLevelMapper;

    public UserMapper(RoleRepository roleRepository, UserDiscountLevelRepository userDiscountLevelRepository, DiscountLevelMapper discountLevelMapper) {
        this.roleRepository = roleRepository;
        this.userDiscountLevelRepository = userDiscountLevelRepository;
        this.discountLevelMapper = discountLevelMapper;
    }

    public UserDto userToUserDto(User user){
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPassport(user.getPassport());
        userDto.setDateOfBirth(user.getDateOfBirth());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setTotalRentDuration(user.getTotalRentDuration());

        return userDto;
    }

    public User userDtoToUser(UserDto userDto){
        User user = new User();

        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassport(userDto.getPassport());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setTotalRentDuration(userDto.getTotalRentDuration());

        return user;
    }


    public User userCreateDtoToUser(UserCreateDto userCreateDto) {
        User user = new User();
        user.setEmail(userCreateDto.getEmail());
        user.setFirstName(userCreateDto.getFirstName());
        user.setLastName(userCreateDto.getLastName());
        user.setUsername(userCreateDto.getUsername());
        user.setPassword(userCreateDto.getPassword());
        user.setDateOfBirth(userCreateDto.getDateOfBirth());
        user.setPhoneNumber(userCreateDto.getPhoneNumber());

        user.setPassport(userCreateDto.getPassport());
        user.setTotalRentDuration(0);
        user.setBanned(false);
        user.setRole(roleRepository.findRoleByRoleName("ROLE_USER").get());

        user.setCompanyName(null);
        user.setDateOfEmployment(null);

        UUID uuidObj = UUID.randomUUID();
        String link = uuidObj.toString().replaceAll("_","");
        user.setActivatedAccount(link);

        List<UserDiscountLevel> userStatusList = userDiscountLevelRepository.findAll();

        String rank = userStatusList.stream()
                .filter(userDiscountLevel -> userDiscountLevel.getMaxResDaysNum() >= user.getTotalRentDuration()
                        && userDiscountLevel.getMinResDaysNum() <= user.getTotalRentDuration())
                .findAny()
                .get()
                .getLevelName();
        user.setRank(rank);


        return user;
    }

}
