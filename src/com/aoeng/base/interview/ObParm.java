package com.aoeng.base.interview;

public class ObParm {

	public static void main(String[] args) {
		ObParm v1 = new ObParm();
		v1.amethoh();
	}

	private void amethoh() {
		// TODO Auto-generated method stub
		int i = 99 ;
		ValHoler v = new ValHoler();
		v.i = 30 ;
		another(v,i);
		System.out.println(v.i);
	}

	private void another(ValHoler v, int i) {
		// TODO Auto-generated method stub
		i = 0 ;
		v.i = 20 ;
		ValHoler vh = new ValHoler();
		v = vh ;
		System.out.println(v.i + " " + i);
	}
}
class ValHoler{
	int i = 10 ;
}
