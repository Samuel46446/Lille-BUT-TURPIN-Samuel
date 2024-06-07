package tp04;

public class UseStudent
{
    public static void main(String[] args)
    {
        Person alice = new Person("Alice", "A");
		Person bruno = new Person("Bruno", "B");
		Person samuel = new Person("Samuel", "T");

        double note1[] = {10,16,10};
        double note2[] = {15,9,6};
        double note3[] = {8,19,13};

        Student s1 = new Student(alice, note1);
        Student s2 = new Student(bruno, note2);
        Student s3 = new Student(samuel, note3);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }    
}
