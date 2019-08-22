package com.mj.dao.repository;

import com.mj.dao.annotate.DataSource;
import com.mj.dao.entity.Personnel;

import java.util.List;
public interface PersonnelsMapper {
    List<Personnel> selectAlls();
}
