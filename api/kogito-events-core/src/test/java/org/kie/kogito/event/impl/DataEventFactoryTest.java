/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.kie.kogito.event.impl;

import java.io.IOException;
import java.net.URI;

import org.junit.jupiter.api.Test;
import org.kie.kogito.event.DataEvent;
import org.kie.kogito.event.DataEventFactory;
import org.kie.kogito.jackson.utils.ObjectMapperFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cloudevents.core.builder.CloudEventBuilder;
import io.cloudevents.jackson.JsonCloudEventData;

import static org.assertj.core.api.Assertions.assertThat;

public class DataEventFactoryTest {

    @Test
    void testIsJacksonSerializable() throws JsonProcessingException, IOException {
        ObjectMapper objectMapper = ObjectMapperFactory.get();
        CloudEventBuilder builder =
                CloudEventBuilder.v1().withId("1").withType("type").withSource(URI.create("/pepe/pepa")).withData(JsonCloudEventData.wrap(objectMapper.createObjectNode().put("name", "Javierito")))
                        .withExtension("pepe", "pepa");
        DataEvent<JsonNode> dataEvent = DataEventFactory.from(builder.build(), ced -> objectMapper.readTree(ced.toBytes()));
        JsonNode deserialized = objectMapper.readTree(objectMapper.writeValueAsBytes(dataEvent.asCloudEvent(JsonCloudEventData::wrap)));
        System.out.println(deserialized);
        JsonNode data = deserialized.get("data");

        assertThat(data).isNotNull();
        assertThat(data.get("name").asText()).isEqualTo("Javierito");
        assertThat(deserialized.get("type").asText()).isEqualTo("type");
        assertThat(deserialized.get("pepe").asText()).isEqualTo("pepa");

    }
}
