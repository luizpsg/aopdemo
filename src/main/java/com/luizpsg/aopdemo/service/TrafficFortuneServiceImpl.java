package com.luizpsg.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {

  @Override
  public String getFortune() {

    // simulate a delay
    try {
      TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    // returne a fortune
    return "Expect heavy traffic this morning";

  }
}
