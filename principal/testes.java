package main;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

public class Testes
{
	Endereço E1 = new Endereço("4", "Número 23", "Bueno", "Goiânia");
	Endereço E2 = new Endereço("T-9", "Número 123", "Aeroporto", "Goiânia");
	Endereço E3 = new Endereço("Araras", "Quadra B29", "Coimbra", "Goiânia");
	Endereço E4 = new Endereço("T-63", "Lote 2", "Pedro Ludovico", "Goiânia");
	
	Atividade AT1 = new Atividade("Luta", "19:00", 85);
	Atividade AT2 = new Atividade("Dança", "16:00", 65);
	Atividade AT3 = new Atividade("Corrida", "09:00", 70);
	Atividade AT4 = new Atividade("Musculação", "17:00", 90);
	
	Aluno A1 = new Aluno("Maria", 20, 'F', E3);
	Aluno A2 = new Aluno("Felipe", 18, 'M', E4);
	
	@Test
	public void testSalario1()
	{
		Professor P1 = new Professor("Mauro", 42, 'M', E1);
		
		P1.matAtividade(AT3);
		P1.matAtividade(AT4);
		
		assertEquals(3000, P1.calculaSalario(), 1);
		
		System.out.println("Passou no teste do salario 1!");
	}
	
	@Test
	public void testSalario2()
	{
		Nutricionista N1 = new Nutricionista("Amanda", 32, 'F', E2);
		
		N1.incluiAluno(A1);
		N1.incluiAluno(A2);
		
		assertEquals(800, N1.calculaSalario(), 1);
		
		System.out.println("Passou no teste do salario 2!");
	}
	
	@Test
	public void testMensalidade()
	{
		A1.matAtividade(AT1);
		A1.matAtividade(AT2);
		A1.matAtividade(AT3);
		A1.matAtividade(AT4);
		
		assertEquals(310, A1.calculaMens(), 1);
		
		System.out.println("Passou no teste da mensalidade!");
	}

	@BeforeClass
	public static void inicializaClass()
	{
		System.out.println("Serie de testes:");
	}
	
	@AfterClass
	public static void finalizaClass()
	{
		System.out.println("Finalizada!");
	}
}
