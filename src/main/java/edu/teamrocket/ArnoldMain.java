package edu.teamrocket;
import java.util.Optional;

public class ArnoldMain {

    public static void main(String[] args) {

        Optional<Double> peso = Optional.empty();
        Optional<Planeta> planeta = Optional.empty();
        
        try {
            peso = Optional.of(Double.parseDouble(args[0]));
            planeta = Optional.of(Planeta.valueOf(args[1]));

            double resultado = planeta.get().pesoSuperficie(peso.get());
            System.out.println("Your weight on " + planeta.get().name() + " is " + resultado);
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Proporciona peso y planeta como argumentos.");
        } 
        catch (NumberFormatException e) {
            System.out.println("El primer argumento debe ser un nombre que representa el peso en KG.");
        } 
        catch (IllegalArgumentException e) {
            System.out.println("El segundo argumento debe ser un planeta valido.");
        }
    }
}

        // -- print general --
        // System.out.println("Your weight on all planets:");
        // for(Planeta planeta : Planeta.values()){
        //     System.out.printf("Your weight on %s is %f N%n", planeta.name(), planeta.pesoSuperficie(peso));
        // }
         
        // System.out.println("\nYour weight only on the terrestrial planets: ");
        // for(Planeta planeta: Planeta.getPlanetasTerrestres()){
        //     System.out.printf("Your weight on %s is %f N%n", planeta.name(), planeta.pesoSuperficie(peso));
        // }
         
        // System.out.println("\nYour weight only on the gas giant planets: ");
        // for(Planeta planeta: Planeta.getGigantesGaseosos()){
        //     System.out.printf("Your weight on %s is %f N%n", planeta.name(), planeta.pesoSuperficie(peso));
        // }

        // System.out.println("\nYour weight only on the ice giant planets: ");
        // for(Planeta planeta: Planeta.getGigantesHelados()){
        //     System.out.printf("Your weight on %s is %f N%n", planeta.name(), planeta.pesoSuperficie(peso));
        // }