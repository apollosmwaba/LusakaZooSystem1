// Importing the utility classes
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Animal Class
class Animal {

    //Attributes of the animal class 
    private String name;
    private String species;
    private int age;
    private String healthStatus;
    private String feedingSchedule;
    private Enclosure enclosure;

    // Constructor of the animal class 
    public Animal(String name, String species, int age, String healthStatus, String feedingSchedule, Enclosure enclosure) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.healthStatus = healthStatus;
        this.feedingSchedule = feedingSchedule;
        this.enclosure = enclosure;
    }

    //Method to get the name of the animal
    public String getName() {
        return name;
    }

    //Method to get the species of the animal
    public String getSpecies() {
        return species;
    }
    // Method to set the Health Status
    public void setHealthStatus(String newStatus) {
        this.healthStatus = newStatus;
    }
    // Method to set the Enclosure
    public void setEnclosure(Enclosure newEnclosure) {
        this.enclosure = newEnclosure;
    }
    
    //Method to get the enclosure
    public Enclosure getEnclosure() {
        return enclosure;
    }

    @Override
    public String toString() {
        return "Animal: " + name + ", Species: " + species + ", Age: " + age + ", Health: " + healthStatus + 
               ", Feeding Schedule: " + feedingSchedule + ", Enclosure: " + (enclosure != null ? enclosure.getName() : "None");
    }
}

// Enclosure Class
class Enclosure {
    private String name;
    private int capacity;
    private List<Animal> animals;

    public Enclosure(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.animals = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addAnimal(Animal animal) {
        if (animals.size() < capacity) {
            animals.add(animal);
        } else {
            System.out.println("Enclosure is at full capacity!");
        }
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    @Override
    public String toString() {
        return "Enclosure: " + name + ", Capacity: " + capacity + ", Animals: " + animals.size();
    }
}

// Zookeeper Class
class Zookeeper {
    private String name;
    private String employeeID;
    private List<Enclosure> enclosures;

    public Zookeeper(String name, String employeeID) {
        this.name = name;
        this.employeeID = employeeID;
        this.enclosures = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void assignEnclosure(Enclosure enclosure) {
        enclosures.add(enclosure);
    }

    public List<Animal> getAnimalsUnderCare() {
        List<Animal> animalsUnderCare = new ArrayList<>();
        for (Enclosure enclosure : enclosures) {
            animalsUnderCare.addAll(enclosure.getAnimals());
        }
        return animalsUnderCare;
    }

    @Override
    public String toString() {
        return "Zookeeper: " + name + ", Employee ID: " + employeeID + ", Enclosures: " + enclosures.size();
    }
}

// Zoo Class
class Zoo {
    private List<Animal> animals;
    private List<Enclosure> enclosures;
    private List<Zookeeper> zookeepers;

    public Zoo() {
        this.animals = new ArrayList<>();
        this.enclosures = new ArrayList<>();
        this.zookeepers = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void updateAnimalHealth(String animalName, String newHealthStatus) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(animalName)) {
                animal.setHealthStatus(newHealthStatus);
                System.out.println("Updated " + animalName + "'s health status to " + newHealthStatus);
                return;
            }
        }
        System.out.println("Animal not found.");
    }

    public void moveAnimalToEnclosure(String animalName, Enclosure newEnclosure) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(animalName)) {
                animal.setEnclosure(newEnclosure);
                newEnclosure.addAnimal(animal);
                System.out.println(animalName + " moved to " + newEnclosure.getName());
                return;
            }
        }
        System.out.println("Animal not found.");
    }

    public void assignZookeeperToEnclosure(Zookeeper zookeeper, Enclosure enclosure) {
        zookeeper.assignEnclosure(enclosure);
    }

    public void generateEnclosureReport(String enclosureName) {
        for (Enclosure enclosure : enclosures) {
            if (enclosure.getName().equalsIgnoreCase(enclosureName)) {
                System.out.println("Animals in " + enclosureName + ":");
                for (Animal animal : enclosure.getAnimals()) {
                    System.out.println(animal);
                }
                return;
            }
        }
        System.out.println("THE ENCLOSURE IS NOT FOUND !!!");
    }

    public void generateZookeeperReport(String zookeeperName) {

        // Using the for each loop
        for (Zookeeper zookeeper : zookeepers) {

            //Conditional statement
            if (zookeeper.getName().equalsIgnoreCase(zookeeperName)) {
                System.out.println("Animals under " + zookeeperName + "'s care:");
                for (Animal animal : zookeeper.getAnimalsUnderCare()) {
                    System.out.println(animal);
                }
                return;
            }
        }
        System.out.println("Zookeeper not found.");
    }

    public List<Enclosure> getEnclosures() {
        return enclosures;
    }

    public List<Zookeeper> getZookeepers() {
        return zookeepers;
    }

    public void addEnclosure(Enclosure enclosure) {
        enclosures.add(enclosure);
    }

    public void addZookeeper(Zookeeper zookeeper) {
        zookeepers.add(zookeeper);
    }
}


// Main Class
public class LusakaZooSystem {
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zoo zoo = new Zoo();

        while (true) {
            System.out.println("\n--- Lusaka Zoo Management System ---");
            System.out.println("1. Add Animal");
            System.out.println("2. Update Animal Health Status");
            System.out.println("3. Move Animal to Another Enclosure");
            System.out.println("4. Assign Zookeeper to Enclosure");
            System.out.println("5. Generate Enclosure Report");
            System.out.println("6. Generate Zookeeper Report");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1: // Add Animal
                    System.out.print("Enter animal name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter species: ");
                    String species = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter health status: ");
                    String health = scanner.nextLine();
                    System.out.print("Enter feeding schedule: ");
                    String feeding = scanner.nextLine();
                    System.out.print("Enter enclosure name: ");
                    String enclosureName = scanner.nextLine();
                    Enclosure enclosure = new Enclosure(enclosureName, 10);
                    zoo.addEnclosure(enclosure);
                    Animal animal = new Animal(name, species, age, health, feeding, enclosure);
                    zoo.addAnimal(animal);
                    enclosure.addAnimal(animal);
                    break;
                case 2: // Update Health
                    System.out.print("Enter animal name: ");
                    String animalName = scanner.nextLine();
                    System.out.print("Enter new health status: ");
                    String newHealth = scanner.nextLine();
                    zoo.updateAnimalHealth(animalName, newHealth);
                    break;
                case 3: // Move Animal
                    System.out.print("Enter animal name: ");
                    animalName = scanner.nextLine();
                    System.out.print("Enter new enclosure: ");
                    enclosureName = scanner.nextLine();
                    Enclosure newEnclosure = new Enclosure(enclosureName, 10);
                    zoo.moveAnimalToEnclosure(animalName, newEnclosure);
                    break;
                case 4: // Assign Zookeeper
                    System.out.print("Enter zookeeper name: ");
                    String zookeeperName = scanner.nextLine();
                    System.out.print("Enter enclosure name: ");
                    enclosureName = scanner.nextLine();
                    zoo.assignZookeeperToEnclosure(new Zookeeper(zookeeperName, "ZK1"), new Enclosure(enclosureName, 10));
                    break;
                case 5: 
                    System.out.print("Enter enclosure name: ");
                    zoo.generateEnclosureReport(scanner.nextLine());
                    break;
                case 6: 
                    System.out.print("Enter zookeeper name: ");
                    zoo.generateZookeeperReport(scanner.nextLine());
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }
}
