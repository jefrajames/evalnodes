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
import io.aexp.nodes.graphql.InputObject;
import io.aexp.nodes.graphql.Variable;
import java.net.MalformedURLException;
import java.util.List;
import org.jefrajames.evalnodes.mutation.AddHeroToTeamDTO;
import org.jefrajames.evalnodes.mutation.AddHeroToTeamMutation;
import org.jefrajames.evalnodes.mutation.CreateNewHeroDTO;
import org.jefrajames.evalnodes.mutation.CreateNewHeroMutation;
import org.jefrajames.evalnodes.mutation.CreateNewHeroTeamAffiliationArgument;
import org.jefrajames.evalnodes.query.AllHeroesInTeamQuery;
import org.jefrajames.evalnodes.query.AllHeroesQuery;
import org.jefrajames.evalnodes.query.HeroByNameDTO;
import org.jefrajames.evalnodes.query.HeroByNameQuery;
import org.jefrajames.evalnodes.query.AllHeroesDTO;
import org.jefrajames.evalnodes.query.AllHeroesInTeamDTO;
import org.jefrajames.evalnodes.query.AllTeamsDTO;
import org.jefrajames.evalnodes.query.AllTeamsQuery;
import org.jefrajames.evalnodes.query.AllHeroesWithPowerDTO;
import org.jefrajames.evalnodes.query.AllHeroesWithPowerQuery;
import org.jefrajames.evalnodes.query.AllHeroesWithPowerVariableQuery;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author jefrajames
 */
public class SuperHeroTest {

    private static final String SERVER_URL = "http://localhost:8080/graphql";

    @Test
    public void testAllHeroes() throws MalformedURLException {

        GraphQLRequestEntity requestEntity = GraphQLRequestEntity.Builder()
                .url(SERVER_URL)
                .request(AllHeroesQuery.class)
                .build();

        System.out.println("testAllHeroes => GraphQL query=" + requestEntity);

        GraphQLTemplate graphQLTemplate = new GraphQLTemplate();

        GraphQLResponseEntity<AllHeroesQuery> responseEntity = graphQLTemplate.query(requestEntity, AllHeroesQuery.class);

        List<AllHeroesDTO> allHeroes = responseEntity.getResponse().getAllHeroes();

        assertNull(responseEntity.getErrors());
        assertNotNull(allHeroes);
        allHeroes.stream().forEach(System.out::println);
        assertTrue(allHeroes.size() >= 4);
    }

    @Test
    public void testHeroesInTeam() throws MalformedURLException {

        GraphQLRequestEntity requestEntity = GraphQLRequestEntity.Builder()
                .url(SERVER_URL)
                .arguments(new Arguments("allHeroesInTeam", new Argument<>("team", "Avengers")))
                .request(AllHeroesInTeamQuery.class)
                .build();

        System.out.println("testHeroesInTeam => GraphQL query=" + requestEntity);

        GraphQLTemplate graphQLTemplate = new GraphQLTemplate();

        GraphQLResponseEntity<AllHeroesInTeamQuery> responseEntity = graphQLTemplate.query(requestEntity, AllHeroesInTeamQuery.class);

        List<AllHeroesInTeamDTO> allAvengers = responseEntity.getResponse().getAllHeroesinTeam();

        assertNull(responseEntity.getErrors());
        assertNotNull(allAvengers);
        allAvengers.stream().forEach(System.out::println);
        assertTrue(allAvengers.size() >= 3);

    }

    @Test
    public void testHeroByName() throws MalformedURLException {

        GraphQLRequestEntity requestEntity = GraphQLRequestEntity.Builder()
                .url(SERVER_URL)
                .arguments(new Arguments("findHeroByName", new Argument<>("name", "Spider Man")))
                .request(HeroByNameQuery.class)
                .build();

        System.out.println("testHeroByName => GraphQL query=" + requestEntity);

        GraphQLTemplate graphQLTemplate = new GraphQLTemplate();

        GraphQLResponseEntity<HeroByNameQuery> responseEntity = graphQLTemplate.query(requestEntity, HeroByNameQuery.class);

        HeroByNameDTO hero = responseEntity.getResponse().getFindHeroByName();

        assertNull(responseEntity.getErrors());
        assertNotNull(hero);
        assertTrue(hero.getRealName().equals("Peter Parker"));
    }

    @Test
    public void testAllTeams() throws MalformedURLException {

        GraphQLRequestEntity requestEntity = GraphQLRequestEntity.Builder()
                .url(SERVER_URL)
                .request(AllTeamsQuery.class)
                .build();

        System.out.println("testAllTeams => GraphQL query=" + requestEntity);

        GraphQLTemplate graphQLTemplate = new GraphQLTemplate();

        GraphQLResponseEntity<AllTeamsQuery> responseEntity = graphQLTemplate.query(requestEntity, AllTeamsQuery.class);
        List<AllTeamsDTO> teams = responseEntity.getResponse().getAllTeams();

        assertNull(responseEntity.getErrors());
        assertNotNull(teams);
        teams.stream().forEach(System.out::println);
        assertTrue(teams.size() >= 3);
    }

