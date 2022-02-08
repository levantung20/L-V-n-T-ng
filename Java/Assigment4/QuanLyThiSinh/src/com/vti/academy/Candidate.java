package com.vti.academy;

public class Candidate {
	protected 	int soBaoDanh;
	protected	String hoTen;
	protected	String diaChi;
	protected	int mucUuTien;
	public Candidate(int soBaoDanh, String hoTen, String diaChi, int mucUuTien) {
		super();
		this.soBaoDanh = soBaoDanh;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.mucUuTien = mucUuTien;
	}
	
	public int getSoBaoDanh() {
		return soBaoDanh;
	}
	public void setSoBaoDanh(int soBaoDanh) {
		this.soBaoDanh = soBaoDanh;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public int getMucUuTien() {
		return mucUuTien;
	}
	public void setMucUuTien(int mucUuTien) {
		this.mucUuTien = mucUuTien;
	}
		
		
}
