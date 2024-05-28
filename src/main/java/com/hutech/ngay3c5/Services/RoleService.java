package com.hutech.ngay3c5.Services;

import com.hutech.ngay3c5.Entities.Role;
import com.hutech.ngay3c5.Entities.User;
import com.hutech.ngay3c5.Repositories.RoleRepository;
import com.hutech.ngay3c5.RequestEntities.RequestCreateRole;
import com.hutech.ngay3c5.RequestEntities.RequestCreateUser;
import com.hutech.ngay3c5.RequestEntities.RequestUpdateRole;
import com.hutech.ngay3c5.RequestEntities.RequestUpdateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    public RoleRepository roleRepository;
    public Role CreateRole(RequestCreateRole requestCreateRole){
        try {
            Role role = new Role();
            role.setRole_id(requestCreateRole.getRole_id());
            role.setRole_name(requestCreateRole.getRole_name());
            roleRepository.save(role);
            return role;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }
    public Role getRoleById(String id){
        return roleRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Role with id " + id + " not found")
        );
    }
    public Role updateRole(String id, RequestUpdateRole requestUpdateRole){
        try {
            Role role = new Role();
            role.setRole_id(role.getRole_id());
            role.setRole_name(role.getRole_name());
            return roleRepository.save(role);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
