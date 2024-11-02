package com.gordon.doc_repo.enumeration.converter;

import java.util.stream.Stream;

import com.gordon.doc_repo.enumeration.Authority;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Authority, String> {

	@Override
	public String convertToDatabaseColumn(Authority authority) {
		// TODO Auto-generated method stub
		if(authority ==null) {
			return null;
		}
		return authority.getValue();
	}

	@Override
	public Authority convertToEntityAttribute(String code) {
		if(code == null)
			return null;
		return Stream.of(Authority.values())
				.filter(authority-> authority.getValue().equals(code))
				.findFirst()
				.orElseThrow(IllegalArgumentException:: new);
	}

}
