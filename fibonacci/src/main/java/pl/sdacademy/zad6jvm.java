package pl.sdacademy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



public class zad6jvm {

	final static BigDecimal VAT = BigDecimal.valueOf(0.23);
	static List<BigDecimal> kwotaNetto = new ArrayList<>();
	private static final ArrayList<BigDecimal> bigDecimals = new ArrayList<>();
	static List<BigDecimal> kwotaVat = bigDecimals;


	public static void zmiany(BigDecimal kwota) {
		kwotaNetto.add(kwota.setScale(2, BigDecimal.ROUND_HALF_UP));
		kwotaVat.add(kwota.multiply(VAT).setScale(2, BigDecimal.ROUND_HALF_UP));
	}


	public static void main(String[] args) {
		int i = 0;
		while (true) {
			BigDecimal numer = BigDecimal.valueOf(i);
			zmiany(numer);
			i++;
		}

	}
}
