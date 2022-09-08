package main;

import java.io.Serializable;

public class Equipamento implements Serializable
{
	private static final long serialVersionUID = 1L;

	public static int e = 1;
	
	private int codigo;
	private String nome;
	private float custo;
	
	Equipamento(String nome, float custo)
	{
		this.nome = nome;
		this.custo = custo;
		this.codigo = e;
		e++;
	}
	
	public int getCod()
	{
		return this.codigo;
	}
	
	public String getNome()
	{
		return this.nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public float getCusto()
	{
		return this.custo;
	}
	
	public void setCusto(float custo)
	{
		this.custo = custo;
	}
	
	public String toString()
	{
		String e = "Nome: " + this.getNome() + "\n";
		
		e += "Custo: " + this.getCusto() + "\n";
		
		return e;
	}
}
