package com.example.exception.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.exception.dto.Error;
import com.example.exception.dto.ErrorResponse;
import com.example.exception.dto.User2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;



@RestController
@RequestMapping("/api/user3")
public class exceptionApiController {
    
    //흠 .. 왜안먹지 
    @RequestMapping("/get")
    public User2 get(
        @Size(min=1, max = 100)
        @RequestParam String name, 

        @Min(1)
        @NotNull
        @RequestParam int age) {
    User2 user = new User2();
    user.setName(name);
    user.setAge(age);
    return user;
    }

    @RequestMapping("/post")
    public User2 post(@Valid @RequestBody User2 user) {
        System.out.println(user);
        return user;
    }

    //특정한 controller에 exception 주고싶을 경우
    // Post사용 할 경우 아래와 같이 Body에 들어옴 

    // {
    //     "statusCode": "400 BAD_REQUEST",
    //     "requestUrl": null,
    //     "code": null,
    //     "message": "/api/user3/post",
    //     "resultCode": "FAIL",
    //     "errorList":[
    //     {
    //     "field": "age",
    //     "message": "Validation failed for argument [0] in public com.example.exception.dto.User2 com.example.exception.controller.exceptionApiController.post(com.example.exception.dto.User2): [Field error in object 'user2' on field 'age': rejected value [0]; codes [Min.user2.age,Min.age,Min.int,Min]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [user2.age,age]; arguments []; default message [age],1]; default message [1 이상이어야 합니다]] ",
    //     "invalidValue": "invalidvalue"
    //     }
    //     ]
    // }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest httpServletRequest) {
        BindingResult bindingResult = e.getBindingResult();
        List <Error> errorList = new ArrayList<>();
        ErrorResponse errorResponse = new ErrorResponse();
        bindingResult.getAllErrors().forEach(error -> {
            FieldError field = (FieldError) error;

            String fieldName = field.getField();
            String message = field.getDefaultMessage();
            String value = field.getRejectedValue().toString();

            System.out.println(fieldName);
            System.out.println(message);
            System.out.println(value);
       
            Error errorMessage = new Error();
            errorMessage.setField(fieldName);
            errorMessage.setMessage(e.getMessage());
            errorMessage.setInvalidValue("invalidvalue");
    
            errorList.add(errorMessage);
      
            errorResponse.setErrorList(errorList);
            errorResponse.setMessage(httpServletRequest.getRequestURI());
            errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.toString());
            errorResponse.setResultCode("FAIL");

        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

    }

    //client에서 잘못된 값을 넘겨받았을때
    // Body에  아래와 같이 이쁘게 들어옴 
    // {
    //     "statusCode": "400 BAD_REQUEST",
    //     "requestUrl": null,
    //     "code": null,
    //     "message": "/api/user3/get",
    //     "resultCode": "FAIL",
    //     "errorList":[
    //          {
    //              "field": "fieldName",
    //              "message": "Failed to convert value of type 'java.lang.String' to required type 'int'; nested exception is java.lang.NumberFormatException: For input string: \"\"",
    //              "invalidValue": "invalidvalue"
    //          }
    //     ]
    //}

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e, HttpServletRequest  httpServletRequest) {

        List <Error> errorList = new ArrayList<>();

        Error error = new Error();
        error.setField("fieldName");
        error.setMessage(e.getMessage());
        error.setInvalidValue("invalidvalue");

        errorList.add(error);
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorList(errorList);
        errorResponse.setMessage(httpServletRequest.getRequestURI());
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setResultCode("FAIL");
        System.out.println("Not Null!");
     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
