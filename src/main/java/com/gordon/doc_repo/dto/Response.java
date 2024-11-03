package com.gordon.doc_repo.dto;

import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



@JsonInclude(content = Include.NON_DEFAULT)
public record Response(String time,int code,String path, HttpStatus status, String message,String exception, Map<?, ?> date) {}
