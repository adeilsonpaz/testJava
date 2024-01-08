package testJava;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entitite.Reserva;
import model.exception.ExceptionModel;

public class Aplication {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.println("Numero do Quarto: ");
			int numero = sc.nextInt();
			
			System.out.println("Data da entrada em (dd/MM/yyyy): ");
			Date entrada = sdf.parse(sc.next());
			System.out.println("Data da Saida em (dd/MM/yyyy): ");
			Date saida = sdf.parse(sc.next());
		
			Reserva reserva = new Reserva(numero, entrada, saida);
			System.out.println("Dados da RESERVA: " + reserva);
			
			System.out.println();
			System.out.println("ATUALIZAÇÂO DA DATA DA RESERVA: ");		
			System.out.println("Data da entrada em (dd/MM/yyyy): ");
			entrada = sdf.parse(sc.next());
			System.out.println("Data da Saida em (dd/MM/yyyy): ");
			saida = sdf.parse(sc.next());		
			
			reserva.updateData(entrada, saida);
			System.out.println("Dados atualizados da RESERVA: " + reserva);
		}
		catch(ParseException e) {
			System.out.println("DATA INAVALIDA!...");
		}
		catch(ExceptionModel e) {
			System.out.println("reserva INAVALIDA!..." + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("erro inesperado!...");
		}
	
		sc.close();

	}

}
