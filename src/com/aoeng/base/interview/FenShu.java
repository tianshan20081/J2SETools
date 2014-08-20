package com.aoeng.base.interview;

public class FenShu {
	private int fenZi;
	private int fenMu;

	public FenShu() {
		super();
	}

	public FenShu(int fenZi, int fenMu) {
		super();
		this.fenZi = fenZi;
		this.fenMu = fenMu;
	}

	public int getFenZi() {
		return fenZi;
	}

	public void setFenZi(int fenZi) {
		this.fenZi = fenZi;
	}

	public int getFenMu() {
		return fenMu;
	}

	public void setFenMu(int fenMu) {
		this.fenMu = fenMu;
	}

	@Override
	public String toString() {
		return "FenShu [fenZi=" + fenZi + "/" + fenMu + "]";
	}

	public static FenShu jia(FenShu f1, FenShu f2) {
		FenShu fs = new FenShu();

		int minGongBeiShu = minGongBeiShu(f1.getFenMu(), f2.getFenMu());
		int sum = f1.getFenZi() * (minGongBeiShu / f1.getFenMu()) + f2.getFenZi() * (minGongBeiShu / f2.getFenMu());
		fs.setFenZi(sum);
		fs.setFenMu(minGongBeiShu);
		fs = huajian(fs);
		return fs;
	}

	public static FenShu jian(FenShu f1, FenShu f2) {
		FenShu fs = new FenShu();

		int minGongBeiShu = minGongBeiShu(f1.getFenMu(), f2.getFenMu());
		int sum = f1.getFenZi() * (minGongBeiShu / f1.getFenMu()) - f2.getFenZi() * (minGongBeiShu / f2.getFenMu());
		fs.setFenZi(sum);
		fs.setFenMu(minGongBeiShu);
		return fs;
	}

	public static FenShu cheng(FenShu f1, FenShu f2) {
		FenShu fs = new FenShu();

		fs.setFenZi(f1.getFenZi() * f2.getFenZi());
		fs.setFenMu(f1.getFenMu() * f2.getFenMu());
		return fs;
	}

	public static FenShu chu(FenShu f1, FenShu f2) {
		FenShu fs = new FenShu();

		fs.setFenZi(f1.getFenZi() * f2.getFenMu());
		fs.setFenMu(f1.getFenMu() * f2.getFenZi());
		return fs;
	}

	private static FenShu huajian(FenShu f) {
		// TODO Auto-generated method stub
		int maxGongYueShu = maxGongYueShu(f);
		f.setFenZi(f.getFenZi() / maxGongYueShu);
		f.setFenMu(f.getFenMu() / maxGongYueShu);
		return f;
	}

	private static int maxGongYueShu(FenShu f) {
		// TODO Auto-generated method stub
		int t1 = f.getFenMu();
		int t2 = f.getFenZi();
		int n = t1 > t2 ? t2 : t1;
		int max = 1;
		for (int i = n; i > 1; i--) {
			if (f.getFenMu() % i == 0 && f.getFenZi() % i == 0) {
				max = i;
				break;
			}
		}
		return max;
	}

	private static int minGongBeiShu(int n1, int n2) {
		// TODO Auto-generated method stub
		int min = 1;
		int t = n1 > n2 ? n1 : n2;
		for (int i = t; i <= n1 * n2; i++) {
			if (i % n1 == 0 && i % n2 == 0) {
				min = i;
				break;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		FenShu f = new FenShu(6, 8);
		FenShu f2 = new FenShu(3, 5);
		FenShu f3 = jian(f, f2);
		System.out.println(f3.toString());
		f3 = huajian(f3);
		System.out.println(f3.toString());
		f3 = jia(f, f2);
		System.out.println(f3.toString());
		f3 = huajian(f3);
		System.out.println(f3.toString());
		f3 = cheng(f, f2);
		System.out.println(f3.toString());
		f3 = huajian(f3);
		System.out.println(f3.toString());
		f3 = chu(f, f2);
		System.out.println(f3.toString());
		f3 = huajian(f3);
		System.out.println(f3.toString());

	}

}
