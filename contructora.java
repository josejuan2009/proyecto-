import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class contructora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        System.out.println("=== SISTEMA CALCULADORA DE MATERIALES (FET) ===");
        
        do {
            System.out.println("\n--- MENÚ DE CÁLCULOS ---");
            System.out.println("1- Calcular muro de ladrillo");
            System.out.println("2- Calcular viga de hormigón");
            System.out.println("3- Calcular columnas de hormigón");
            System.out.println("4- Calcular contrapisos");
            System.out.println("5- Calcular techo");
            System.out.println("6- Calcular pisos");
            System.out.println("7- Calcular pintura");
            System.out.println("8- Salir");
            System.out.print("Elige una opción: ");
            
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    calcularMuro(scanner);
                    break;
                case 2:
                    calcularViga(scanner);
                    break;
                case 3:
                    calcularColumna(scanner);
                    break;
                case 4:
                    calcularContrapiso(scanner);
                    break;
                case 5:
                    calcularTecho(scanner);
                    break;
                case 6:
                    calcularPisos(scanner);
                    break;
                case 7:
                    calcularPintura(scanner);
                    break;
                case 8:
                    System.out.println("Saliendo del sistema... ¡Mucho éxito con tu entrega!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 8);
        
        scanner.close();
    }

    // Función para guardar los cálculos en un archivo JSON local
    public static void guardarEnJson(String tipoCalculo, String detalle) {
        try (FileWriter fw = new FileWriter("registros.json", true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println("{");
            pw.println("  \"operacion\": \"" + tipoCalculo + "\",");
            pw.println("  \"detalle\": \"" + detalle + "\"");
            pw.println("},");
            System.out.println("-> [JSON Guardado exitosamente en registros.json]");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo JSON: " + e.getMessage());
        }
    }

    // 1. Muro de ladrillo
    public static void calcularMuro(Scanner scanner) {
        System.out.print("¿De cuánto es el espesor del muro? (20 o 30 cm): ");
        int espesor = scanner.nextInt();
        System.out.print("Ingresa el largo del muro (metros): ");
        double largo = scanner.nextDouble();
        System.out.print("Ingresa el alto del muro (metros): ");
        double alto = scanner.nextDouble();

        double superficie = largo * alto;
        System.out.println("Superficie del muro: " + superficie + " m²");

        String detalle = "";
        if (espesor == 30) {
            double cemento = superficie * 15.2;
            double arena = superficie * 0.115;
            double ladrillos = superficie * 120;
            System.out.println("Materiales necesarios (Muro 30cm):");
            System.out.println("- Cemento: " + cemento + " kg");
            System.out.println("- Arena: " + arena + " m³");
            System.out.println("- Ladrillos: " + ladrillos + " unidades");
            detalle = "Muro 30cm - Sup: " + superficie + "m2, Cemento: " + cemento + "kg, Arena: " + arena + "m3, Ladrillos: " + ladrillos;
        } else if (espesor == 20) {
            double cemento = superficie * 10.9;
            double arena = superficie * 0.09;
            double ladrillos = superficie * 90;
            System.out.println("Materiales necesarios (Muro 20cm):");
            System.out.println("- Cemento: " + cemento + " kg");
            System.out.println("- Arena: " + arena + " m³");
            System.out.println("- Ladrillos: " + ladrillos + " unidades");
            detalle = "Muro 20cm - Sup: " + superficie + "m2, Cemento: " + cemento + "kg, Arena: " + arena + "m3, Ladrillos: " + ladrillos;
        } else {
            System.out.println("Espesor no válido.");
            return;
        }
        guardarEnJson("Muro de Ladrillo", detalle);
    }

    // 2. Viga de hormigón
    public static void calcularViga(Scanner scanner) {
        System.out.print("Ingresa el largo de la viga (metros): ");
        double largo = scanner.nextDouble();
        double cemento = largo * 9;
        double arena = largo * 0.02;
        double piedra = largo * 0.02;
        double hierro8 = largo * 4;
        double hierro4 = largo * 3;

        System.out.println("Materiales necesarios para la viga:");
        System.out.println("- Cemento: " + cemento + " kg");
        System.out.println("- Arena: " + arena + " m³");
        System.out.println("- Piedra: " + piedra + " m²");
        System.out.println("- Hierro del 8: " + hierro8 + " m");
        System.out.println("- Hierro del 4: " + hierro4 + " m");

        guardarEnJson("Viga de Hormigon", "Largo: " + largo + "m, Cemento: " + cemento + "kg");
    }

    // 3. Columna de hormigón
    public static void calcularColumna(Scanner scanner) {
        System.out.print("Ingresa el largo de la columna (metros): ");
        double largo = scanner.nextDouble();
        double cemento = largo * 7.5;
        double arena = largo * 0.016;
        double piedra = largo * 0.016;
        double hierro10 = largo * 6;
        double hierro4 = largo * 3;

        System.out.println("Materiales necesarios para la columna:");
        System.out.println("- Cemento: " + cemento + " kg");
        System.out.println("- Arena: " + arena + " m³");
        System.out.println("- Piedra: " + piedra + " m²");
        System.out.println("- Hierro del 10: " + hierro10 + " m");
        System.out.println("- Hierro del 4: " + hierro4 + " m");

        guardarEnJson("Columna de Hormigon", "Largo: " + largo + "m, Cemento: " + cemento + "kg");
    }

    // 4. Contrapisos
    public static void calcularContrapiso(Scanner scanner) {
        System.out.print("Ingresa el espesor del contrapiso (metros): ");
        double espesor = scanner.nextDouble();
        System.out.print("Ingresa el ancho del contrapiso (metros): ");
        double ancho = scanner.nextDouble();
        System.out.print("Ingresa el largo del contrapiso (metros): ");
        double largo = scanner.nextDouble();

        double volumen = espesor * ancho * largo;
        double cemento = volumen * 105;
        double arena = volumen * 0.45;
        double piedra = volumen * 0.9;

        System.out.println("Volumen del contrapiso: " + volumen + " m³");
        System.out.println("Materiales necesarios:");
        System.out.println("- Cemento: " + cemento + " kg");
        System.out.println("- Arena: " + arena + " m³");
        System.out.println("- Piedra: " + piedra + " m³");

        guardarEnJson("Contrapiso", "Volumen: " + volumen + "m3, Cemento: " + cemento + "kg");
    }

    // 5. Techo
    public static void calcularTecho(Scanner scanner) {
        System.out.print("Ingresa el espesor del techo (metros): ");
        double espesor = scanner.nextDouble();
        System.out.print("Ingresa el ancho del techo (metros): ");
        double ancho = scanner.nextDouble();
        System.out.print("Ingresa el largo del techo (metros): ");
        double largo = scanner.nextDouble();

        double superficie = ancho * largo;
        double cemento = superficie * 33;
        double arena = superficie * 0.072;
        double piedra = superficie * 0.072;
        double hierro8 = superficie * 7;
        double hierro6 = superficie * 4;

        System.out.println("Superficie del techo: " + superficie + " m²");
        System.out.println("Materiales necesarios:");
        System.out.println("- Cemento: " + cemento + " kg");
        System.out.println("- Arena: " + arena + " m³");
        System.out.println("- Piedra: " + piedra + " m²");
        System.out.println("- Hierro del 8: " + hierro8 + " m");
        System.out.println("- Hierro del 6: " + hierro6 + " m");

        guardarEnJson("Techo", "Superficie: " + superficie + "m2, Cemento: " + cemento + "kg");
    }

    // 6. Pisos
    public static void calcularPisos(Scanner scanner) {
        System.out.print("Ingresa el ancho del paño de piso (metros): ");
        double ancho = scanner.nextDouble();
        System.out.print("Ingresa el largo del paño de piso (metros): ");
        double largo = scanner.nextDouble();

        double superficieBase = ancho * largo;
        double superficieConRecorte = superficieBase * 1.10; 
        System.out.println("Superficie total con 10% extra por recortes: " + superficieConRecorte + " m²");

        guardarEnJson("Pisos", "Superficie con recortes: " + superficieConRecorte + " m2");
    }

    // 7. Pintura
    public static void calcularPintura(Scanner scanner) {
        System.out.print("Ingresa la superficie del muro (m²): ");
        double superficie = scanner.nextDouble();
        double litros = superficie / 6.0; 
        System.out.println("Necesitas " + litros + " litros de pintura.");

        guardarEnJson("Pintura", "Superficie: " + superficie + "m2, Litros: " + litros);
    }
}