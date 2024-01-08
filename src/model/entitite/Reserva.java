package model.entitite;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.ExceptionModel;

public class Reserva {
	private Integer quarto;
	private Date entrada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer quarto, Date entrada, Date saida) throws ExceptionModel {
		if(!saida.after(entrada)){
			throw new ExceptionModel ("Erro na reserva: A data da saida não pode ser anterior a data de entrada!!");
		}
		this.quarto = quarto;
		this.entrada = entrada;
		this.saida = saida;
	}

	public Integer getQuarto() {
		return quarto;
	}

	public void setQuarto(Integer quarto) {
		this.quarto = quarto;
	}

	public Date getEntrada() {
		return entrada;
	}

	public Date getSaida() {
		return saida;
	}

	public long duracao() {
		long diff = saida.getTime() - entrada.getTime();
		
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateData(Date entrada, Date saida) throws ExceptionModel {
		Date now = new Date();
		if(entrada.before(now) || saida.before(now)) {
			throw new ExceptionModel ("Erro na reserva: A data da saida não pode ser anterior a data de entrada!!");
		}else if(!saida.after(entrada)){
			throw new ExceptionModel ("Erro na reserva: A data da saida não pode ser anterior a data de entrada!!");
		}
		
		this.entrada = entrada;
		this.saida = saida;
	}
	
	@Override
	public String toString() {
		return "quarto: " + quarto + " , Data da Entrada: " + sdf.format(entrada) + " , Data da Saida: " + sdf.format(saida) + " , " + duracao() + " Noites";
	}
	
	
	
}
