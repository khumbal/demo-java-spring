package net.nexsource.demo.java.spring.converter;

import net.nexsource.demo.java.spring.model.Country;
import net.nexsource.demo.java.spring.model.base.BaseEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;

/**
 * A converter class used in views to map id's to actual Entity objects.
 */
public class Id2EntityConverter implements ConverterFactory<String, BaseEntity> {

    public <T extends BaseEntity> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToBaseEntityConverter<T>(targetType);
    }

    private final class StringToBaseEntityConverter<T extends BaseEntity> implements Converter<String, T> {

        private final Class<T> clazz;

        public StringToBaseEntityConverter(Class<T> clazz) {
            this.clazz = clazz;
        }

        @SuppressWarnings("unchecked")
        public T convert(String source) {
            checkArg(source);
            T c = null;
            try{
                c = clazz.newInstance();
                c.setId(Long.parseLong(source));
            }catch (Exception e) { }
            return c;
        }

        private void checkArg(String source) {
            // In the spec, null input is not allowed
            if (source == null) {
                throw new IllegalArgumentException("null source is in allowed");
            }
        }
    }

}