package ua.epam.spring.hometask.core;

public class IdGenerator implements ua.epam.spring.hometask.dao.IdGenerator {

    private long previouslyGeneratedId = 0L;
    
    @Override
    public long generateNextId() {
        return ++previouslyGeneratedId;
    }

}
