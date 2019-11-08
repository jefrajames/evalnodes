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
package org.jefrajames.evalnodes.query;

import io.aexp.nodes.graphql.annotations.GraphQLVariable;
import java.util.List;

/**
 * This class implements a GraphQLQuery with a variable. It is similar to
 * AllHeroesWithPowerQuery but the @GraphQLArgument annotation is replaced by a
 * @GraphQLVariable one.
 *
 * @author jefrajames
 */

/* Generated GraphQL query:
query ($power: String) {
  allHeroesWithPower(power: $power) {
    realName
    primaryLocation
    name
    superPowers
  }
}

{"power": "Humor"}
 */
public class AllHeroesWithPowerVariableQuery {

    @GraphQLVariable(name = "power", scalar = "String!")
    List<AllHeroesWithPowerDTO> allHeroesWithPower;

    public List<AllHeroesWithPowerDTO> getAllHeroesWithPower() {
        return allHeroesWithPower;
    }

    public void setAllHeroesWithPower(List<AllHeroesWithPowerDTO> allHeroesWithPower) {
        this.allHeroesWithPower = allHeroesWithPower;
    }

}
