package Rooms;

import java.util.Date;

public class Room implements Comparable {
    private int roomNo, periodOfStay, memberStaying;
    private String customerName, phoneNumber, city, nationality, roomType;
    private Date date;
    private double expense;

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPeriodOfStay(int periodOfStay) {
        this.periodOfStay = periodOfStay;
    }

    public int getPeriodOfStay() {
        return periodOfStay;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setMemberStaying(int memberStaying) {
        this.memberStaying = memberStaying;
    }

    public int getMemberStaying() {
        return memberStaying;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setExpense(double expense) {
        this.expense += expense;
    }

    public double getExpense() {
        return expense;
    }

    public String writeInFile(){
        return this.getRoomNo() + "\t"
                + this.getCustomerName() + "\t"
                + this.getPhoneNumber() + "\t"
                + this.getPeriodOfStay() + "\t"
                + this.getCity() + "\t"
                + this.getNationality() + "\t"
                + this.getMemberStaying() + "\t"
                + this.getDate() + "\t"
                + this.getRoomType() + "\t"
                + this.getExpense();
    }

    @Override
    public int compareTo(Object o) {
        int roomNo = ((Room) o).getRoomNo();

        return this.roomNo-roomNo;
    }
}
