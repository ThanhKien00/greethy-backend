package com.greethy.core.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.greethy.core.utils.SerializerUtils;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class SerializerUtilsTests {

    private TestData testData;

    @BeforeEach
    public void setUp() {
        testData = new TestData(1, 2L, LocalDateTime.now(), "abc");
    }

    @Test
    public void testSerializeToJsonBytes() throws JsonProcessingException {
        byte[] result = SerializerUtils.serializeToJsonBytes(testData);
        Assertions.assertNotNull(result);
        List.of(result).forEach(System.out::print);
    }

    @Test
    public void testDeserializeToJsonBytes() throws JsonProcessingException {
        String json = "{\"field1\":1,\"field2\":2,\"field3\":[2024,10,26,15,6,8,607559100],\"field4\":\"abc\"}";
        var testData = SerializerUtils.deserializeFromJson(json, TestData.class);
        Assertions.assertNotNull(testData);
        System.out.println(testData);
    }

    @Test
    public void testDeserializeFromJsonBytes() throws IOException {
        var bytes = SerializerUtils.serializeToJsonBytes(testData);
        var convert = SerializerUtils.deserializeFromJsonBytes(bytes, TestData.class);
        Assertions.assertEquals(testData, convert);
        System.out.println(convert);
    }

    @Test
    public void testSerializeToJsonString() throws JsonProcessingException {
        var result = SerializerUtils.serializeToJson(testData);
        Assertions.assertTrue(StringUtils.hasText(result));
        System.out.println(result);
    }

    @ToString
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class TestData {
        private Integer field1;
        private Long field2;
        private LocalDateTime field3;
        private String field4;
    }

}
