package com.example.SK_Prj2_Rakic_Vasic.UserService.service.serviceImplementation;

import com.example.SK_Prj2_Rakic_Vasic.UserService.domain.User;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.users.ManagerCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.users.ManagerDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.exception.NotFoundException;
import com.example.SK_Prj2_Rakic_Vasic.UserService.mapper.ManagerMapper;
import com.example.SK_Prj2_Rakic_Vasic.UserService.repository.UserRepository;
import com.example.SK_Prj2_Rakic_Vasic.UserService.service.ManagerService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class ManagerServiceImplementation implements ManagerService {
    private UserRepository managerRepository;
    private ManagerMapper managerMapper;

    public ManagerServiceImplementation(UserRepository managerRepository, ManagerMapper managerMapper) {;
        this.managerRepository = managerRepository;
        this.managerMapper = managerMapper;
    }

    @Override
    public ManagerDto findById(Long id) {
        return managerRepository.findById(id).map(managerMapper::managerToManagerDto).orElseThrow(()-> new NotFoundException("Manager ciji je id:" + id + "nije pronadjen"));
    }

    @Override
    public List<ManagerDto> findAll() {
       List<ManagerDto> managerDtoList = new ArrayList<>();

      managerRepository.findAll().forEach(manager -> {
          if(manager.getRole().getRoleName().equals("ROLE_MANAGER"))
              managerDtoList.add(managerMapper.managerToManagerDto(manager));
      });

      return managerDtoList;
    }

    @Override
    public ManagerDto add(ManagerCreateDto managerCreateDto) {
        User manager = managerMapper.managerCreateDtoToUser(managerCreateDto);

        managerRepository.save(manager);
        return managerMapper.managerToManagerDto(manager);
    }

    @Override
    public Boolean delete(Long id) {
        User userToDelete = managerRepository.findById(id).orElseThrow(()-> new NotFoundException("Manager ciji je id:" + id + "nije pronadjen"));

        managerRepository.delete(userToDelete);
        return true;
    }

    @Override
    public ManagerDto update(ManagerDto managerDto) {
        User manager = managerRepository.findById(managerDto.getId()).orElseThrow(()->new NotFoundException("Manager ciji je id:" + managerDto.getId() + "nije pronadjen"));

        manager.setFirstName(managerDto.getFirstName());
        manager.setLastName(managerDto.getLastName());
        manager.setEmail(managerDto.getEmail());
        manager.setUsername(managerDto.getUsername());
        manager.setPassword(managerDto.getPassword());
        manager.setDateOfBirth(managerDto.getDateOfBirth());
        manager.setPhoneNumber(managerDto.getPhoneNumber());
        manager.setCompanyName(managerDto.getCompanyName());
        manager.setDateOfEmployment(managerDto.getDateOfEmployment());



        managerRepository.save(manager);
        return managerDto;
    }
}
