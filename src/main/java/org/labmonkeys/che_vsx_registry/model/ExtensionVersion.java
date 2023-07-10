package org.labmonkeys.che_vsx_registry.model;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "vsx_extension_version")
public class ExtensionVersion extends PanacheEntityBase {
    
    @EmbeddedId
    ExtensionVersionId id;

    @Column()
    String uuid;

    @Column()
    String version;

    @Column()
    String lastUpdated;

    @OneToMany(mappedBy = "extensionVersion", cascade = CascadeType.ALL)
    List<ExtensionAsset> assets;

    @OneToMany(mappedBy = "extensionVersion", cascade = CascadeType.ALL)
    List<ExtensionProperty> properties;

    @ManyToOne
    Extension extension;

}
