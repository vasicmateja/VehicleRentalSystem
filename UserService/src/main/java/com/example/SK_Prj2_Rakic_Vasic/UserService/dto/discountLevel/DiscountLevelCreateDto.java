package com.example.SK_Prj2_Rakic_Vasic.UserService.dto.discountLevel;

public class DiscountLevelCreateDto {
    private String levelName;
    private Integer minResDaysNum;
    private Integer maxResDaysNum;
    private Integer discountProcentage;

    public DiscountLevelCreateDto() {

    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Integer getMinResDaysNum() {
        return minResDaysNum;
    }

    public void setMinResDaysNum(Integer minResDaysNum) {
        this.minResDaysNum = minResDaysNum;
    }

    public Integer getMaxResDaysNum() {
        return maxResDaysNum;
    }

    public void setMaxResDaysNum(Integer maxResDaysNum) {
        this.maxResDaysNum = maxResDaysNum;
    }

    public Integer getDiscountProcentage() {
        return discountProcentage;
    }

    public void setDiscountProcentage(Integer discountProcentage) {
        this.discountProcentage = discountProcentage;
    }
}
