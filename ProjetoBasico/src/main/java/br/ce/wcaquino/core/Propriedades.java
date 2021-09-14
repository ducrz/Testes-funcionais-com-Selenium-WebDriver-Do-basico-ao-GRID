package br.ce.wcaquino.core;

public class Propriedades {
	
	public static boolean FECHAR_BROWSER = true;
	
	public static Browsers BROWSER = Browsers.FIREFOX;
	
	public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.LOCAL;
	
	public enum Browsers {
		CHROME,
		FIREFOX,
		EDGE
	}
	
	public enum TipoExecucao {
		LOCAL,
		GRID,
		NUVEM
	}

}