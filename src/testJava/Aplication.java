package testJava;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entitite.Reserva;

public class Aplication {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Numero do Quarto: ");
		int numero = sc.nextInt();
		
		System.out.println("Data da entrada em (dd/MM/yyyy): ");
		Date entrada = sdf.parse(sc.next());
		System.out.println("Data da Saida em (dd/MM/yyyy): ");
		Date saida = sdf.parse(sc.next());
		if(!saida.after(entrada)) {
			System.out.println("Erro na reserva: A data da saida não pode ser anterior a data de entrada!!");
		}else {
			Reserva reserva = new Reserva(numero, entrada, saida);
			System.out.println("Dados da RESERVA: " + reserva);
			System.out.println();
			System.out.println("ATUALIZAÇÂO DA DATA DA RESERVA: ");
			
			System.out.println("Data da entrada em (dd/MM/yyyy): ");
			entrada = sdf.parse(sc.next());
			System.out.println("Data da Saida em (dd/MM/yyyy): ");
			saida = sdf.parse(sc.next());
			
			String erro = reserva.updateData(entrada, saida);
			if(erro != null) {
				System.out.println("Erro na RESERVA: " + erro);
			}else {
			System.out.println("Dados atualizados da RESERVA: " + reserva);
			}
		}
		sc.close();

	}

}
