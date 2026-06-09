package com.velascoespejo.pio.user;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.velascoespejo.pio.follow.Follow;
import com.velascoespejo.pio.post.Post;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String nick;
	private String email;
	private String passwordHashed;
	private String imgPerfil;
	
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

}
