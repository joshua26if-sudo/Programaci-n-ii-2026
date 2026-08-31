import java.util.HashMap;

public class MainHashMap {
    public static void main(String[] args) {
        HashMap<String, Double> preciosMascota = new HashMap<>();

        preciosMascota.put("PET-0001", 150.00);
        preciosMascota.put("PET-0002", 380.00);
        preciosMascota.put("PET-0003", 450.00);

        System.out.println(preciosMascota.get("PET-0001"));

        String codigoMascota = "PET-0001";
        if (preciosMascota.containsKey(codigo))
    }
}
