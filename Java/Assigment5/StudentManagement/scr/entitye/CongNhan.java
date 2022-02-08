package entitye;

public class CongNhan extends CanBo {
	public String capBac;

	public String getCapBac() {
		return capBac;
	}

	public void setCapBac(String capBac) {
		this.capBac = capBac;
	}

	@Override
	public String toString() {
		return super.toString() + " cap Bac " + this.capBac;
	}

}
