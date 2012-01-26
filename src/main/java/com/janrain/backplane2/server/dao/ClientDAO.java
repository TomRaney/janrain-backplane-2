package com.janrain.backplane2.server.dao;

import com.janrain.backplane2.server.config.Backplane2Config;
import com.janrain.backplane2.server.config.Client;
import com.janrain.commons.supersimpledb.SimpleDBException;
import com.janrain.commons.supersimpledb.SuperSimpleDB;

/**
 * @author Tom Raney
 */
public class ClientDAO extends DAO {

    ClientDAO(SuperSimpleDB superSimpleDB, Backplane2Config bpConfig) {
        super(superSimpleDB, bpConfig);
    };


    public void persistClient(Client client) throws SimpleDBException {
        superSimpleDB.store(bpConfig.getClientsTableName(), Client.class, client);
    }

    public Client retrieveClient(String client) throws SimpleDBException {
        return superSimpleDB.retrieve(bpConfig.getClientsTableName(), Client.class, client);
    }


}

