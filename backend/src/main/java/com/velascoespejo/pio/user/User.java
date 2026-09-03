package com.velascoespejo.pio.user;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.velascoespejo.pio.follow.Follow;
import com.velascoespejo.pio.post.Post;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User implements UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String nick;
	private String email;
	private String passwordHashed;
	private String imgPerfil;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@UpdateTimestamp
	private LocalDateTime updateAt;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createAt;
	
	@OneToMany(mappedBy = "user")
	private List<Post> post;	
	
	@OneToMany(mappedBy = "seguidor", fetch = FetchType.LAZY)
	private Set<Follow> siguiendo = new HashSet<>();

	@OneToMany(mappedBy = "seguido", fetch = FetchType.LAZY)
	private Set<Follow> seguidores = new HashSet<>();


	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	@Override
	public @Nullable String getPassword() {
		return passwordHashed;
	}

	@Override
	public String getUsername() {
		return nick;
	}

}
