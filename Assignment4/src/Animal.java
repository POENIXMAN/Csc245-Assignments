import java.util.Locale;

public class Animal implements Eat, Sortable{
    float animalAge, actualAmountOfFood, maximumAmountOfFood;
    String animalColor, animalGender;
    AnimalType at;

    @Override
    public float compareTo(Object o) {
        return eats();
    }

    enum AnimalType{
        Chicken, Lamb, Cow, Horse
    }

    public Animal (float age,String color, String gender){
        animalAge = age;
        animalColor = color;
        animalGender = gender;
    }


    public float getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(float animalAge) {
        this.animalAge = animalAge;
    }

    public float getActualAmountOfFood() {
        return actualAmountOfFood;
    }

    public void setActualAmountOfFood(float amountOfFood) {
        if (amountOfFood > maximumAmountOfFood || amountOfFood <= 0) {
            actualAmountOfFood = maximumAmountOfFood;
        }
        else{
            actualAmountOfFood = amountOfFood;
        }
    }

    public float getMaximumAmountOfFood() {
        return this.maximumAmountOfFood;
    }

    public void setMaximumAmountOfFood(String animal) {

        if (animal.toLowerCase(Locale.ROOT).startsWith("ch"))
            maximumAmountOfFood = 50;
        else if (animal.toLowerCase(Locale.ROOT).startsWith("la"))
            maximumAmountOfFood = 2000;
        else if (animal.toLowerCase(Locale.ROOT).startsWith("co"))
            maximumAmountOfFood = 5000;
        else {
            maximumAmountOfFood = 7000;
        }

    }

    public String getAnimalColor() {
        return animalColor;
    }

    public void setAnimalColor(String animalColor) {
        this.animalColor = animalColor;
    }

    public String getAnimalGender() {
        return animalGender;
    }

    public void setAnimalGender(String animalGender) {
        this.animalGender = animalGender;
    }

    public void setAnimalType (float maximumFood){
        if ( maximumFood == 50) {
           at = AnimalType.Chicken;
        }
        else if ( maximumFood == 2000) {
            at = AnimalType.Lamb;
        }
        else if ( maximumFood == 5000){
            at = AnimalType.Cow;
        }
        else {
            at = AnimalType.Horse;
        }
    }

    public String getAnimalTypeString(AnimalType at){
        if (at == AnimalType.Cow){
            return "cow";
        }
        else if (at == AnimalType.Lamb){
            return "lamb";
        }
        else if (at == AnimalType.Chicken){
            return "chicken";
        }

        return "horse";
    }

    public AnimalType getAnimalType (){
        return at;
    }
    @Override
    public float eats() {
        return actualAmountOfFood;
    }

    @Override
    public String toString() {
        return "Animal {" +
                " animalAge = " + animalAge +
                ", actualAmountOfFood = " + actualAmountOfFood +
                ", maximumAmountOfFood = " + maximumAmountOfFood +
                ", animalColor ='" + animalColor + '\'' +
                ", animalGender ='" + animalGender + '\'' +
                ", animalType = " + getAnimalType() +
                '}';
    }
}
