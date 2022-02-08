package com.vti.Entity.Ex5;

public class KySu extends CanBo {
	public	String NganhDaoTao;

		public String getNganhDaoTao() {
			return NganhDaoTao;
		}

		public void setNganhDaoTao(String nganhDaoTao) {
			NganhDaoTao = nganhDaoTao;
		}
		
		@Override
		public String toString() {
		return super.toString() + " , nganhdaotao : " + this.NganhDaoTao;
		}
}
