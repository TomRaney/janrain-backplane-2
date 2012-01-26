package com.janrain.backplane2.server.dao;

import com.janrain.backplane2.server.BackplaneMessage;
import com.janrain.backplane2.server.Scope;
import com.janrain.backplane2.server.config.Backplane2Config;
import com.janrain.commons.supersimpledb.SimpleDBException;
import com.janrain.commons.supersimpledb.SuperSimpleDB;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * @author Tom Raney
 */
public class BackplaneMessageDAO extends DAO {

    BackplaneMessageDAO(SuperSimpleDB superSimpleDB, Backplane2Config bpConfig) {
        super(superSimpleDB, bpConfig);
    };

    public void persistBackplaneMessage(BackplaneMessage message) throws SimpleDBException {
        superSimpleDB.store(bpConfig.getMessagesTableName(), BackplaneMessage.class, message);
    }

    public BackplaneMessage retrieveBackplaneMessage(String messageId) throws SimpleDBException {
        return superSimpleDB.retrieve(bpConfig.getMessagesTableName(), BackplaneMessage.class, messageId);
    }

    public List<BackplaneMessage> retrieveAllMesssagesPerScope(Scope scope, String sinceMessageId) throws SimpleDBException {
        String query = scope.buildQueryFromScope();
        assert(StringUtils.isNotEmpty(query));

        if (StringUtils.isNotEmpty(sinceMessageId)) {
            query += " AND id > '" + sinceMessageId + "'";
        }

        logger.info("message query => " + query);

        return superSimpleDB.retrieveWhere(bpConfig.getMessagesTableName(), BackplaneMessage.class, query, true);
    }

    private static final Logger logger = Logger.getLogger(BackplaneMessageDAO.class);

}