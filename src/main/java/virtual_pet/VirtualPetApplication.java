package virtual_pet;

import java.util.Scanner;

public class VirtualPetApplication {

public static void main(String[] args) {
        VirtualPet Pet = new VirtualPet(); 

        while(true){
            System.out.println("Current Status of Your Pet:");
            System.out.println("Hunger: " + Pet.getHunger());
            System.out.println("Thirst: " + Pet.getThirst());
            System.out.println("Waste: " + Pet.getWaste());
            System.out.println("Boredom: " + Pet.getBoredom());
            System.out.println("Sickness: " + Pet.getSickness());

            System.out.println("What do you want to do? ");
            System.out.println("1. Feed the Pet");
            System.out.println("2. Water the Pet");
            System.out.println("3. Relieve the Pet");
            System.out.println("4. Play with the Pet");
            System.out.println("5. Taking the pet to the doctor");
            Scanner scanner = new Scanner(System.in);
            int choice  = scanner.nextInt();
            switch (choice) {
                case 1:
                    Pet.feed();
                    break;
                case 2:
                    Pet.water();
                    break;
                case 3: 
                    Pet.relieve();
                    break;
                case 4:
                    Pet.play();
                    break;
                case 5:
                    Pet.visitDoctor();
                    break;
                default:
                System.out.println("Invalid Choice");
                    break;
            }
            Pet.tick();
        }
    }

}
