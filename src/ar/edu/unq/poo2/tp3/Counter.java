package ar.edu.unq.poo2.tp3;

import java.util.List;

public class Counter {
	private List <Integer> contador; ;
	
	public Counter(List<Integer> contador) {
	    this.contador = contador;
	}
	public void agregarNumero(int numero) {
	    contador.add(numero);
	}


	public int cantidadPares() {
		int pares=0;
		for (Integer num:contador) {
			if (num % 2 == 0) {
				++pares;
			}
		}
		return pares;
	}
	public int cantidadImpares() {
		int impares=0;
		for (Integer num:contador) {
			if (num % 2 != 0) {
				++impares;
			}
		}
		return impares;
	}
	
	public int cantidadMultiplosDe(int divisor) {
		int multiplos=0;
		for (Integer num:contador) {
			if (num % divisor == 0) {
				++multiplos;
			}
		}
		return multiplos;
		
	}
//	public int getMayorCantEnteros() {
//		int mayor= contador.get(0);
//		for (int i=1; i<=contador.size();i++) {
//			if (this.tieneMasCantEnteros(mayor,i)) {
//				mayor=contador.get(i);
//			}
//		}
//		return mayor;
//	}
//	private int tieneMasCantEnteros(int n1, int n2) {
//		
//	}
//	public int getMayor() {
//		if (contador.isEmpty()){
//	        throw new IllegalArgumentException("El contador esta vacio");
//	    } else {
//	        return tieneMasCantEnteros() perteneceAux (++i,c,s);
//	    }
//	}
//	Realice una función que reciba dos valores X e Y, y devuelva el número más alto entre 0 y 1000, que sea
//	múltiplo simultáneamente de X e Y. Si no existe, devolver -1. Por ejemplo si se ingresa 3 y 9, la función debe
//	devolver 999.
	public int multiploMax(int x, int y) {
	    int mcm = (x * y) / mcd(x, y);
	    int maxMultiplo = (1000 / mcm) * mcm; 

	    return maxMultiplo > 0 ? maxMultiplo : -1;
	}

	private int mcd(int a, int b) {
	    return b == 0 ? a : mcd(b, a % b);
	}
	private boolean esMultiplo(int n1, int n2) {
	    return (n1 % n2) == 0;
	}

}
