package com.example.SK_Prj2_Rakic_Vasic.UserService.controller;

import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.discountLevel.DiscountLevelCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.discountLevel.DiscountLevelDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.users.AdminDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.users.UserDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.repository.UserRepository;
import com.example.SK_Prj2_Rakic_Vasic.UserService.security.CheckSecurity;
import com.example.SK_Prj2_Rakic_Vasic.UserService.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/admin")
public class AdminServiceController {

   private AdminService adminService;

    public AdminServiceController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/findById/{id}")
   // @CheckSecurity(roles = {"USER_ADMIN"})
    public ResponseEntity<AdminDto> findById(@RequestHeader("authorization") String authorization, @PathVariable("id") Long id) {
        return new ResponseEntity<>(adminService.findById(id), HttpStatus.OK);
    }

    // ------------------------

    @PutMapping("/update")
   // @CheckSecurity(roles = {"USER_ADMIN"})
    public ResponseEntity<AdminDto> update(@RequestHeader("authorization") String authorization,@RequestBody AdminDto adminDto) {
        return new ResponseEntity<>(adminService.update(adminDto), HttpStatus.OK);
    }

    // ------------------------

    @PostMapping("/banUser/{id}")
  //  @CheckSecurity(roles = {"USER_ADMIN"})
    public ResponseEntity<Boolean> ban(@RequestHeader("authorization") String authorization,@PathVariable("id") Long id) {
        return new ResponseEntity<>(adminService.ban(id), HttpStatus.OK);
    }

    @PostMapping("/addNewDiscountLevel")
    public ResponseEntity<DiscountLevelDto> addNewDiscountLevel(@RequestHeader("authorization") String authorization, @RequestBody DiscountLevelCreateDto discountLevelCreateDto) {
        System.out.println(discountLevelCreateDto.getLevelName());
        return new ResponseEntity<>(adminService.addNewDiscountLevel(discountLevelCreateDto), HttpStatus.OK);
    }
}
