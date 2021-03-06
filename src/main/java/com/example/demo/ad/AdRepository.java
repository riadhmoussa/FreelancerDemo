package com.example.demo.ad;

import com.example.demo.appuser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AdRepository extends JpaRepository<Ad,Long>, JpaSpecificationExecutor {

    @Query(value="select * from Ad ad where ad.id_fid =:userId", nativeQuery=true)
    List<Ad[]> getAdByUserId(@Param("userId") String userId);

}

