package br.com.pedrosa.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.Entity;

@Entity
public class Client extends PanacheEntity {
    public String name;

    @Schema(hidden = true)
    public Long getId() {
        return id;
    }
}