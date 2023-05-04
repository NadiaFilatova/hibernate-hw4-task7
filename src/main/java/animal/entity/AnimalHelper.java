package animal.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class AnimalHelper {
    private final EntityManagerFactory emf;
    private final EntityManager em;

    public AnimalHelper() {
        emf = Persistence.createEntityManagerFactory("animals");
        em = emf.createEntityManager();
    }

    public List<Animal> getAnimalList() {
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT animal FROM Animal animal");
        List<Animal> list = query.getResultList();
        em.getTransaction().commit();

        return list;
    }

    public void addAnimal(Animal animal) {
        em.getTransaction().begin();
        em.merge(animal);
        em.getTransaction().commit();

    }

    public void removeAnimal(Animal animal) {
        em.getTransaction().begin();
        em.remove(animal);
        em.getTransaction().commit();
    }

    public Animal getById(int id) {
        em.getTransaction().begin();
        Animal animal = em.find(Animal.class, id);
        em.getTransaction().commit();

        return animal;
    }

    public void update(int id, String name) {
        em.getTransaction().begin();
        Animal animal = em.find(Animal.class, id);
        animal.setName(name);
        em.getTransaction().commit();
    }

    public void update(int id, int age) {
        em.getTransaction().begin();
        Animal animal = em.find(Animal.class, id);
        animal.setAge(age);
        em.getTransaction().commit();
    }

    public void update(int id, boolean tail) {
        em.getTransaction().begin();
        Animal animal = em.find(Animal.class, id);
        animal.setTail(tail);
        em.getTransaction().commit();
    }

}
