package main;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Aluno extends Pessoa
{
	private static final long serialVersionUID = 1L;

	public static int al = 1;
	
	private int mat;
	private String fb;
	private ArrayList <Atividade> atividades = new ArrayList <Atividade>();
	
	Aluno(String nome, int idade, char sexo, Endereço end)
	{
		super(nome, idade, sexo, end);
		
		this.mat = al;
		al++;
	}
	
	public double calculaMens()
	{
		double mens = 0;
		
		for(int i = 0; i < atividades.size(); i++)
			mens += atividades.get(i).getCusto();
		
		return mens;
	}
	
	public int getMat()
	{
		return this.mat;
	}
	
	public String getFb()
	{
		return this.fb;
	}
	
	public void setFb(String fb)
	{
		this.fb = fb;
	}
	
	public void matAtividade(Atividade a)
	{
		atividades.add(a);
	}
	
	public void desmatAtividade(Atividade a)
	{
		atividades.remove(a);
	}
	
	public String toString()
	{
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("R$ #,##0.00");
		
		String a = "Nome: " + this.getNome() + "\n";
		
		a += "Idade: " + this.getIdade() + "\n";
		a += "Sexo: " + this.getSexo() + "\n";
		
		a += "\nEndereço: " + "\n";
		a += "Cidade: " + this.getEnd().getCidade() + "\n";
		a += "Setor: " + this.getEnd().getSetor() + "\n"; 
		a += "Rua: " + this.getEnd().getRua() + "\n";
		a += "Complemento: " + this.getEnd().getComp() + "\n";
		
		a += "\nParticipa das seguintes atividades: " + "\n";
		
		for(int i = 0; i < atividades.size(); i++)
				a += this.atividades.get(i).getNome() + "\n";
		
		a += "\nMensalidade: " + df.format(this.calculaMens()) + "\n";
		a += "Matrícula: " + this.getMat() + "\n";
		
		a += "FeedBack: " + this.getFb();
		
		return a;
	}
}
