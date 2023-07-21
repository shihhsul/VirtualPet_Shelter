package virtual_pet;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class VirtualPetShelter {
    private Map<String, VirtualPet> pets = new HashMap<>();

    public void intakePet(VirtualPet pet) {
        pets.put(pet.getName(), pet);
    }

    public void adoptPet(String petName) {
        pets.remove(petName);
    }

    public void feedAllPets() {
        for (VirtualPet pet : pets.values()) {
            pet.feed();
        }
    }

    public void waterAllPets() {
        for (VirtualPet pet : pets.values()) {
            pet.water();
        }
    }

    public void playWithPet(String petName) {
        VirtualPet pet = pets.get(petName);
        if (pet != null) {
            pet.play();
        }
    }

    public void tick() {
        for (VirtualPet pet : pets.values()) {
            pet.tick();
        }
    }

    public Collection<VirtualPet> getAllPets() {
        return pets.values();
    }

    public VirtualPet getPetByName(String petName) {
        return pets.get(petName);
    }
}
