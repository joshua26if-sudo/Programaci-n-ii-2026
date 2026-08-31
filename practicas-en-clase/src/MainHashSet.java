import java.util.HashSet;

public class MainHashSet {
    public static void main(String[] args) {
        HashSet<String> correos = new HashSet<>();

        correos.add("joshua@miumg.edu.gt");
        correos.add("Malvarado@miumg.edu.gt");
        correos.add("joshua@miumg.edu.gt");

        for (String correo: correos) {
            System.out.println(correo);
        }
    }
}
