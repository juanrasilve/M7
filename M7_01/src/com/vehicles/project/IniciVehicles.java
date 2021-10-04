package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class IniciVehicles {
	
	public static void main(String[] args) {
		
		String matricula="";
		String marca="";
		String color="";
		
		List<Wheel> wheels = new ArrayList<Wheel>();
		
		String marcaRodesTraseres="";
		double diametreRodesTraseres=0;
		String marcaRodesDevanteres="";
		double diametreRodesDevanteres=0;
		
		String tipusVehicle = "";
		System.out.println("Indiqui si vol un cotxe o una moto(A-Cotxe,B-Moto)");
		Scanner myObj1 = new Scanner(System.in);
		tipusVehicle = myObj1.nextLine().toUpperCase();
		while (!(tipusVehicle.equalsIgnoreCase("A") || tipusVehicle.equalsIgnoreCase("B"))){
			System.out.println("La respuesta no es correcta.Introduzca el tipo de vehiculo(A o B)");
			myObj1 = new Scanner(System.in);
			tipusVehicle = myObj1.nextLine().toUpperCase();
		}
		
		System.out.println("Indiqui la matricula del vehicle");
		myObj1 = new Scanner(System.in);
		matricula = myObj1.nextLine().toUpperCase();
		
		while (!Pattern.matches("^[0-9]{4}(?!.*(LL|CH))[BCDFGHJKLMNPRSTVWXYZ]{2,3}", matricula)) {
			System.out.println("La matricula no tiene el formato correcto.Introduzca la matricula de nuevo");
			myObj1 = new Scanner(System.in);
			matricula = myObj1.nextLine().toUpperCase();
		}
		
		System.out.println("Indiqui la marca");
		marca = myObj1.nextLine();

		System.out.println("Indiqui el color");
		color = myObj1.nextLine();
		
		Vehicle vehicle=null;
		if (tipusVehicle.equalsIgnoreCase("A")) {
			vehicle = new CrearCotxe(matricula,marca,color);
		}else if (tipusVehicle.equalsIgnoreCase("B")) {
			vehicle = new CrearMoto(matricula,marca,color);
		}
		System.out.println("Indiqui la marca de les rodes traseres");
		marcaRodesTraseres = myObj1.nextLine();
		
		System.out.println("Indiqui el diametre de les rodes traseres");
		diametreRodesTraseres = Double.parseDouble(myObj1.nextLine());
		
		while (!(diametreRodesTraseres>0.4 && diametreRodesTraseres<4)) {
			System.out.println("El diametro tiene que ser entre 0,4 y 4.Introduzca el diametro de nuevo");
			myObj1 = new Scanner(System.in);
			diametreRodesTraseres = Double.parseDouble(myObj1.nextLine());
		}
		
		//Afegir Rodes Traseres
		Wheel rodesTraseres = new Wheel(marcaRodesTraseres,diametreRodesTraseres);

		System.out.println("Indiqui la marca de les rodes devanteres");
		marcaRodesDevanteres = myObj1.nextLine();
		
		System.out.println("Indiqui el diametre de les rodes devanteres");
		diametreRodesDevanteres = Double.parseDouble(myObj1.nextLine());
		
		while (!(diametreRodesDevanteres>0.4 && diametreRodesDevanteres<4)) {
			System.out.println("El diametro tiene que ser entre 0,4 y 4.Introduzca el diametro de nuevo");
			myObj1 = new Scanner(System.in);
			diametreRodesDevanteres = Double.parseDouble(myObj1.nextLine());
		}
		myObj1.close();
		
		//Afegir Rodes Devanteres
		Wheel rodesDevanteres=new Wheel(marcaRodesDevanteres,diametreRodesDevanteres);
		
		wheels.add(rodesTraseres);
		wheels.add(rodesDevanteres);
		
		vehicle.setWheels(wheels);
		
	}
}
