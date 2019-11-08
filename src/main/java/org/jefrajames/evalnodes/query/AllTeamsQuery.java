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
 * This class implements a GraphQL query.
 * 
 * @author jefrajames
 */

/* Generated GraphQL query:
query {
  allTeams {
    name
  }
}
*/
public class AllTeamsQuery {
    
    List<AllTeamsDTO> allTeams;

    public List<AllTeamsDTO> getAllTeams() {
        return allTeams;
    }

    public void setAllTeams(List<AllTeamsDTO> allTeams) {
        this.allTeams = allTeams;
    }
    
    
    

}
