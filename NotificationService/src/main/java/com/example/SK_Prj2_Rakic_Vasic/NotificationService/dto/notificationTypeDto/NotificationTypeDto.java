package com.example.SK_Prj2_Rakic_Vasic.NotificationService.dto.notificationTypeDto;



public class NotificationTypeDto {

    Long id;
    String typeName;

    public NotificationTypeDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
