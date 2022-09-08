package main;

import java.io.Serializable;

public class Endereço implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String rua;
	private String comp;
	private String setor;
	private String cidade;
	
	Endereço(String rua, String comp, String setor, String cidade)
	{
		this.rua = rua;
		this.comp = comp;
		this.setor = setor;
		this.cidade = cidade;
	}
	
	public String getRua()
	{
		return this.rua;
	}
	
	public void setRua(String nome)
	{
		this.rua = nome;
	}
	
	public String getComp()
	{
		return this.comp;
	}
	
	public void setComp(String comp)
	{
		this.comp = comp;
	}
	
	public String getSetor()
	{
		return this.setor;
	}
	
	public void setSetor(String setor)
	{
		this.setor = setor;
	}
	
	public String getCidade()
	{
		return this.cidade;
	}
	
	public void setCidade(String cidade)
	{
		this.cidade = cidade;
	}
}
