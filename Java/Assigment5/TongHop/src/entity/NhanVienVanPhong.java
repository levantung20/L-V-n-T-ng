package entity;

public class NhanVienVanPhong implements IPerSon, ISinhVat {

	@Override
	public void hoHap() {
		System.out.println("đang thở");

	}

	@Override
	public void diLam() {
		System.out.println("nhân viên đi làm tại văn phòng");

	}

	@Override
	public void diChoi() {
		System.out.println("nhân viên đi quẩn ở quán bar, karaoke tay vịn ");
	}

}
