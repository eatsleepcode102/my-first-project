package howto.lambdaapi;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main1 {

  public static void main(String[] args) {
    List<Student> members = new ArrayList<>();

    members.add(new Student("P", Sex.MALE, 12, "p@g.com"));
    members.add(new Student("J", Sex.MALE, 42, "j@g.com"));
    members.add(new Student("K", Sex.FEMALE, 22, "k@g.com"));
    members.add(new Student("L", Sex.FEMALE, 52, "l@g.com"));

    for (Sex gender : Sex.values()) {
      System.out.println("All " + gender + ":");
      processMembersWithFunction(members, 
                                        p -> p.getGender() == gender,
                                        Student::getName, 
                                        System.out::println);
    }

    System.out.println("All FEMALE over 30:");
    processMembersWithFunction(members, 
                                      p -> p.getGender() == Sex.FEMALE && p.getAge() > 30, 
                                      Student::getName, 
                                      System.out::println);
  }
  public static void processMembersWithFunction(List<Student> roster,
      Predicate<Student> tester, Function<Student, String> mapper,
      Consumer<String> block) {
    for (Student p : roster) {
      if (tester.test(p)) {
        String data = mapper.apply(p);
        block.accept(data);
      }
    }
  }
}

enum Sex {
  MALE, FEMALE
}

class Student {

  private final String name;
  private final int age;
  private final Sex gender;
  private final String emailAddress;

  public Student(String name, Sex gender, int age, String emailAddress) {

    this.name = name;
    this.gender = gender;
    this.age = age;
    this.emailAddress = emailAddress;
  }

  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }

  public Sex getGender() {
    return gender;
  }

  public String getEmailAddress() {
    return emailAddress;
  }
}