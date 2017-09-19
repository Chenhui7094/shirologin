package com.birdsh.chen.entity;

import java.util.List;

import lombok.Data;

@Data
public class User {
	private Integer id;
    private String username;
    private String password;
    private Integer roleId;
    private List<String> roleStrlist;
    private List<String> perminsStrlist;

}