    @Test
    public void testHeroesWithPower() throws MalformedURLException {

        GraphQLRequestEntity requestEntity = GraphQLRequestEntity.Builder()
                .url(SERVER_URL)
                .arguments(new Arguments("allHeroesWithPower", new Argument("power", "Humor")))
                .request(AllHeroesWithPowerQuery.class)
                .build();

        System.out.println("testHeroesWithPower => GraphQL query=" + requestEntity);

        GraphQLTemplate graphQLTemplate = new GraphQLTemplate();

        GraphQLResponseEntity<AllHeroesWithPowerQuery> responseEntity = graphQLTemplate.query(requestEntity, AllHeroesWithPowerQuery.class);
        List<AllHeroesWithPowerDTO> heroes = responseEntity.getResponse().getAllHeroesWithPower();

        assertNull(responseEntity.getErrors());
        assertNotNull(heroes);
        heroes.stream().forEach(System.out::println);
        assertTrue(heroes.size() == 1);
    }

    @Test
    public void testHeroesWithPowerVariable() throws MalformedURLException {

        GraphQLRequestEntity requestEntity = GraphQLRequestEntity.Builder()
                .url(SERVER_URL)
                .variables(new Variable("power", "Humor"))
                .request(AllHeroesWithPowerVariableQuery.class)
                .build();

        System.out.println("testHeroesWithPowerVariable => GraphQL query=" + requestEntity);

        assertTrue(requestEntity.getVariables().size() == 1);

        GraphQLTemplate graphQLTemplate = new GraphQLTemplate();

        GraphQLResponseEntity<AllHeroesWithPowerVariableQuery> responseEntity = graphQLTemplate.query(requestEntity, AllHeroesWithPowerVariableQuery.class);
        List<AllHeroesWithPowerDTO> heroes = responseEntity.getResponse().getAllHeroesWithPower();

        assertNull(responseEntity.getErrors());
        assertNotNull(heroes);
        heroes.stream().forEach(System.out::println);
        assertTrue(heroes.size() == 1);
    }

    @Test
    public void testAddHeroToTeam() throws MalformedURLException {

        GraphQLRequestEntity requestEntity = GraphQLRequestEntity.Builder()
                .url(SERVER_URL)
                .arguments(new Arguments("addHeroToTeam", new Argument<>("hero", "Spider Man"), new Argument<>("team", "X-Men")))
                .request(AddHeroToTeamMutation.class)
                .requestMethod(GraphQLTemplate.GraphQLMethod.MUTATE)
                .build();

        System.out.println("testAddHeroToTeam => GraphQL mutation=" + requestEntity.getRequest());

        GraphQLTemplate graphQLTemplate = new GraphQLTemplate();

        GraphQLResponseEntity<AddHeroToTeamMutation> responseEntity = graphQLTemplate.mutate(requestEntity, AddHeroToTeamMutation.class);

        AddHeroToTeamDTO addHeroToTeamDTO = responseEntity.getResponse().getAddHeroToTeam();

        assertNull(responseEntity.getErrors());
        assertNotNull(addHeroToTeamDTO);
        addHeroToTeamDTO.getMembers().stream().forEach(System.out::println);
        assertTrue(addHeroToTeamDTO.getMembers().size() >= 1);
    }

    @Test
    public void testCreateNewHero() throws MalformedURLException {

        InputObject newHero = new InputObject.Builder<>()
                .put("name", "Bruce Lee")
                .put("realName", "Lee Jun Fan")
                .put("primaryLocation", "San Francisco")
                .put("superPowers", List.of("Jet Kune Do", "Fitness"))
                .put("teamAffiliations", List.of(new CreateNewHeroTeamAffiliationArgument("Martial Artists")))
                .build();

        GraphQLRequestEntity requestEntity = GraphQLRequestEntity.Builder()
                .url(SERVER_URL)
                .arguments(new Arguments("createNewHero", new Argument("hero", newHero)))
                .request(CreateNewHeroMutation.class)
                .requestMethod(GraphQLTemplate.GraphQLMethod.MUTATE)
                .build();

        System.out.println("testCreateNewHero => GraphQL mutation=" + requestEntity.getRequest());
        GraphQLTemplate graphQLTemplate = new GraphQLTemplate();

        GraphQLResponseEntity<CreateNewHeroMutation> responseEntity = graphQLTemplate.mutate(requestEntity, CreateNewHeroMutation.class);

        CreateNewHeroDTO createNewHeroDTO = responseEntity.getResponse().getCreateNewHero();

        assertNull(responseEntity.getErrors());
        assertNotNull(createNewHeroDTO);
        assertTrue(createNewHeroDTO.getRealName().equals("Lee Jun Fan"));
    }

}