package com.vti.academy;

public class BlockC  extends Candidate{
	
		static final String MonVan = "Van";
		static final String MonSu = "Su";
		static final String MonDia  = " Dia";

	public BlockC(int soBaoDanh, String hoTen, String diaChi, int mucUuTien) {
		super(soBaoDanh, hoTen, diaChi, mucUuTien);
	
	}

	@Override
	public String toString() {

	return "BlockC{" +
	        "soBaoDanh='" + soBaoDanh + '\'' +
	        ", hoTen='" + hoTen + '\'' +
	        ", diaChi='" + diaChi + '\'' +
	        ", mucUuTien=" + mucUuTien + ", Subject: " + MonVan + " - " + MonSu + " - " + MonDia +'}';
	}
}
