package com.github.mgljava.basicstudy.reactor;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class FluxTest1 {

  public static void main(String[] args) {
    Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6};
    Flux.fromArray(array);

    List<Integer> list = Arrays.asList(array);
    Flux.fromIterable(list);

    Stream<Integer> stream = list.stream();
    Flux.fromStream(stream);

    Mono.justOrEmpty(Optional.empty());

    /*Flux.just(1, 2, 3, 4, 5)
        .subscribe(System.out::println,
            System.err::print,
            () -> System.out.println("Compldsfsdeted!"));*/

    /*Mono.error(new Exception("some error")).subscribe(
        System.out::println,
        System.err::println,
        () -> System.out.println("Completed!")
    );*/

    /*StepVerifier.create(Flux.range(1, 6)    // 1
        .map(i -> i * i))   // 2
        .expectNext(1, 4, 9, 16, 25, 36)    //3
        .expectComplete();*/

    Flux.just("hello", "world")
        .flatMap(s -> Flux.fromArray(s.split("")))
        .doOnNext(System.out::println);
    System.out.println("hello".split("")[0]);

    StepVerifier.create(
            Flux.just("flux", "mono")
                    .flatMap(s -> Flux.fromArray(s.split("\\s*"))   // 1
                            .delayElements(Duration.ofMillis(100))) // 2
                    .doOnNext(System.out::print)) // 3
            .expectNextCount(8) // 4
            .verifyComplete();
  }
}
