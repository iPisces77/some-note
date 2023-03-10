package org.example.pojo;

/**
 * @author fuhaixin
 * @date 2023-01-01
 **/
public class Role {

  private Long id;
  private String roleName;
  private String roleDesc;

  public Role() {
  }

  @Override
  public String toString() {
    return "Role{" +
        "id=" + id +
        ", roleName='" + roleName + '\'' +
        ", roleDesc='" + roleDesc + '\'' +
        '}';
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public String getRoleDesc() {
    return roleDesc;
  }

  public void setRoleDesc(String roleDesc) {
    this.roleDesc = roleDesc;
  }

  public Role(Long id, String roleName, String roleDesc) {
    this.id = id;
    this.roleName = roleName;
    this.roleDesc = roleDesc;
  }
}
