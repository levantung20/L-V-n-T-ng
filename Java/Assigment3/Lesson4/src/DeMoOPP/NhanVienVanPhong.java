package DeMoOPP;

public class NhanVienVanPhong  implements IPerson , ISinhVat {

	@Override
	public void hoHap() {
	System.out.println("nhân viên  văn phòng đang thở bằng mũi");		
	}
	@Override
	public void diLam() {
		System.out.println("nhân viên đi làm văn phòng");
	}

	@Override
	public void diChoi() {
		System.out.println("nhân viên đi bar quẩy");
	}

	
	
}
