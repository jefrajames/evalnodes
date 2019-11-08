/*
 * Copyright 2019 jefrajames.
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
package org.jefrajames.evalnodes;

import io.aexp.nodes.graphql.Argument;
import io.aexp.nodes.graphql.Arguments;
import io.aexp.nodes.graphql.GraphQLRequestEntity;
import io.aexp.nodes.graphql.GraphQLResponseEntity;
import io.aexp.nodes.graphql.GraphQLTemplate;
import java.net.MalformedURLException;
import org.jefrajames.evalnodes.query.HelloChangeWelcomeMessageQuery;
import org.jefrajames.evalnodes.query.HelloQuery;
import org.jefrajames.evalnodes.query.HelloWithNameQuery;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author jefrajames
 */
public class HelloTest {

    private static final String SERVER_URL = "http://localhost:8080/graphql";

    @Test
    public void testHello() throws MalformedURLException {

        GraphQLRequestEntity requestEntity = GraphQLRequestEntity.Builder()
                .url(SERVER_URL)
                .request(HelloQuery.class)
                .build();

        System.out.println("testHello => GraphQL query=" + requestEntity.getRequest());

        GraphQLTemplate graphQLTemplate = new GraphQLTemplate();

        GraphQLResponseEntity<HelloQuery> responseEntity = graphQLTemplate.query(requestEntity, HelloQuery.class);

        assertNull(responseEntity.getErrors());
        assertTrue(responseEntity.getResponse().getHello().equals("Hello"));
    }

    @Test
    public void testHelloWithName() throws MalformedURLException {

        GraphQLRequestEntity requestEntity = GraphQLRequestEntity.Builder()
                .url(SERVER_URL)
                .arguments(new Arguments("helloWithName", new Argument<String>("name", "jefrajames")))
                .request(HelloWithNameQuery.class)
                .build();

        System.out.println("testHelloWithName => GraphQL query=" + requestEntity.getRequest());

        GraphQLTemplate graphQLTemplate = new GraphQLTemplate();

        GraphQLResponseEntity<HelloWithNameQuery> responseEntity = graphQLTemplate.query(requestEntity, HelloWithNameQuery.class);

        assertNull(responseEntity.getErrors());
        assertTrue(responseEntity.getResponse().getHelloWithName().equals("Hello jefrajames"));
    }
    
    @Test
    public void testChangeWelcomeMessage() throws MalformedURLException {
        
        String newWelcomeMessageValue= "Bonjour GraphQL !";

        GraphQLRequestEntity requestEntity = GraphQLRequestEntity.Builder()
                .url(SERVER_URL)
                .arguments(new Arguments("changeWelcomeMessage", new Argument<String>("newWelcomeMessage", newWelcomeMessageValue)))
                .request(HelloChangeWelcomeMessageQuery.class)
                .requestMethod(GraphQLTemplate.GraphQLMethod.MUTATE)
                .build();

        System.out.println("testChangeWelcomeMessage => GraphQL mutation=" + requestEntity.getRequest());

        GraphQLTemplate graphQLTemplate = new GraphQLTemplate();

        GraphQLResponseEntity<HelloChangeWelcomeMessageQuery> responseEntity = graphQLTemplate.mutate(requestEntity, HelloChangeWelcomeMessageQuery.class);

        assertNull(responseEntity.getErrors());
        assertNotNull(responseEntity.getResponse().getChangeWelcomeMessage());
        assertTrue(responseEntity.getResponse().getChangeWelcomeMessage().equals(newWelcomeMessageValue));
    }

}
