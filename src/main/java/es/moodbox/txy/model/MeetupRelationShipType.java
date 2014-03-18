package es.moodbox.txy.model;

import org.neo4j.graphdb.RelationshipType;

/**
 * Created by victor on 18/03/14.
 */
public class MeetupRelationShipType implements RelationshipType {

    private String rel;

    public MeetupRelationShipType(String rType){
        rel = rType;
    }

    @Override
    public String name() {
        return rel;
    }
}
