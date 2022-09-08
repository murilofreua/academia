package main;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Nutricionista extends Pessoa implements Salário
{
	private static final long serialVersionUID = 1L;
	
	public static int n = 1;
	
	private int mat;
	private ArrayList <Aluno> alunos = new ArrayList <Aluno>();
	
	Nutricionista(String nome, int idade, char sexo, Endereço end)
	{
		super(nome, idade, sexo, end);
		
		this.mat = n;
		n++;
	}
	
	public double calculaSalario()
	{
		double salario = 400*alunos.size();
		
		return salario;
	}
	
	public int getMat()
	{
		return this.mat;
	}
	
	public void incluiAluno(Aluno a)
	{
		alunos.add(a);
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
		
		p += "\nAuxilia os seguintes alunos: " + "\n";
		
		for(int i = 0; i < alunos.size(); i++)
				p += this.alunos.get(i).getNome() + "\n";
		
		p += "\nSalário: " + df.format(this.calculaSalario()) + "\n";
		p += "Matrícula: " + this.getMat() + "\n";
		
		return p;
	}
}
