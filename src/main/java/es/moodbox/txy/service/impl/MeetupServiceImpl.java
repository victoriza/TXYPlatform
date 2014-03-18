    package es.moodbox.txy.service.impl;

import es.moodbox.txy.model.Meetup;
import es.moodbox.txy.model.MeetupRelationShipType;
import es.moodbox.txy.service.MeetupService;
import org.neo4j.graphdb.*;
import org.neo4j.rest.graphdb.RestGraphDatabase;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by victor on 18/03/14.
 */
@Service
public class MeetupServiceImpl implements MeetupService {

    private final static String DATABASE_URL = "http://txy.sb01.stations.graphenedb.com:24789/db/data/";

    private final static String USER = "txy";
    private final static String USER_PASSWORD = "6iFuReqFJOEJc9t5kiln";

    private final static Logger log = Logger.getLogger(MeetupService.class.getName());

    @Override
    public long create(final Meetup meetup) {
        log.log(Level.INFO, " @@ Starting Java Rest Client to: " + DATABASE_URL + " , user: " + USER);
        GraphDatabaseService graphDb = new RestGraphDatabase(DATABASE_URL, USER, USER_PASSWORD);

        //TODO: Decide how to do it
        if (meetup.getDate() == null) {
            meetup.setDate(new Date());
        }

        Transaction tx = graphDb.beginTx();

        Node userANode = graphDb.createNode();
        userANode.setProperty("name", meetup.getUserA());

        Node userBNode = graphDb.createNode();
        userBNode.setProperty("name", meetup.getUserB());

        Relationship rel = userANode.createRelationshipTo(
                userBNode, new MeetupRelationShipType(meetup.getRelationshipType()));

        rel.setProperty("duration", meetup.getElapsedTime());
        rel.setProperty("date", meetup.getDate().getTime());
        rel.setProperty("feeling", meetup.getFeeling());

        if (meetup.getLocation() != null) {
            rel.setProperty("lat", meetup.getLocation().getLat());
            rel.setProperty("lon", meetup.getLocation().getLon());
        }

        tx.success();
        tx.finish();
        return userANode.getId();
    }
}
