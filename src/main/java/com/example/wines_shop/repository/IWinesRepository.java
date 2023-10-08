package com.example.wines_shop.repository;

import com.example.wines_shop.model.wines.Wines;
import jogamp.graph.font.typecast.ot.table.LigatureSet;
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

    @Query(nativeQuery = true, value = "select * from wines\n" +
            "join wines_shop.type_wines tw on tw.id_type_wines = wines.id_type_wines\n" +
            "where flag_wines = 0 and  wines.id_wines = :id ")
    Wines getWinesById (@Param("id") Long id);

    @Query(nativeQuery = true, value = "select * from wines\n" +
            "join wines_shop.type_wines tw on tw.id_type_wines = wines.id_type_wines\n" +
            "where flag_wines = 0")
    Page<Wines> getListWines (Pageable pageable);



}
