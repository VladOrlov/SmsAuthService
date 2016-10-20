package com.digi.util;

import com.clickatell.exception.ApiConnectionException;
import com.clickatell.exception.ApiException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by tymoshenkol on 07-Oct-16.
 */
@Service
public class JsonUtil {

	@Autowired
	ObjectMapper mapper;

	public String asJsonString (final Object obj) {
		try {
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public <T> Object fromJson (final String json, Class<T> clazz) {
		// Convert all checked exceptions to Runtime
		try {
			return mapper.readValue(json, clazz);
		} catch (final JsonMappingException | JsonParseException e) {
			throw new ApiException(e.getMessage(), e);
		} catch (final IOException e) {
			throw new ApiConnectionException(e.getMessage(), e);
		}
	}
}
