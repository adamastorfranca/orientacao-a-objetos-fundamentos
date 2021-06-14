package aplicacao;

import java.util.Scanner;

import entidade.ContaEntidade;
import entidade.ContaPfEntidade;
import entidade.ContaPjEntidade;
import entidade.ContaPpEntidade;
import entidade.excecoes.ContaExcecao;

public class ContaAplicacao {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Qual tipo de conta (pf/pj/pp): ");
		String tipo = sc.nextLine();
		ContaEntidade conta = null;
		
		System.out.print("Ag�ncia: ");
		Integer agencia = sc.nextInt();
		
		System.out.print("Correntista: ");sc.next();
		String correntista = sc.nextLine();
		
		System.out.print("Saldo inicial: R$ ");
		Double saldo = sc.nextDouble();
		
		System.out.print("Limite de saque: R$ ");
		Double limiteSaque = sc.nextDouble();
		
		if(tipo.equalsIgnoreCase("pf")) {
			boolean cartaocredito = false;
			System.out.print("Liberar cart�o de cr�dito (s/n): ");
			Character sn = sc.next().charAt(0);
			if (sn == 's') {
				cartaocredito = true;
			}
			conta = new ContaPfEntidade(correntista, saldo, agencia, limiteSaque, cartaocredito);
		}
		else if(tipo.equalsIgnoreCase("pj")) {
			System.out.print("Limite de empr�stimo: R$ ");
			Double limiteEmprestimo = sc.nextDouble();
			conta = new ContaPjEntidade(correntista, saldo, agencia, limiteSaque, limiteEmprestimo);
		}
		else if(tipo.equalsIgnoreCase("pp")) {
			System.out.print("Taxa de juros: ");
			Double taxaJuros = sc.nextDouble();
			conta = new ContaPpEntidade(correntista, saldo, agencia, limiteSaque, taxaJuros);
		} else {
			System.out.println("Tipo de conta inexistente!");
		}
		
		System.out.print("\nTeste deposito: R$ ");
		Double valor = sc.nextDouble();
		conta.deposito(valor);
			
		try {	
			System.out.print("\nTeste saque: R$ ");
			valor = sc.nextDouble();
			conta.saque(valor);
		}
		catch(ContaExcecao e) {
			System.out.println("Erro de saque: " + e.getMessage());
		}
		
		System.out.println(conta);	
			
		sc.close();
	}
}
