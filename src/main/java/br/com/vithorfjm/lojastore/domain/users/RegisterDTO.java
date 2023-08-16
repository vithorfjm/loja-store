package br.com.vithorfjm.lojastore.domain.users;

import br.com.vithorfjm.lojastore.domain.users.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
