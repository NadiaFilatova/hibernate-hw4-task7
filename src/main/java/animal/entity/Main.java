package animal.entity;

import java.util.List;

//CRUD - Create, Read, Update, Delete.

public class Main {
    public static void main(String[] args) {
        AnimalHelper animalHelper = new AnimalHelper();

        Animal cat = new Animal();
        cat.setAge(12);
        cat.setTail(true);
        cat.setName("Vasia");
        animalHelper.addAnimal(cat);

        Animal cat2 = new Animal();
        cat2.setAge(5);
        cat2.setTail(true);
        cat2.setName("Lisa");
        animalHelper.addAnimal(cat2);

        Animal cat3 = new Animal();
        cat3.setAge(1);
        cat3.setTail(true);
        cat3.setName("Cow");
        animalHelper.addAnimal(cat3);

        animalHelper.removeAnimal(animalHelper.getById(2));

        animalHelper.update(3, "Nic");
        animalHelper.update(3, false);
        animalHelper.update(3, 100);

        printListAnimal(animalHelper);
    }

    public static void printListAnimal(AnimalHelper animalHelper) {
        List<Animal> list = animalHelper.getAnimalList();
        for (Animal temp : list) {
            System.out.println(temp.getId() + " -ID " + temp.getName() + " -Name " + temp.getAge() + " -Age " + temp.isTail() + " - Tail");

        }
    }
}