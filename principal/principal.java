package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import java.text.DecimalFormat;

public class Principal
{
	@SuppressWarnings("unchecked")
	
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("R$ #,##0.00");
		
		// declaração de variáveis
		
		int i = 0, j = 0, k = 0, m = 0;
		int aux, aux2, op = 1, idade;
		char tipo, sexo;
		String nomeEquip, nomeAtiv, nome, nomeNutri, rua, comp, setor, cidade, s;
		
		// -------------------------------------------------------------
		
		// leitura das listas de objetos a partir do arquivo
		
		ArrayList <Aluno> alunos = new ArrayList <Aluno>();
		ArrayList <Nutricionista> nutricionistas = new ArrayList <Nutricionista>();
		ArrayList <Professor> professores = new ArrayList <Professor>();
		ArrayList <Atividade> atividades = new ArrayList <Atividade>();
		ArrayList <Equipamento> equipamentos = new ArrayList <Equipamento>();
		
		try
		{
			InputStream isAlunos = new FileInputStream("alunos.txt");
			ObjectInputStream oisAlunos = new ObjectInputStream(isAlunos);
			
			alunos = (ArrayList <Aluno>)oisAlunos.readObject();
			oisAlunos.close();
		}
		catch (IOException e)
		{
			
		}
		catch (ClassNotFoundException e)
		{
			
		}
		
		try
		{
			InputStream isNutris = new FileInputStream("nutricionistas.txt");
			ObjectInputStream oisNutris = new ObjectInputStream(isNutris);
			
			nutricionistas = (ArrayList <Nutricionista>)oisNutris.readObject();
			oisNutris.close();
		}
		catch (FileNotFoundException e)
		{
			
		}
		catch (IOException e)
		{
			
		}
		catch (ClassNotFoundException e)
		{
			
		}
		
		try
		{
			InputStream isProfs = new FileInputStream("professores.txt");
			ObjectInputStream oisProfs = new ObjectInputStream(isProfs);
			
			professores = (ArrayList <Professor>)oisProfs.readObject();
			oisProfs.close();
		}
		catch (FileNotFoundException e)
		{
			
		}
		catch (IOException e)
		{
			
		}
		catch (ClassNotFoundException e)
		{
			
		}
		
		// -------------------------------------------------------------
		
		// criação da academia
		
		Equipamento hal = new Equipamento("Halteres", 40);
		Equipamento sup = new Equipamento("Supino", 140);
		Equipamento stp = new Equipamento("Step", 70);
		Equipamento col = new Equipamento("Colchonete", 30);
		Equipamento est = new Equipamento("Esteira", 400);
		Equipamento bic = new Equipamento("Bicicleta", 280);
		
		String menuEquip = "                     EQUIPAMENTOS DISPONÍVEIS" + "\n************************************************************";
		menuEquip += "\nHalteres\nSupino\nStep\nColchonete\nEsteira\nBicicleta";
		menuEquip += "\n************************************************************";
		
		equipamentos.addAll(Arrays.asList(hal, sup, stp, col, est, bic));
		
		Atividade dan = new Atividade("Dança", "18:00", 85);
		Atividade tre = new Atividade("Treino aeróbico", "8:00", 65);
		Atividade iog = new Atividade("Ioga", "17:00", 100);
		Atividade nat = new Atividade("Natação", "9:00", 95);
		Atividade mus = new Atividade("Musculação", "19:00", 90);
		Atividade mut = new Atividade("Muay Thai", "15:00", 110);
		Atividade jij = new Atividade("Jiu Jitsu", "13:00", 120);
		
		String menuAtiv = "                      ATIVIDADES DISPONÍVEIS" + "\n************************************************************";
		menuAtiv += "\nDança\nTreino Aeróbico\nIoga\nNatação\nMusculação\nMuay Thai\nJiu Jitsu";
		menuAtiv += "\n************************************************************";
		
		atividades.addAll(Arrays.asList(dan, tre, iog, nat, mus, mut, jij));
		
		for(i = 0; i < atividades.size(); i++)
			atividades.get(i).setQntdAlunos(40);
		
		// -------------------------------------------------------------
		
		// menu
		
