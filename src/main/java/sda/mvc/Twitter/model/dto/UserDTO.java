package sda.mvc.Twitter.model.dto;

import java.util.Date;

public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private Date joinDate;
    public UserDTO(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    public UserDTO() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getJoinDate() {
        return joinDate;
    }
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

}
