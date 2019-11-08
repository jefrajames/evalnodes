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
import io.aexp.nodes.graphql.annotations.GraphQLArguments;

/**
 * This class implements a GraphQL mutation.
 * 
 * @author jefrajames
 */

/* Generated GraphQL mutation:
mutation {
  addHeroToTeam(hero: "Spider Man", team: "X-Men") {
    members {
      name
      primaryLocation
      realName
    }
  }
}
 */
public class AddHeroToTeamMutation {

    @GraphQLArguments({
        @GraphQLArgument(name = "hero"),
        @GraphQLArgument(name = "team")
    }
    )
    AddHeroToTeamDTO addHeroToTeam;

    public AddHeroToTeamDTO getAddHeroToTeam() {
        return addHeroToTeam;
    }

    public void setAddHeroToTeam(AddHeroToTeamDTO addHeroToTeam) {
        this.addHeroToTeam = addHeroToTeam;
    }

}