		String menu = "   BEM-VINDO À ACADEMIA ORIENTADA A OBJETOS!" + "\n************************************************************";
		
		menu += "\nSelecione uma opção:\n";
		menu += "\n1-  Matricular aluno";
		menu += "\n2-  Desmatricular aluno";
		menu += "\n3-  Contratar novo profissional";
		menu += "\n4-  Demitir um profissional";
		menu += "\n5-  Relacionar um aluno a um nutricionista";
		menu += "\n6-  Exibir lista de alunos";
		menu += "\n7-  Exibir lista de profissionais";
		menu += "\n8-  Exibir lista de atividades disponíveis";
		menu += "\n9-  Verificar se um aluno está matriculado";
		menu += "\n10- Consultar o salário de um profissional";
		menu += "\n11- Alterar feedback";
		menu += "\n12- Alterar a quantidade máxima de alunos";
		
		menu += "\n\n13- Salvar";
		
		menu += "\n\n 0-  Sair do sistema";
		
		menu += "\n************************************************************";
		
		// -------------------------------------------------------------
		
		// switch
				
		while(op > 0)
		{
			try
			{
				JOptionPane.showMessageDialog(null, menu);
				s = JOptionPane.showInputDialog(null, "Opção:");
				op = Integer.parseInt(s);
				
				switch(op)
				{
					case 1:
					{
						nome = JOptionPane.showInputDialog(null, "Nome:");
						
						s = JOptionPane.showInputDialog(null, "Idade:");
						idade = Integer.parseInt(s);
						
						s = JOptionPane.showInputDialog(null, "Sexo:");
						sexo = s.charAt(0);
						
						rua = JOptionPane.showInputDialog(null, "- Endereço\n\nRua:");
						comp = JOptionPane.showInputDialog(null, "- Endereço\n\nComplemento:");
						setor = JOptionPane.showInputDialog(null, "- Endereço\n\nSetor:");
						cidade = JOptionPane.showInputDialog(null, "- Endereço\n\nCidade:");
						
						s = JOptionPane.showInputDialog(null, "Quantidade de atividades:");
						aux = Integer.parseInt(s);
						
						Endereço E1 = new Endereço(rua, comp, setor, cidade);
						Aluno A = new Aluno(nome, idade, sexo, E1);
						
						for(i = 0; i < aux; i++)
						{
							JOptionPane.showMessageDialog(null, menuAtiv);
							nomeAtiv = JOptionPane.showInputDialog(null, "Nome da atividade " + (i + 1) + ":");
							
							for(j = 0; j < atividades.size(); j++)
							{
								if(atividades.get(j).getNome().equals(nomeAtiv))
									A.matAtividade(atividades.get(j));
							}
						}
						
						alunos.add(A);
						
						JOptionPane.showMessageDialog(null, "Aluno matriculado com sucesso!");
						
						break;
					}
					
					case 2:
					{
						nome = JOptionPane.showInputDialog(null, "Nome do aluno a ser desmatriculado:");
						
						for(i = 0; i < alunos.size(); i++)
						{
							if(alunos.get(i).getNome().equals(nome))
							{
								alunos.remove(i);
								JOptionPane.showMessageDialog(null, "Aluno desmatriculado com sucesso!");
							}
						}
						
						break;
					}
					
					case 3:
					{
						s = JOptionPane.showInputDialog(null, "Digite 'P' para professor ou 'N' para nutricionista:");
						tipo = s.charAt(0);
						
						nome = JOptionPane.showInputDialog(null, "Nome:");
						
						s = JOptionPane.showInputDialog(null, "Idade:");
						idade = Integer.parseInt(s);
						
						s = JOptionPane.showInputDialog(null, "Sexo:");
						sexo = s.charAt(0);
						
						rua = JOptionPane.showInputDialog(null, "- Endereço\n\nRua:");
						comp = JOptionPane.showInputDialog(null, "- Endereço\n\nComplemento:");
						setor = JOptionPane.showInputDialog(null, "- Endereço\n\nSetor:");
						cidade = JOptionPane.showInputDialog(null, "- Endereço\n\nCidade:");
						
						Endereço E2 = new Endereço(rua, comp, setor, cidade);
						
						if(tipo == 'P')
						{
							Professor P = new Professor(nome, idade, sexo, E2);
							
							s = JOptionPane.showInputDialog(null, "Quantidade de atividades:");
							aux = Integer.parseInt(s);
							
							for(i = 0; i < aux; i++)
							{
								JOptionPane.showMessageDialog(null, menuAtiv);
								nomeAtiv = JOptionPane.showInputDialog(null, "Nome da atividade " + (i + 1) + ":");
								
								if(nomeAtiv.equals("Musculação"))
								{
									s = JOptionPane.showInputDialog(null, "Quantidade de equipamentos:");
									aux2 = Integer.parseInt(s);
									
									for(k = 0; k < aux2; k++)
									{
										JOptionPane.showMessageDialog(null, menuEquip);
										nomeEquip = JOptionPane.showInputDialog(null, "Nome do equipamento " + (k + 1) + ":");
										
										for(m = 0; m < equipamentos.size(); m++)
										{
											if(equipamentos.get(m).getNome().equals(nomeEquip))
												P.setEquipamento(equipamentos.get(m));
										}
									}
								}
								
								for(j = 0; j < atividades.size(); j++)
								{
									if(atividades.get(j).getNome().equals(nomeAtiv))
										P.matAtividade(atividades.get(j));
								}
							}
							
							professores.add(P);
							JOptionPane.showMessageDialog(null, "Professor contratado com sucesso!");
						}
						else
						{
							Nutricionista N = new Nutricionista(nome, idade, sexo, E2);
							nutricionistas.add(N);
							JOptionPane.showMessageDialog(null, "Nutricionista contratado com sucesso!");
						}
						
						break;
					}
					
					case 4:
					{
						aux = 0;
						nome = JOptionPane.showInputDialog(null, "Nome do profissional a ser desmatriculado:");
						
						for(i = 0; i < professores.size(); i++)
						{
							if(professores.get(i).getNome().equals(nome))
							{
								professores.remove(i);
								aux = 1;
							}
						}
						
						for(i = 0; i < nutricionistas.size(); i++)
						{
							if(nutricionistas.get(i).getNome().equals(nome))
							{
								nutricionistas.remove(i);
								aux = 1;
							}
						}
						
						if(aux == 1)
							JOptionPane.showMessageDialog(null, "Profissional demitido com sucesso!");
						else
							JOptionPane.showMessageDialog(null, "Profissional não encontrado!");
						
						break;
					}
					
					case 5:
					{
						nome = JOptionPane.showInputDialog(null, "Nome do aluno:");
						nomeNutri = JOptionPane.showInputDialog(null, "Nome do nutricionista:");
						
						for(i = 0; i < nutricionistas.size(); i++)
						{
							if(nutricionistas.get(i).getNome().equals(nomeNutri))
							{
								for(j = 0; j < alunos.size(); j++)
								{
									if(alunos.get(j).getNome().equals(nome))
										nutricionistas.get(i).incluiAluno(alunos.get(j));
								}
							}
						}
						
						JOptionPane.showMessageDialog(null, "Sucesso!");
						
						break;
					}
					
					case 6:
					{
						JOptionPane.showMessageDialog(null, "---------- LISTA DE ALUNOS ----------");
						
						for(i = 0; i < alunos.size(); i++)
							JOptionPane.showMessageDialog(null, alunos.get(i).toString());
						
						break;
					}
					
					case 7:
					{
						JOptionPane.showMessageDialog(null, "---------- LISTA DE PROFESSORES ----------");
						
						for(i = 0; i < professores.size(); i++)
							JOptionPane.showMessageDialog(null, professores.get(i).toString());
						
						JOptionPane.showMessageDialog(null, "---------- LISTA DE NUTRICIONISTAS ----------");
						
						for(i = 0; i < nutricionistas.size(); i++)
							JOptionPane.showMessageDialog(null, nutricionistas.get(i).toString());
						
						break;
					}
					
					case 8:
					{
						JOptionPane.showMessageDialog(null, menuAtiv);
						
						break;
					}
					
					case 9:
					{
						nome = JOptionPane.showInputDialog(null, "Nome do aluno:");
						
						for(i = 0; i < alunos.size(); i++)
						{
							if(alunos.get(i).getNome().equals(nome))
							{
								JOptionPane.showMessageDialog(null, "Aluno matriculado!");
								break;
							}
						}
						
						if(i == alunos.size())
							JOptionPane.showMessageDialog(null, "Aluno não está matriculado!");
						
						break;
					}
					
					case 10:
					{
						aux = 0;
						nome = JOptionPane.showInputDialog(null, "Nome do profissional:");
						
						for(i = 0; i < professores.size(); i++)
						{
							if(professores.get(i).getNome().equals(nome))
							{
								JOptionPane.showMessageDialog(null, "Salário = " + df.format(professores.get(i).calculaSalario()));
								aux = 1;
							}
						}
						
						for(i = 0; i < nutricionistas.size(); i++)
						{
							if(nutricionistas.get(i).getNome().equals(nome))
							{
								JOptionPane.showMessageDialog(null, "Salário = " + df.format(nutricionistas.get(i).calculaSalario()));
								aux = 1;
							}
						}
						
						if(aux == 0)
							JOptionPane.showMessageDialog(null, "Profissional não encontrado!");
						
						break;
					}
					
					case 11:
					{
						aux = 1;
						nome = JOptionPane.showInputDialog(null, "Nome do aluno:");
						
						for(i = 0; i < alunos.size(); i++)
						{
							if(alunos.get(i).getNome().equals(nome))
							{
								alunos.get(i).setFb(JOptionPane.showInputDialog(null, "Insira um comentário ou crítica sobre a sua experiência na academia:"));
								aux = 0;
							}
						}
						
						if(aux == 0)
							JOptionPane.showMessageDialog(null, "Sucesso!");
						else
							JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
						
						break;
					}
					
					case 12:
					{
						aux = 1;
						nome = JOptionPane.showInputDialog(null, "Nome da atividade:");
						
						for(i = 0; i < atividades.size(); i++)
						{
							if(atividades.get(i).getNome().equals(nome))
							{
								s = JOptionPane.showInputDialog(null, "Insira a nova quantidade de alunos:");
								aux2 = Integer.parseInt(s);
								atividades.get(i).setQntdAlunos(aux2);
								
								aux = 0;
							}
						}
						
						if(aux == 0)
							JOptionPane.showMessageDialog(null, "Sucesso!");
						else
							JOptionPane.showMessageDialog(null, "Atividade inexistente!");
						
						break;
					}
					
					case 13:
					{	
						// para escrever as listas de objetos nos arquivos
						
						OutputStream osAlunos = new FileOutputStream("alunos.txt");
						ObjectOutputStream oosAlunos = new ObjectOutputStream(osAlunos);
						
						oosAlunos.writeObject(alunos);
						oosAlunos.close();
						
						OutputStream osProfs = new FileOutputStream("professores.txt");
						ObjectOutputStream oosProfs = new ObjectOutputStream(osProfs);
						
						oosProfs.writeObject(professores);
						oosProfs.close();
						
						OutputStream osNutris = new FileOutputStream("nutricionistas.txt");
						ObjectOutputStream oosNutris = new ObjectOutputStream(osNutris);
						
						oosNutris.writeObject(nutricionistas);
						oosNutris.close();
						
						JOptionPane.showMessageDialog(null, "Sucesso!");
						
						break;
					}
					
					case 0:
					{
						JOptionPane.showMessageDialog(null, "Obrigado por utilizar nosso sistema!");
						
						break;
					}
					
					default:
					{
						JOptionPane.showMessageDialog(null, "Selecione uma opção válida!");
						
						break;
					}
				}
			}
			catch(NumberFormatException nfe)
			{
				JOptionPane.showMessageDialog(null, "Por favor, insira um número!");
				op = 1;
			}
			catch(StringIndexOutOfBoundsException si)
			{
				JOptionPane.showMessageDialog(null, "Por favor, insira um um termo válido!");
				op = 1;
			}
			catch(NullPointerException npe)
			{
				op = 1;
			}
		}
		
		// -------------------------------------------------------------
	}
}
