public class AnimalNode {
    AnimalNode nextAnimal;
    Animal animal;

    public AnimalNode (Animal a){
        animal = a;
    }

    public AnimalNode getNextAnimal() {
        return nextAnimal;
    }

    public void setNextAnimal(AnimalNode nextAnimal) {
        this.nextAnimal = nextAnimal;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
