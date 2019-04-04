package com.github.mgljava.basicstudy.java8.stream;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class StreamTest {

  public static void main(String[] args) {

    List<String> names = Arrays.asList("hello", "world");

    People people = new People();
    List<User> users = Arrays.asList(new User(1, "Zhang"), new User(2, "Li"),
            new User(3, "Wang"), new User(4, "Zhao"));
    people.setUsers(users);
    Flux.just(people)
            .map(People::getUsers)
            .flatMap(Flux::fromIterable)
            //.takeWhile(item -> item.getAge() < 3)
            //.takeWhile(item -> item.getAge() < 2)
            .map(User::getName)
            .map(String::length)
            .subscribe(System.out::println);

    List<String> words = Arrays.asList("Hello", "World", "Hadoop");

    words.stream()
            .map(word -> word.split(""))
            .flatMap(Arrays::stream)
            .distinct()
            .forEach(System.out::print);
    System.out.println();

    /*Flux.range(1, 3)
            .flatMap(i -> Flux.fromIterable(Arrays.asList(4, 5))
                    .map(j ->  System.out.println(i + j))
            .subscribe());*/
            // .subscribe(System.out::print);
    // .map(i -> Flux.range(5, 6).subscribe(System.out::print));

  }


}

class People {
  private List<User> users;

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }
}

class User {
  private int age;
  private String name;

  public User(int age, String name) {
    this.age = age;
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "User{" +
            "age=" + age +
            ", name='" + name + '\'' +
            '}';
  }
}
