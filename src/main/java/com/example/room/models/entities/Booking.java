package com.example.room.models.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "check_in")
    private Date checkIn;

    @Column(name = "check_out")
    private Date chechOut;

    @Column(name = "number_of_member")
    private Long numberOfMember;

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "room_id")
    private Long roomId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getChechOut() {
        return chechOut;
    }

    public void setChechOut(Date chechOut) {
        this.chechOut = chechOut;
    }

    public Long getNumberOfMember() {
        return numberOfMember;
    }

    public void setNumberOfMember(Long numberOfMember) {
        this.numberOfMember = numberOfMember;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
}
