/*
 * Copyright 2010 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.internal.conf;


import org.kie.api.conf.SingleValueKieBaseOption;

/**
 * An Enum for multithread evaluation option.
 *
 * IMPORTANT: this option is currently not supported. It might be enabled again in the future.
 *
 * drools.multithreadEvaluation = &lt;true|false&gt;
 *
 * DEFAULT = false
 *
 * @deprecated
 */
public enum MultithreadEvaluationOption implements SingleValueKieBaseOption {

    YES(true),
    NO(false);

    /**
     * The property name for the multithread evaluation option
     */
    public static final String PROPERTY_NAME = "drools.multithreadEvaluation";

    private boolean value;

    MultithreadEvaluationOption( final boolean value ) {
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    public String getPropertyName() {
        return PROPERTY_NAME;
    }

    public boolean isMultithreadEvaluation() {
        return this.value;
    }

}
