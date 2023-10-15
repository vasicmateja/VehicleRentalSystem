package com.example.SK_Prj2_Rakic_Vasic.UserService.service.serviceImplementation;

import com.example.SK_Prj2_Rakic_Vasic.UserService.domain.User;
import com.example.SK_Prj2_Rakic_Vasic.UserService.domain.UserDiscountLevel;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.discountLevel.DiscountLevelCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.discountLevel.DiscountLevelDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.users.AdminDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.exception.NotFoundException;
import com.example.SK_Prj2_Rakic_Vasic.UserService.mapper.AdminMapper;
import com.example.SK_Prj2_Rakic_Vasic.UserService.mapper.DiscountLevelMapper;
import com.example.SK_Prj2_Rakic_Vasic.UserService.repository.UserDiscountLevelRepository;
import com.example.SK_Prj2_Rakic_Vasic.UserService.repository.UserRepository;
import com.example.SK_Prj2_Rakic_Vasic.UserService.service.AdminService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdminServiceImplementation implements AdminService {
    private UserRepository adminRepository;
    private UserDiscountLevelRepository userDiscountLevelRepository;
    private AdminMapper adminMapper;
    private DiscountLevelMapper discountLevelMapper;

    public AdminServiceImplementation(UserRepository adminRepository, UserDiscountLevelRepository userDiscountLevelRepository, AdminMapper adminMapper, DiscountLevelMapper discountLevelMapper) {
        this.adminRepository = adminRepository;
        this.userDiscountLevelRepository = userDiscountLevelRepository;
        this.adminMapper = adminMapper;
        this.discountLevelMapper = discountLevelMapper;
    }

    @Override
    public AdminDto findById(Long id) {
        return adminRepository.findById(id).map(adminMapper::adminToAdminDto).orElseThrow(()-> new NotFoundException("Admin ciji je id:" + id + "nije pronadjen"));
    }

    @Override
    public AdminDto update(AdminDto adminDto) {
        User admin = adminRepository.findById(adminDto.getId()).orElseThrow(()->new NotFoundException("Admin ciji je id:" + adminDto.getId() + "nije pronadjen"));

        admin.setFirstName(adminDto.getFirstName());
        admin.setLastName(adminDto.getLastName());
        admin.setEmail(adminDto.getEmail());
        admin.setUsername(adminDto.getUsername());
        admin.setPassword(adminDto.getPassword());
        admin.setPhoneNumber(adminDto.getPhoneNumber());
        admin.setDateOfBirth(adminDto.getDateOfBirth());



        adminRepository.save(admin);
        return adminDto;
    }

    @Override
    public Boolean ban(Long id) {
        User bannedUser = adminRepository.findById(id).orElseThrow(()->new NotFoundException("User ciji je id:" + id + "nije pronadjen"));

        bannedUser.setBanned(true);
        adminRepository.save(bannedUser);
        return true;
    }

    @Override
    public DiscountLevelDto addNewDiscountLevel(DiscountLevelCreateDto discountLevelCreateDto) {
        UserDiscountLevel userDiscountLevel = discountLevelMapper.discountLevelCreateDtoToUserDiscountLevel(discountLevelCreateDto);

        System.out.println("Print!!" + userDiscountLevel.getId() + userDiscountLevel.getMinResDaysNum() + userDiscountLevel.getLevelName());



        //TODO OVDE PUCA
        userDiscountLevelRepository.save(userDiscountLevel);



        return discountLevelMapper.discountLevelToDiscountLevelDto(userDiscountLevel);
    }
}
