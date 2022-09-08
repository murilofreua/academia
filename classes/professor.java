package main;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Professor extends Pessoa implements Salário
{
	private static final long serialVersionUID = 1L;

	public static int p = 1;
	
	private int mat;
	private ArrayList <Equipamento> equips = new ArrayList <Equipamento>();
	private ArrayList <Atividade> atividades = new ArrayList <Atividade>();
	
	Professor(String nome, int idade, char sexo, Endereço end)
	{
		super(nome, idade, sexo, end);
		
		this.mat = p;
		p++;
	}
	
	public double calculaSalario()
	{
		double salario = 1500*atividades.size();
		
		return salario;
	}
	
	public int getMat()
	{
		return this.mat;
	}
	
	public void setEquipamento(Equipamento equip)
	{
		equips.add(equip);
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
		
		String p = "Nome: " + this.getNome() + "\n";
		
		p += "Idade: " + this.getIdade() + "\n";
		p += "Sexo: " + this.getSexo() + "\n";
		
		p += "\nEndereço: " + "\n";
		p += "Cidade: " + this.getEnd().getCidade() + "\n";
		p += "Setor: " + this.getEnd().getSetor() + "\n"; 
		p += "Rua: " + this.getEnd().getRua() + "\n";
		p += "Complemento: " + this.getEnd().getComp() + "\n";
		
		p += "\nLeciona as seguintes atividades: " + "\n";
		
		for(int i = 0; i < atividades.size(); i++)
				p += this.atividades.get(i).getNome() + "\n";
		
		p += "\nSalário: " + df.format(this.calculaSalario()) + "\n";
		p += "Matrícula: " + this.getMat() + "\n";
		
		return p;
	}
}
