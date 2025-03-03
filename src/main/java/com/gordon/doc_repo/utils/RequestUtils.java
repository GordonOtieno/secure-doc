package com.gordon.doc_repo.utils;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.gordon.doc_repo.dto.Response;

import jakarta.servlet.http.HttpServletRequest;

public class RequestUtils {
   public static  Response getResponse(HttpServletRequest request,Map<?, ?>data, String message, HttpStatus status) {
	   return new Response(LocalDateTime.now().toString(),status.value(),
			   request.getRequestURI(), HttpStatus.valueOf(status.value()), message, null, data);
   }
}
