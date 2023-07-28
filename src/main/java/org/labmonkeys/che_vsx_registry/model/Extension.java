package org.labmonkeys.che_vsx_registry.model;

import java.time.LocalDateTime;
import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "vsx_extension_data")
public class Extension extends PanacheEntityBase {
    
    @EmbeddedId
    ExtensionId id;

    @Column()
    String extensionUuid;

    @Column()
    String publisherUuid;

    @Column()
    String displayName;

    @Column()
    String shortDescription;

    @Column()
    LocalDateTime publishedDate;

    @Column()
    LocalDateTime lastUpdated;

    @Column()
    String tags;

    @Column()
    String categories;

    @Column()
    ExtensionVersion latest;

    @OneToMany(mappedBy = "extension", cascade = CascadeType.ALL)
    List<ExtensionVersion> versions;

}
