package com.cg.equipment.equipmentTrackingRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.equipment.bean.UserBean;

@Repository
public interface UserRepo extends JpaRepository<UserBean, String>{

}
