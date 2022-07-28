package com.uow.gmall.mapper;

import com.uow.gmall.bean.Cervaluation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CervaluationMapper {
    @Select(value = {"select * from Cevaluation"})
    List<Cervaluation> obtainEvaluation();
}
