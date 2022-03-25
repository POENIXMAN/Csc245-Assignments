public interface Sortable {

    // had to change type to float since amount of food in Animal is float
    float compareTo(Object o);

    /*
    a.compareTo(b) returns 0 if a is equal to b, a number
    greater than 0 if a is greater than b and a number less
    than 0 if a is less than b. Animals are compared by age.
    */
}
