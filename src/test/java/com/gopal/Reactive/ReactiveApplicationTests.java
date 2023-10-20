package com.gopal.Reactive;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class ReactiveApplicationTests {

	@Test
	void testMono() {
		Mono<?> publisher= Mono.just("Gopal")
				.then(Mono.error(new RuntimeException("Exception Occurred")))
				.log();
		publisher.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
	}

	@Test
	void testFlux(){
		Flux<?> fluxPublisher = Flux.just("Gopal","Java","FullStack")
				.concatWith(Flux.error(new RuntimeException("Exception occurred in Flux testing")))
				.concatWithValues("MySQL")

				.log();

		fluxPublisher.subscribe(System.out::println);
	}

}
