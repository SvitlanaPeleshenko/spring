package ua.epam.spring.hometask.domain;

/**
 * @author Yuriy_Tkach
 */
public class DomainObject extends AbstractDomainObject {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DomainObject() {
    }

    public DomainObject(DomainObject domainObject) {
        this.id = domainObject.id;
    }

}
