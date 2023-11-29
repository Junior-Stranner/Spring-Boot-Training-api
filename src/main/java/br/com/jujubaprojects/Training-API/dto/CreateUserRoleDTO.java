package br.com.jujubaprojects.Authenticacao.dto;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class CreateUserRoleDTO {

  private Long idUser;

  private List<UUID> idsRoles;

}
