package io.lanqi.plus.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

class CollectionLongToCollectionStringSerializerTest {


    @Test
    void serialize_not_empty_collection() throws IOException {
        try(Writer jsonWriter = createJsonWriter(Arrays.asList(1L, 2L, 3L))){
            Assertions.assertEquals("[\"1\",\"2\",\"3\"]", jsonWriter.toString());
        }
    }

    @Test
    void serialize_empty_collection() throws IOException {
        try(Writer jsonWriter = createJsonWriter(Collections.emptyList())){
            Assertions.assertEquals("[]", jsonWriter.toString());
        }
    }

    @Test
    void serialize_null() throws IOException {
        try(Writer jsonWriter = createJsonWriter(null)){
            Assertions.assertEquals("[]", jsonWriter.toString());
        }
    }

    private Writer createJsonWriter(Collection<Long> value) throws IOException {
        Writer jsonWriter = new StringWriter();
        JsonGenerator jsonGenerator = new ObjectMapper().getFactory().createGenerator(jsonWriter);
        SerializerProvider serializerProvider = new ObjectMapper().getSerializerProvider();
        new CollectionLongToCollectionStringSerializer().serialize(value, jsonGenerator, serializerProvider);
        jsonGenerator.flush();
        return jsonWriter;
    }
}