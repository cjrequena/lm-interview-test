package com.cjrequena.sample;

import lombok.Getter;

public enum EProductType {

  BOOK("BOOK"),
  FOOD("FOOD"),
  MEDICAL("MEDICAL"),
  OTHER("OTHER");

  @Getter
  private final String code;

  EProductType(String code) {
    this.code = code;
  }

}
