package entitye;

public class CanBo {
	public	String hoTen;
	public	int tuoi;
	public	Gender gioiTinh;
	public	String diaChi;
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public Gender getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(Gender gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
		
		@Override
		public String toString() {
			return " hoTen: "  + this.hoTen  +  " tuoi: " + this.tuoi +  " Dia chi: " + this.diaChi +  " gioi tinh: " + this.gioiTinh ;
		}
		
}
