package com.almond.jackson;

import com.almond.common.handler.DesensitizationHandler;
import com.almond.common.util.RmHandlerUtil;
import com.almond.jackson.annotation.ExcludeSensitive;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;

import java.io.IOException;
import java.util.Objects;

/**
 * 说明：脱敏
 *
 * @Author: Glendon.Li
 * @Create: 2021-10-22 23:09
 * @version: V 1.0.0
 */
public class DesensitizationSerialize<T> extends JsonSerializer<String> implements ContextualSerializer {

    private DesensitizationHandler desensitizationHandler;

    private ExcludeSensitive excludeSensitive;

    public DesensitizationSerialize() {
    }

    @Override
    public void serialize(String value, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        if (Objects.nonNull(desensitizationHandler) && !desensitizationHandler.closeHandler(excludeSensitive.enableExclude())) {
            jsonGenerator.writeString(desensitizationHandler.handler(value));
        } else {
            jsonGenerator.writeString(value);
        }
    }


    public DesensitizationSerialize(final DesensitizationHandler handler, final ExcludeSensitive excludeSensitive) {
        this.desensitizationHandler = handler;
        this.excludeSensitive = excludeSensitive;
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        try {
            if (beanProperty != null) {
                ExcludeSensitive excludeSensitive = beanProperty.getAnnotation(ExcludeSensitive.class);
                if (Objects.isNull(excludeSensitive)) {
                    excludeSensitive = beanProperty.getContextAnnotation(ExcludeSensitive.class);
                }
                // 如果能得到注解
                if (Objects.nonNull(excludeSensitive) && excludeSensitive.enable() && Objects.nonNull(excludeSensitive.handler())) {
                    return new DesensitizationSerialize(RmHandlerUtil.getHandler(excludeSensitive.handler()), excludeSensitive);
                }
                return serializerProvider.findValueSerializer(beanProperty.getType(), beanProperty);
            }
        } catch (Exception e) {

        }
        return serializerProvider.findNullValueSerializer(beanProperty);
    }
}
