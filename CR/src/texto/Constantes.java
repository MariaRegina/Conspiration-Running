package texto;

import java.util.ArrayList;
import java.util.List;


public class Constantes {
	
	
	public static String equipe = "HTTCS SOLU��ES TECNOL�GICAS apresenta:";
	public static String titulo = "CONSPIRATION RUNNING";
	public static String continar = "<Pressione E para continuar>";
	
	public static List<String> inicioHistoria =  new ArrayList<String>();
	public static List<String> fimFase1 =  new ArrayList<String>();
	
	public Constantes() {
		inicioHistoria.add("Como o universo surgiu?");
		inicioHistoria.add("Muitas pessoas me aconselharam n�o buscar a resposta para essa pergunta.");
		inicioHistoria.add("� um caminho perigoso, mas n�o vou parar agora... N�o quando j� fui t�o longe...");
		
		fimFase1.add("Sempre me ensinaram questionar tudo..");
		fimFase1.add("Agora, vendo esses questionamentos, ser� que � real?");
		fimFase1.add("Ser� que existe algo mais? Continuarei...");
	}
}
