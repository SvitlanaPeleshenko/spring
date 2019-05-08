package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.dao.EventDao;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.service.EventService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Objects;

public class EventServiceImpl implements EventService {
    private EventDao eventDao;

    @Override
    public Event save(Event event) {
        Objects.requireNonNull(event);
        return eventDao.save(event);
    }

    @Override
    public void remove(Event event) {
        Objects.requireNonNull(event);
        eventDao.remove(event);
    }

    @Override
    public Event getById(@Nonnull Long id) {
        return eventDao.getById(id);
    }

    @Override
    public Collection<Event> getAll() {
        return eventDao.getAll();
    }

    @Override
    public Event getByName(String name) {
        Objects.requireNonNull(name);
        return eventDao.getByName(name);
    }

    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }
}
