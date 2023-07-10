package org.labmonkeys.che_vsx_registry.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "vsx_extension_properties")
public class ExtensionProperty extends PanacheEntityBase {

    @Id
    @GeneratedValue
    Long id;

    @Column()
    String propertyId;

    @Column()
    String propertyValue;

    @ManyToOne
    ExtensionVersion extensionVersion;
}
