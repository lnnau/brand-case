package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {

    /**
     * 查询所有
     * @return
     */
    @Select("select *from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    /**
     * 新增品牌
     * @param brand
     */
    @Insert("insert into tb_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);


    /**
     * 修改数据
     * @param brand
     */
    @Update("update tb_brand set brand_name=#{brandName},company_name=#{companyName},ordered=#{ordered},description=#{description},status=#{status} where id=#{id}")
    void update(Brand brand);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @Select("select *from tb_brand where id=#{id}")
    @ResultMap("brandResultMap")
    Brand selectById(int id);
    /**
     * 删除数据
     * @param id
     */
    @Delete("delete from tb_brand where id=#{id}")
    void deleteById(int id);
    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(@Param("ids")int[] ids);

    /**
     * 分页查询
     * @param begin
     * @param size
     */
    @Select("select *from tb_brand limit #{begin},#{size}")
    @ResultMap("brandResultMap")
    List<Brand> selectByPage(@Param("begin")int begin,@Param("size")int size);

    /**
     * 查询总条数
     */
    @Select("select count(*) from tb_brand")
    int selectTotalCount();

    /**
     * 条件查询
     * @param begin
     * @param size
     */
    List<Brand>  selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand") Brand brand);

    /**
     * 根据条件查询总条数
     */
    int selectTotalCountByCondition(Brand brand);
}
