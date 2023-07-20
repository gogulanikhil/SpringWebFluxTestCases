package com.example.springreactiveprogramming.services;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class SpringFluxAndMonoTest {

    SpringFluxAndMono springFluxAndMono=new SpringFluxAndMono();

    @Test
    void fluxCountryNames() {
        var fluxCOuntryNames=springFluxAndMono.fluxCountryNames();
        StepVerifier
                .create(fluxCOuntryNames)
                .expectNext("INDIA","USA","UK","ITALY")
                .verifyComplete();
    }
    @Test
    public void fluxCountryNameMap(){
        var fluxCountryNameMap=springFluxAndMono.fluxCountryNamesMap();
        StepVerifier
                .create(fluxCountryNameMap)
                .expectNext("JAPAN","CHINA","KOREA");
    }
    @Test
    void fluxCountryNameFilter(){
        var fluxCountryNameFilter=springFluxAndMono.filter(1);
        StepVerifier.create(fluxCountryNameFilter)
                .expectNext("japan","china","Southkorea")
                .verifyComplete();
    }
    @Test
    void monoCountryName() {
        var monoCountryNames=springFluxAndMono.monoCountryName();
        StepVerifier.create(monoCountryNames)
                .expectNext("India")
                .verifyComplete();
    }
}