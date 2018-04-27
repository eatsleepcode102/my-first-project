package entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A very simple JPA entity that will be used for testing
 * 
 * @author Arjan Tijms
 *
 */
@Entity
@Table(schema="TRAINING")
public class TestEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    
    @Column
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
