import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Iguales {
    public static final String SEPARADOR =",";
    public static void main(String[] args) throws IOException {


        BufferedReader archivo = null;
        try {
            archivo = new BufferedReader(new FileReader("src/codigos_postales_hmo.csv"));
            String linea = archivo.readLine();
            HashMap<String,Integer> contar = new HashMap<>();
            while (linea != null) {
                String[] celdasExcel= linea.split(SEPARADOR);

                for (String cp: celdasExcel){
                    String sevenChars = cp.substring(0, Math.min(6, cp.length()));
                    contar.put(sevenChars, contar.getOrDefault(sevenChars,0)+1);
                }
                linea = archivo.readLine();
            }
            for (String cp : contar.keySet()){
                int cantidad = contar.get(cp);
                if (cantidad>1){
                    System.out.println("Codigo: "+ cp +"Cantidad:" + cantidad);
                }
            }
        } finally {
            if (archivo != null){
                try{
                    archivo.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}