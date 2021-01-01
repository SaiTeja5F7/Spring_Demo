package com.sai.utility;

import java.util.Collections.*;
import java.util.Arrays;
import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class StringListConverter implements AttributeConverter<List<String>,String> {

	@Override
	public String convertToDatabaseColumn(List<String> temp) {
		return temp !=null ?String.join(",",temp) : "";
	}

	@Override
	public List<String> convertToEntityAttribute(String dbData) {
		return dbData !=null ? Arrays.asList(dbData.split(",")) : null;
		
	}
	
}
