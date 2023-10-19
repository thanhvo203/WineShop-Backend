package com.example.wines_shop.repository;

import com.example.wines_shop.model.wines.Wines;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IWinesRepository extends JpaRepository<Wines, Long> {

    @Query(nativeQuery = true, value = "select * from wines\n" +
            "join wines_shop.type_wines tw on tw.id_type_wines = wines.id_type_wines\n" +
            "where flag_wines = 0 limit 8 ")
    List<Wines> findAllByFlagWinesIsFalse();

    @Query(nativeQuery = true,value = "select * from wines\n" +
            "join wines_shop.type_wines tw on tw.id_type_wines = wines.id_type_wines\n" +
            "            where flag_wines = 0\n" +
            "order by wines.price_wines desc\n" +
            "limit 1 ")
    Wines getLargestPrice();

    @Query(nativeQuery = true, value = "select * from wines\n" +
            "join wines_shop.type_wines tw on tw.id_type_wines = wines.id_type_wines\n" +
            "where flag_wines = 0 and  wines.id_wines = :id ")
    Wines getWinesById (@Param("id") Long id);

    @Query(nativeQuery = true, value = "SELECT *\n" +
            "                        FROM wines\n" +
            "                                 left join wines_shop.type_wines tw on tw.id_type_wines = wines.id_type_wines\n" +
            "                        WHERE wines.alcohol >= :firstAlcohol AND wines.alcohol <= :lastAlcohol\n" +
            "                          AND color_wines like concat ('%',:color,'%')\n" +
            "                        AND flavor_wines like concat ('%',:flavor,'%')\n" +
            "                        AND country_manufacture like concat('%',:country,'%')\n" +
            "                        AND tw.name_type_wines like concat('%',:nameType,'%')\n" +
            "                        AND name_wines like concat('%',:nameWines,'%')\n" +
            "                        AND wines.flag_wines = 0\n" +
            "                          AND wines.price_wines >= :minPrice AND wines.price_wines <= :maxPrice ")
    Page<Wines> getListWines (Pageable pageable,@Param("firstAlcohol") int firstAlcohol,
                              @Param("lastAlcohol") int lastAlcohol,
                              @Param("color") String color,
                              @Param("flavor") String flavor,
                              @Param("country") String country,
                              @Param("nameType") String nameType,@Param("nameWines") String nameWines,
                              @Param("minPrice") int minPrice,@Param("maxPrice") int maxPrice);



}
