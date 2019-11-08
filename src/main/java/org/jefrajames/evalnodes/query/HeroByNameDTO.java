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

import java.util.List;

/**
 * This class implements a GraphQL selection set including the realName, the
 * primaryLocation, the super powers and team affiliations for each selected
 * hero.
 *
 * @author jefrajames
 */
public class HeroByNameDTO {

    String realName;
    String primaryLocation;
    List<String> superPowers;
    List<HeroByNameTeamDTO> teamAffiliations;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPrimaryLocation() {
        return primaryLocation;
    }

    public void setPrimaryLocation(String primaryLocation) {
        this.primaryLocation = primaryLocation;
    }

    public List<String> getSuperPowers() {
        return superPowers;
    }

    public void setSuperPowers(List<String> superPowers) {
        this.superPowers = superPowers;
    }

    public List<HeroByNameTeamDTO> getTeamAffiliations() {
        return teamAffiliations;
    }

    public void setTeamAffiliations(List<HeroByNameTeamDTO> teamAffiliations) {
        this.teamAffiliations = teamAffiliations;
    }

    @Override
    public String toString() {
        return "FindHeroByName{" + "realName=" + realName + ", primaryLocation=" + primaryLocation + ", superPowers=" + superPowers + ", teamAffiliations=" + teamAffiliations + '}';
    }

}
