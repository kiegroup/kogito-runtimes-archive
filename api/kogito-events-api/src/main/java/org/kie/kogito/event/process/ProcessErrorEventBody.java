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
package org.kie.kogito.event.process;

public class ProcessErrorEventBody {

    private String nodeDefinitionId;
    private String errorMessage;

    private ProcessErrorEventBody() {
    }

    public String getNodeDefinitionId() {
        return nodeDefinitionId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "ProcessError [nodeDefinitionId=" + nodeDefinitionId + ", errorMessage=" + errorMessage + "]";
    }

    public static Builder create() {
        return new Builder(new ProcessErrorEventBody());
    }

    public static class Builder {

        private ProcessErrorEventBody instance;

        private Builder(ProcessErrorEventBody instance) {
            this.instance = instance;
        }

        public Builder nodeDefinitionId(String nodeDefinitionId) {
            instance.nodeDefinitionId = nodeDefinitionId;
            return this;
        }

        public Builder errorMessage(String errorMessage) {
            instance.errorMessage = errorMessage;
            return this;
        }

        public ProcessErrorEventBody build() {
            return instance;
        }
    }
}
