package com.nordclan.nikgapon.work_practice_1.dto;

import com.nordclan.nikgapon.work_practice_1.model.MeetingRoomEntity;

public class MeetingRoomDto {
    private Long id;
    private String name;
    private String description;

    public MeetingRoomDto(){}
    public MeetingRoomDto(MeetingRoomEntity meetingRoomEntity) {
        this.id = meetingRoomEntity.getId();
        this.name = meetingRoomEntity.getName();
        this.description = meetingRoomEntity.getDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
