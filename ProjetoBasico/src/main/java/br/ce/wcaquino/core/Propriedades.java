package br.ce.wcaquino.core;

public class Propriedades {
	//Não fechar Browser a cada teste
	public static boolean FECHAR_BROWSER = false; 
	
	public static Browsers browser = Browsers.FIREFOX;
	
	public static String NOME_CONTA_ALTERADA = "Conta do Teste alterada " + System.nanoTime();  
	
	public enum Browsers {
		CHROME,
		FIREFOX
	}

}