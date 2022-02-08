package com.vti.academy;

public class BlockA extends Candidate {
			static final String MonToan = "Toan";
			static final String MonLy = "Ly";
			static final String MonHoa = "Hoa";
		
		
		public BlockA(int soBaoDanh, String hoTen, String diaChi, int mucUuTien) {
		super(soBaoDanh, hoTen, diaChi, mucUuTien);

	}
		@Override
		public String toString() {
			
		return "BlockA{" +
                "soBaoDanh='" + soBaoDanh + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", mucUuTien=" + mucUuTien + ", Subject: " + MonToan + " - " + MonLy + " - " + MonHoa +'}';

		}
			
}
