package com.hydrogen_infra_api_ver2.hydrogen_infra_api.Domain;


import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
@Entity
@Table(name = "Stations")
public class Stations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "station_name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "address_lat")
    private Double address_lat;
    @Column(name = "address_lng")
    private Double address_lng;

    @Column(name = "registration_number")
    private String regist_num;

    @Column(name = "group_number")
    private Long group;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "autharization_date")
    private Date autharization_date;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "start_date")
    private Date start_date;
    @Column(name = "district")
    private String district;
    @Column(name = "phoneNumber")
    private String phoneNumber;


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate
    @Column(name = "createdAt")
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @OneToMany(mappedBy = "station", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Equipments> equipments;

    public List<Equipments> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipments> equipments) {
        this.equipments = equipments;
    }



    public Long getGroup() {
        return group;
    }

    public void setGroup(Long group) {
        this.group = group;
    }

    public Date getAutharization_date() {
        return autharization_date;
    }

    public void setAutharization_date(Date autharization_date) {
        this.autharization_date = autharization_date;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getAddress_lat() {
        return address_lat;
    }

    public void setAddress_lat(Double address_lat) {
        this.address_lat = address_lat;
    }

    public Double getAddress_lng() {
        return address_lng;
    }

    public void setAddress_lng(Double address_lng) {
        this.address_lng = address_lng;
    }

    public String getRegist_num() {
        return regist_num;
    }

    public void setRegist_num(String regist_num) {
        this.regist_num = regist_num;
    }
}
