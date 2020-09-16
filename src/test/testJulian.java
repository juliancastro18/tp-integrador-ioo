package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.RetiroLocal;

public class testJulian {

	public static void main(String[] args) {

		RetiroLocal rl = new RetiroLocal(0, LocalDate.of(2020, 8, 23), false, LocalTime.of(13, 31));
				
		System.out.println(rl);

	}

}
