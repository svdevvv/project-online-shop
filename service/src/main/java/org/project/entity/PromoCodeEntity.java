package org.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "code")
@ToString(exclude = "promoCodeUsages")
@Entity
@Table(name = "promo_code", schema = "public")
public class PromoCodeEntity implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;
    @Column(name = "discount")
    private Integer discount;
    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "expiration_date")
    private Instant endAt;

    @Builder.Default
    @OneToMany(mappedBy = "promoCode")
    private List<PromoCodeUsageEntity> promoCodeUsages = new ArrayList<>();
}