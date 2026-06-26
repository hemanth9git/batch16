package com.tejait.batch16.dto;

import java.util.List;

import lombok.Data;

@Data
public class PersonItemsDto {
private int personId; //1
private List<Integer> items;//1,3,5
}
