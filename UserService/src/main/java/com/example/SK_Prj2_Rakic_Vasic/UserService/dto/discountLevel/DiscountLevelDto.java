
package com.example.SK_Prj2_Rakic_Vasic.UserService.dto.discountLevel;

public class DiscountLevelDto {
    private Long id;
    private String levelName;

    private Integer minResDaysNum;
    private Integer maxResDaysNum;
    private Integer discountProcentage;

    public DiscountLevelDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
