package main;

import java.io.Serializable;

public abstract class Pessoa implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private int idade;
	private char sexo;
	private Endereço end;
	
	Pessoa(String nome, int idade, char sexo, Endereço end)
	{
		this.idade = idade;
		this.nome = nome;
		this.sexo = sexo;
		this.end = end;
	}
	
	public String getNome()
	{
		return this.nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public int getIdade()
	{
		return this.idade;
	}
	
	public void setIdade(int idade)
	{
		this.idade = idade;
	}
	
	public char getSexo()
	{
		return this.sexo;
	}
	
	public void setSexo(char sexo)
	{
		this.sexo = sexo;
	}
	
	public Endereço getEnd()
	{
		return this.end;
	}
	
	public void setEnd(Endereço end)
	{
		this.end = end;
	}
}
