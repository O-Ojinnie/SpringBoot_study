package com.kosa.restservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//응답할 내용을 하나의 객체로 만들어 처리하기 위함
//예외 관련 AOP 클래스 생성
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;

}
