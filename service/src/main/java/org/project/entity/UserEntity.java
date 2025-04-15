package org.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(of = "login")
@ToString(exclude = {"usagesCodes", "blackList", "ordersList"})
@Table(name = "users")
public class UserEntity implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login")
    private String login;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "address")
    private String address;
    @Column(name = "password")
    private String password;
    @Column(name = "birthday")
    private LocalDate birthday;

    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<PromoCodeUsageEntity> usagesCodes = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<BlackListEntity> blackList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<OrdersEntity> ordersList = new ArrayList<>();
}
