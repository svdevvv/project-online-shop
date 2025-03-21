package org.project.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;

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
@EqualsAndHashCode(of = "email")
@ToString(exclude = {"usagesCodes","blackList","ordersList"})
@Table(name = "users")
public class UserEntity implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String firstName;
    private String lastName;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String address;
    private String password;
    private LocalDate birthday;

    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<PromoCodeUsageEntity> usagesCodes = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<BlackListEntity> blackList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "userId")
    private List<OrdersEntity> ordersList = new ArrayList<>();
}
