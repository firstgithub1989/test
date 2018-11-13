package com.cryptocompare.util;

import com.cryptocompare.quotes.Data;
import com.cryptocompare.quotes.HistoryQuotes;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.List;

public class HistoryDeserializer{//} extends StdDeserializer<HistoryQuotes> {


    public HistoryQuotes deserialize(JsonParser parser, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        HistoryQuotes historyQuotes = new HistoryQuotes();
//        ObjectCodec codec = parser.getCodec();
//        JsonNode node = codec.readTree(parser);
//
//        // try catch block
//        JsonNode colorNode = node.get("Data");
//        String color = colorNode.;
//        car.setColor(color);
//        return car;
        return historyQuotes;
    }
}
