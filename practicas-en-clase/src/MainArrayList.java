import java.util.ArrayList;

public  class MainArrayList {
    public static void main(String[] args) {
        ArrayList<String> estudiantes = new ArrayList<>();

        estudiantes.add("Ana");
        estudiantes.add("Carlos");
        estudiantes.add("Stefani");
        estudiantes.add("María");

        estudiantes.remove("Ana");
        System.out.println("Primer estudiante: " + estudiantes.get(0)); //Obtengo el primer estudiante

        estudiantes.remove("Carlos");

        for (String estudiante : estudiantes) {  // = for ( int i = 0; i < estudiantes.size(); i++)
            System.out.println(estudiante);      // = System.out.println(estudiantes.get(i))
        }

        System.out.println("\nTotal: " + estudiantes.size());

        estudiantes.add("Angel");
        estudiantes.add("Mynor");
        estudiantes.clear();
        System.out.println("Total estudiantes: " + estudiantes.size());
    }
}