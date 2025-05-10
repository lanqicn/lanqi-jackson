package io.lanqi.plus.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * CollectionLongToCollectionStringSerializer
 * 将Long类型的集合序列化为字符串类型的集合，用于解决前端无法处理大的long数字的问题
 * ref : https://en.wikipedia.org/wiki/IEEE_754
 */
public class CollectionLongToCollectionStringSerializer extends JsonSerializer<Collection<Long>> {

    @Override
    public void serialize(Collection<Long> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (Objects.isNull(value)) {
            value = Collections.emptyList();
        }
        List<String> strValues = value.stream().filter(Objects::nonNull).map(String::valueOf).toList();
        gen.writeObject(strValues);

    }
}
