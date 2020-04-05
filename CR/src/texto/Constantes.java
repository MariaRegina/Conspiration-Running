package texto;

import java.util.ArrayList;
import java.util.List;


public class Constantes {
	
	
	public static String equipe = "HTTCS SOLUÇÕES TECNOLÓGICAS apresenta:";
	public static String titulo = "CONSPIRATION RUNNING";
	public static String continar = "<Pressione E para continuar>";
	
	public static List<String> inicioHistoria =  new ArrayList<String>();
	public static List<String> fimFase1 =  new ArrayList<String>();
	
	public Constantes() {
		inicioHistoria.add("Como o universo surgiu?");
		inicioHistoria.add("Muitas pessoas me aconselharam não buscar a resposta para essa pergunta.");
		inicioHistoria.add("É um caminho perigoso, mas não vou parar agora... Não quando já fui tão longe...");
		
		fimFase1.add("Sempre me ensinaram questionar tudo..");
		fimFase1.add("Agora, vendo esses questionamentos, será que é real?");
		fimFase1.add("Será que existe algo mais? Continuarei...");
	}
}
