/**
 * Copyright 2011-2012 eBusiness Information, Groupe Excilys (www.excilys.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.excilys.ebi.spring.dbunit;

import static com.excilys.ebi.spring.dbunit.utils.DbUnitUtils.getDatabaseConnection;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.springframework.context.ApplicationContext;

import com.excilys.ebi.spring.dbunit.config.ExpectedDataSetConfiguration;

public class DefaultDataReader implements DataReader {

    @Override
    public IDataSet execute(ApplicationContext applicationContext, ExpectedDataSetConfiguration expectedDataSetConfiguration, String tableName) throws Exception {
        if (expectedDataSetConfiguration != null) {
            DatabaseConnection databaseConnection = getDatabaseConnection(applicationContext, expectedDataSetConfiguration);
            return databaseConnection.createDataSet(new String[] { tableName });
        }
        return null;
    }

}
