package com.example.SK_Prj2_Rakic_Vasic.NotificationService.dto.emailDto;

public class ReviewDto {
    private String email;
    private Integer grade;
    private String comment;

    public ReviewDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
