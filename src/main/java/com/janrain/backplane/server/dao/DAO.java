/*
 * Copyright 2012 Janrain, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.janrain.backplane.server.dao;

import com.janrain.backplane.server.config.Backplane1Config;
import com.janrain.backplane2.server.config.Backplane2Config;
import com.janrain.commons.supersimpledb.SimpleDBException;
import com.janrain.commons.supersimpledb.SuperSimpleDB;
import com.janrain.commons.supersimpledb.message.NamedMap;

/**
 * @author Tom Raney
 */

public abstract class DAO<T extends NamedMap> {

    protected SuperSimpleDB superSimpleDB;
    protected Backplane1Config bpConfig;

    DAO(SuperSimpleDB superSimpleDB, Backplane1Config bpConfig) {
        this.superSimpleDB = superSimpleDB;
        this.bpConfig = bpConfig;
    }

    abstract public void persist(T obj) throws SimpleDBException;
    abstract public void delete(String id) throws SimpleDBException;

}