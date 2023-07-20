package com.example.springreactiveprogramming.services;

import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.util.List;

public class SpringFluxAndMono{
    public Flux<String> fluxCountryNames(){
       return Flux.fromIterable(List.of("INDIA","USA","UK","ITALY"));
    }

    public Flux<String> fluxCountryNamesMap(){
        return Flux
                .fromIterable(List.of("japan","china","korea"))
                .map(String::toUpperCase);
    }
    public Flux<String> filter(int num){
        return Flux.fromIterable(List.of("japan","china","Southkorea"))
                .filter(s -> s.length() > num);
    }
    public Mono<String> monoCountryName(){
        return Mono.just("India").log();
    }
    public static void main(String[] args) {
        SpringFluxAndMono springFluxAndMono=new SpringFluxAndMono();

        springFluxAndMono
                .fluxCountryNames()
                .subscribe(countries -> {
                System.out.println("fluxCountries = " + countries);
        });

        springFluxAndMono
                .fluxCountryNamesMap()
                .subscribe(upperCase -> {
            System.out.println("Countries withUpperCase = " + upperCase);
        });

        springFluxAndMono
                .filter(5)
                .subscribe(s -> {
            System.out.println("length > 5 = " + s);
        });

        springFluxAndMono
                .monoCountryName()
                .subscribe(s -> {
            System.out.println("monoCountry = " + s);
        });
        }
//        System.out.println("To run the flux we need to subscribe first and then map");
    }
