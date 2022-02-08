package com.vti.academy;

public class BlockB extends Candidate {
			
		static final String MonToan = "Toan " ; 
		static final String MonHoa  = "Hoa";
		static final String MonSinh	 = "Sinh";

	
	
	public BlockB(int soBaoDanh, String hoTen, String diaChi, int mucUuTien) {
		super(soBaoDanh, hoTen, diaChi, mucUuTien);

	}
		@Override
		public String toString() {
		return "BlockB{" +
        "soBaoDanh='" + soBaoDanh + '\'' +
        ", hoTen='" + hoTen + '\'' +
        ", diaChi='" + diaChi + '\'' +
        ", mucUuTien=" + mucUuTien + ", Subject: " + MonToan + " - " + MonSinh + " - " + MonHoa +'}';
		}
}
