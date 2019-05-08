package ua.epam.spring.hometask.dao.impl;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;
import ua.epam.spring.hometask.dao.AuditoriumDao;
import ua.epam.spring.hometask.domain.Auditorium;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Repository("auditoriumDao")
public class AuditoriumDaoInMemory implements AuditoriumDao {

    private Set<Auditorium> auditoriums = new HashSet<>();

    public AuditoriumDaoInMemory(Set<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }


    @Override
    public Set<Auditorium> getAll() {
        return auditoriums.stream().map(Auditorium::new)
                .collect(Collectors.toSet());
    }

    @Override
    public Auditorium findByName(String name) {
        return auditoriums.stream()
                .filter(a -> Objects.equals(name, a.getName())).findFirst()
                .map(Auditorium::new).orElse(null);
    }

    @Override
    public Auditorium getByCode(String code) {
        return auditoriums.stream()
                .filter(a -> Objects.equals(code, a.getCode())).findFirst()
                .map(Auditorium::new).orElse(null);
    }

    public void setAuditoriums(Set<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }

    private void checkAuditoriumsProvided() {
        if (CollectionUtils.isEmpty(auditoriums)) {
            throw new IllegalStateException(
                    "you should have provided auditoriums");
        }
    }

}
