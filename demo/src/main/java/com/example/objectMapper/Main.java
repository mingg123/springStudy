package com.example.objectMapper;

import java.util.Arrays;
import java.util.List;

import com.example.objectMapper.dto.Car;
import com.example.objectMapper.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Main {
    public static void main(String args[]) throws JsonProcessingException {
        System.out.println("main");

        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User();
        user.setName("홍길동");
        user.setAge(10);

        Car car1 = new Car();
        car1.setName("k5");
        car1.setCarNumber("11가 1111");
        car1.setType("sedan");


        Car car2= new Car();
        car2.setName("Q5");
        car2.setCarNumber("22가 2222");
        car2.setType("SUV");

        List<Car> carList = Arrays.asList(car1, car2);

        user.setCars(carList);
        System.out.println((carList));

        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);

        JsonNode jsonNode = objectMapper.readTree(json);
        String _name = jsonNode.get("name").asText();
        int _age = jsonNode.get("age").asInt();

        System.out.println("name : " + _name);
        System.out.println("age : " + _age);



        //List를 읽어오는 방법 
        JsonNode cars = jsonNode.get("cars");
        ArrayNode arrayNode = (ArrayNode)cars;
        
        //Object 를 원하는 형태로 바꿀 수 있음 
        //Json의 표준 스펙을 알아야함. array노드는 위와 같이 사용.
        List<Car> _cars = objectMapper.convertValue(arrayNode, new TypeReference<List<Car>>(){});

        System.out.println(_cars);

        
        ObjectNode objectNode = (ObjectNode) jsonNode;
        objectNode.put("name", "minji");
        objectNode.put("age" , 20);

        System.out.println(objectNode.toPrettyString());



    }
}
