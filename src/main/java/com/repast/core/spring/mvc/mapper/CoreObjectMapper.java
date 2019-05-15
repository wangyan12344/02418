package com.repast.core.spring.mvc.mapper;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * 增加自定义转换器
 * @author luandong
 *
 */
public class CoreObjectMapper extends ObjectMapper{

	public CoreObjectMapper(){
		super();
		this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>(){
			 @Override  
             public void serialize(Object value, JsonGenerator jgen,  
                     SerializerProvider provider) throws IOException,  
                     JsonProcessingException {  
                 jgen.writeString("");  
             }  
		});
	}
}
