package com.github.mgljava.basicstudy.java8.optional.example;

import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

  private Optional<Insurance> insurance;
}
