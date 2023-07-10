package org.labmonkeys.che_vsx_registry.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "vsx_extension_assets")
public class ExtensionAsset extends PanacheEntityBase {
    
    @Id
    @GeneratedValue
    Long id;

    @Column()
    String assetType;

    @Basic(fetch = FetchType.LAZY)
    byte[] extensionAsset;

    @ManyToOne
    ExtensionVersion extensionVersion;
}
