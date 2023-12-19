package org.surkov.myexperiments.utils;

import lombok.Getter;

@Getter
public enum CustomStatus {

  SUCCESS(0, "Успешный запрос."),
  NOT_FOUND(1, "Записи не найдены."),
  EXCEPTION(2, "Ошибка.");

  private final int code;
  private final String message;

  CustomStatus(int code, String message) {
    this.code = code;
    this.message = message;
  }
}
