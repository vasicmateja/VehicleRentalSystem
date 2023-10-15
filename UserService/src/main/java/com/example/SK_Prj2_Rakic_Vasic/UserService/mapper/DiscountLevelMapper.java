package com.example.SK_Prj2_Rakic_Vasic.UserService.mapper;

import com.example.SK_Prj2_Rakic_Vasic.UserService.domain.UserDiscountLevel;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.discountLevel.DiscountLevelCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.discountLevel.DiscountLevelDto;
import org.springframework.stereotype.Component;

@Component
public class DiscountLevelMapper {

    public DiscountLevelMapper() {
    }

    public DiscountLevelDto discountLevelToDiscountLevelDto(UserDiscountLevel discountLevel){
        DiscountLevelDto discountLevelDto = new DiscountLevelDto();

        discountLevelDto.setId(discountLevel.getId());
        discountLevelDto.setLevelName(discountLevel.getLevelName());
        discountLevelDto.setMinResDaysNum(discountLevel.getMinResDaysNum());
        discountLevelDto.setMaxResDaysNum(discountLevel.getMaxResDaysNum());
        discountLevelDto.setDiscountProcentage(discountLevel.getDiscountProcentage());

        return discountLevelDto;
    }

    public UserDiscountLevel discountLevelCreateDtoToUserDiscountLevel(DiscountLevelCreateDto discountLevelCreateDto) {
        UserDiscountLevel userDiscountLevel = new UserDiscountLevel();

        userDiscountLevel.setDiscountProcentage(discountLevelCreateDto.getDiscountProcentage());
        userDiscountLevel.setLevelName(discountLevelCreateDto.getLevelName());
        userDiscountLevel.setMaxResDaysNum(discountLevelCreateDto.getMaxResDaysNum());
        userDiscountLevel.setMinResDaysNum(discountLevelCreateDto.getMinResDaysNum());

        return userDiscountLevel;
    }

}
