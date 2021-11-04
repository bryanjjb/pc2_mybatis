
package com.example.pc2mb.repository;

import com.example.pc2mb.entity.Editorial;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface EditorialRepository {
    @Select("select * from editorial")
    public List<Editorial> findAll();
}
