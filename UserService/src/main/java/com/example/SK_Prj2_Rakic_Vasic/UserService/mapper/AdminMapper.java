package com.example.SK_Prj2_Rakic_Vasic.UserService.mapper;

import com.example.SK_Prj2_Rakic_Vasic.UserService.domain.User;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.users.AdminCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.users.AdminDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.users.ManagerCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.repository.RoleRepository;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {
    private RoleRepository roleRepository;

    public AdminMapper(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public AdminDto adminToAdminDto(User admin){
        AdminDto adminDto = new AdminDto();

        adminDto.setId(admin.getId());
        adminDto.setEmail(admin.getEmail());
        adminDto.setUsername(admin.getUsername());
        adminDto.setPassword(admin.getPassword());
        adminDto.setFirstName(admin.getFirstName());
        adminDto.setLastName(admin.getLastName());
        adminDto.setPhoneNumber(admin.getPhoneNumber());

        return adminDto;
    }

    public User adminDtoToAdmin(AdminDto adminDto){
        User admin = new User();

        admin.setId(adminDto.getId());
        admin.setEmail(adminDto.getEmail());
        admin.setUsername(adminDto.getUsername());
        admin.setPassword(adminDto.getPassword());
        admin.setFirstName(adminDto.getFirstName());
        admin.setLastName(adminDto.getLastName());
        admin.setPhoneNumber(adminDto.getPhoneNumber());

        return admin;
    }

    public User adminCreateDtoToUser(AdminCreateDto adminCreateDto) {
        User admin = new User();
        admin.setEmail(adminCreateDto.getEmail());
        admin.setFirstName(adminCreateDto.getFirstName());
        admin.setLastName(adminCreateDto.getLastName());
        admin.setUsername(adminCreateDto.getUsername());
        admin.setPassword(adminCreateDto.getPassword());
        admin.setDateOfBirth(adminCreateDto.getDateOfBirth());
        admin.setPhoneNumber(adminCreateDto.getPhoneNumber());

        admin.setRole(roleRepository.findRoleByRoleName("ROLE_ADMIN").get());
        admin.setPassport(null);
        admin.setTotalRentDuration(null);
        admin.setCompanyName(null);
        admin.setDateOfEmployment(null);
        admin.setBanned(false);
        admin.setActivatedAccount(null);
        admin.setRank(null);

        return admin;
    }
}
