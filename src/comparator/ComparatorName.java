package comparator;

import classSchool.Person;

import java.util.Comparator;

public class ComparatorName implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
