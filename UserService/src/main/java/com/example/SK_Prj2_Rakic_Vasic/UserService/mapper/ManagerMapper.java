package com.example.SK_Prj2_Rakic_Vasic.UserService.mapper;


import com.example.SK_Prj2_Rakic_Vasic.UserService.domain.User;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.users.AdminCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.users.ManagerCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.users.ManagerDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.repository.RoleRepository;
import org.springframework.stereotype.Component;

@Component
public class ManagerMapper {

    private RoleRepository roleRepository;

    public ManagerMapper(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public ManagerDto managerToManagerDto(User manager){
        ManagerDto managerDto = new ManagerDto();

        managerDto.setId(manager.getId());
        managerDto.setEmail(manager.getEmail());
        managerDto.setUsername(manager.getUsername());
        managerDto.setPassword(manager.getPassword());
        managerDto.setFirstName(manager.getFirstName());
        managerDto.setLastName(manager.getLastName());
        managerDto.setDateOfBirth(manager.getDateOfBirth());
        managerDto.setPhoneNumber(manager.getPhoneNumber());
        managerDto.setCompanyName(manager.getCompanyName());
        managerDto.setDateOfEmployment(manager.getDateOfEmployment());

        return managerDto;
    }

    public User managerDtoToManager(ManagerDto managerDto){
        User manager = new User();

        manager.setId(managerDto.getId());
        manager.setEmail(managerDto.getEmail());
        manager.setUsername(managerDto.getUsername());
        manager.setPassword(managerDto.getPassword());
        manager.setFirstName(managerDto.getFirstName());
        manager.setLastName(managerDto.getLastName());
        manager.setDateOfBirth(managerDto.getDateOfBirth());
        manager.setPhoneNumber(managerDto.getPhoneNumber());
        manager.setCompanyName(managerDto.getCompanyName());
        manager.setDateOfEmployment(managerDto.getDateOfEmployment());

        return manager;
    }


    public User managerCreateDtoToUser(ManagerCreateDto managerCreateDto) {
        User manager = new User();
        manager.setEmail(managerCreateDto.getEmail());
        manager.setFirstName(managerCreateDto.getFirstName());
        manager.setLastName(managerCreateDto.getLastName());
        manager.setUsername(managerCreateDto.getUsername());
        manager.setPassword(managerCreateDto.getPassword());
        manager.setDateOfBirth(managerCreateDto.getDateOfBirth());
        manager.setPhoneNumber(managerCreateDto.getPhoneNumber());

        manager.setCompanyName(managerCreateDto.getCompanyName());
        manager.setDateOfEmployment(managerCreateDto.getDateOfEmployment());
        manager.setRole(roleRepository.findRoleByRoleName("ROLE_MANAGER").get());


        manager.setPassport(null);
        manager.setTotalRentDuration(null);
        manager.setBanned(false);
        manager.setActivatedAccount(null);
        manager.setRank(null);

        return manager;
    }

}
