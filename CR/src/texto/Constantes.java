package texto;

import java.util.ArrayList;
import java.util.List;

public class Constantes {
	
	public static String titulo = "CONSPIRATION RUNNING";
	public static String continar = "<Pressione E para continuar>";
	
	public static List<String> inicioHistoria =  new ArrayList<String>();
	
	public Constantes() {
		inicioHistoria.add("Como o universo surgiu?");
		inicioHistoria.add("Muitas pessoas me aconselharam n�o buscar a resposta para essa pergunta.");
		inicioHistoria.add("� um caminho perigoso, mas n�o vou parar agora... N�o quando j� fui t�o longe...");
	}
}
