/*
 *  Copyright 2020 Red Hat, Inc. and/or its affiliates.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.kie.kogito.addon.cloudevents.quarkus;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import io.quarkus.runtime.Startup;
import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.reactivestreams.Publisher;

/**
 * Takes a @Channel event stream and re-exposes it as a Multi
 * (a subclass of {@link Publisher})
 */
@Startup
public class QuarkusCloudEventPublisher {
    @Channel("kogito_incoming_stream")
    Multi<String> events;

    @Produces
    @Named("kogito_event_publisher")
    public Multi<String> makeMulti() {
        return events;
    }

}