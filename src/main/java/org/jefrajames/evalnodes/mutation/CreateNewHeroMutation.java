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
package org.jefrajames.evalnodes.mutation;

import io.aexp.nodes.graphql.annotations.GraphQLArgument;

/**
 *
 * @author jefrajames
 */

/* The generated GraphQL mutation is:
mutation {
  createNewHero(hero: {name: "Bruce Lee",
    realName: "Lee Jun-Fan",
    primaryLocation: "San Francisco",
    superPowers: ["Jet Kune Do", "Fitness"],
    teamAffiliations: [{name: "Martial artist", members: null}]}) {
    realName
  }
}

*/
public class CreateNewHeroMutation {
    
    @GraphQLArgument(name="hero")
    CreateNewHeroDTO createNewHero;

    public CreateNewHeroDTO getCreateNewHero() {
        return createNewHero;
    }

    public void setCreateNewHero(CreateNewHeroDTO createNewHero) {
        this.createNewHero = createNewHero;
    }
    
}
