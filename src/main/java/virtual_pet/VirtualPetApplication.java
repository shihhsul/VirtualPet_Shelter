package virtual_pet;
import java.util.Scanner;

public class VirtualPetApplication {
    public static void main(String[] args) {
        VirtualPetShelter shelter = new VirtualPetShelter();
        VirtualPet pet1 = new VirtualPet("Joey", "A playful dog.");
        VirtualPet pet2 = new VirtualPet("Johnny", "A friendly cat.");
        VirtualPet pet3 = new VirtualPet("Dee Dee", "A curious parrot.");
        VirtualPet pet4 = new VirtualPet("Tommy", "A lazy hamster.");

        shelter.intakePet(pet1);
        shelter.intakePet(pet2);
        shelter.intakePet(pet3);
        shelter.intakePet(pet4);

        System.out.println("Thank you for volunteering at Big Al's Virtual Pet Shelter and Delicatessen!");

        while (true) {
            displayPetsStatus(shelter);

            System.out.println("\nWhat would you like to do next?\n");
            System.out.println("1. Feed the pets");
            System.out.println("2. Water the pets");
            System.out.println("3. Play with a pet");
            System.out.println("4. Adopt a pet");
            System.out.println("5. Admit a pet");
            System.out.println("6. Quit");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    shelter.feedAllPets();
                    break;
                case 2:
                    shelter.waterAllPets();
                    break;
                case 3:
                    playWithPet(shelter);
                    break;
                case 4:
                    adoptPet(shelter, scanner);
                    break;
                case 5:
                    admitPet(shelter, scanner);
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
            
            shelter.tick();
        }
    }

    private static void displayPetsStatus(VirtualPetShelter shelter) {
        System.out.println("\nThis is the status of your pets:\n");
        System.out.println("Name\t|Hunger\t|Thirst\t|Boredom");
        System.out.println("--------|-------|-------|-------");
        for (VirtualPet pet : shelter.getAllPets()) {
            System.out.println(pet.getName() + "\t|" + pet.getHunger() + "\t|" + pet.getThirst() + "\t|" + pet.getBoredom());
        }
    }

    private static void playWithPet(VirtualPetShelter shelter) {
        System.out.println("\nOk, so you'd like to play with a pet. Please choose one:\n");
        for (VirtualPet pet : shelter.getAllPets()) {
            System.out.println("[" + pet.getName() + "] " + pet.getDescription());
        }
        Scanner scanner = new Scanner(System.in);
        String petName = scanner.nextLine();
        shelter.playWithPet(petName);
        System.out.println("\nOk, you play with " + petName + ".");
    }

    private static void adoptPet(VirtualPetShelter shelter, Scanner scanner) {
        System.out.println("\nSure! Here are the pets available for adoption:\n");
        for (VirtualPet pet : shelter.getAllPets()) {
            System.out.println("[" + pet.getName() + "] " + pet.getDescription());
        }
        System.out.println("Which pet would you like to adopt?");
        String petName = scanner.nextLine();
        shelter.adoptPet(petName);
        System.out.println("\nCongratulations! You have adopted " + petName + ".");
    }

    private static void admitPet(VirtualPetShelter shelter, Scanner scanner) {
        System.out.println("\nWe appreciate your kindness. Please provide the pet's information:\n");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        VirtualPet newPet = new VirtualPet(name, description);
        shelter.intakePet(newPet);
        System.out.println("\nWelcome to the shelter, " + name + "!");
    }
    
}
