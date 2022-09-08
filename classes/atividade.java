package main;
import java.io.Serializable;
import java.util.ArrayList;

public class Atividade implements Serializable
{
	private static final long serialVersionUID = 1L;

	public static int at = 1;
	
	private int codigo;
	private String nome;
	private String hora;
	private float custo;
	private int qntdAlunosMax;
	private ArrayList <Professor> professores = new ArrayList <Professor>();
	
	Atividade(String nome, String hora, float custo)
	{
		this.custo = custo;
		this.hora = hora;
		this.nome = nome;
		this.codigo = at;
		at++;
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
	
	public String getHora()
	{
		return this.hora;
	}
	
	public void setHora(String hora)
	{
		this.hora = hora;
	}
	
	public float getCusto()
	{
		return this.custo;
	}
	
	public void setCusto(float custo)
	{
		this.custo = custo;
	}
	
	public int getQntdAlunosMax()
	{
		return this.qntdAlunosMax;
	}
	
	public void setQntdAlunos(int qntdAlunos)
	{
		this.qntdAlunosMax = qntdAlunos;
	}
	
	public void setProfessor(Professor p)
	{
		professores.add(p);
	}
	
	public String toString()
	{
		String a = "Nome: " + this.getNome() + "\n";
		
		a += "Horário: " + this.getHora() + "\n";
		a += "Custo: " + this.getCusto() + "\n";
		a += "Quantidade de Alunos: " + this.getQntdAlunosMax() + "\n";
		
		a += "Professores: " + "\n";
		
		for(int i = 0; i < professores.size(); i++)
				a += this.professores.get(i) + "\n";
		
		return a;
	}
}
