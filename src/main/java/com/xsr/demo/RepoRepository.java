package com.xsr.demo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

/**
 * Created by 145811 on 2018/1/31.
 */
@Repository
public class RepoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * 减库20
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public String move1st(){
        int id = 1;
        Repo repo= getById(id);
        if(repo != null){
            repo.setCount(repo.getCount() - 20 );
            int resRow= updateById(repo);
        }

        id = 2;
        repo= getById(id);
        if(repo != null){
            repo.setCount(repo.getCount() + 20 );
            int resRow= updateById(repo);
            if(resRow > 0){
                return "ok";
            }
        }
        return "ko";
    }

    /**
     * 减库20
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.DEFAULT,timeout=360000,rollbackFor=Exception.class)
    public String move2nd(){
        int id = 1;
        Repo repo= getByIdWithLock(id);
        if(repo != null){
            repo.setCount(repo.getCount() - 20 );
            int resRow= updateById(repo);
        }
        id = 2;
        repo= getByIdWithLock(id);
        if(repo != null){
            repo.setCount(repo.getCount() + 20 );
            int resRow= updateById(repo);
            if(resRow > 0){
                return "ok";
            }
        }
        return "ko";
    }

    /**
     * 减库20
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED,timeout=360000,rollbackFor=Exception.class)
    public String move3rd(){
        int id = 1;
        Repo repo = getById(id);
        if(repo != null){
            repo.setCount(repo.getCount() - 20 );
            int resRow = updateByVersion(repo);
            while(resRow == 0){
                repo = getById(id);
                repo.setCount(repo.getCount() - 20 );
                resRow = updateByVersion(repo);
            }
        }
        id = 2;
        repo = getById(id);
        if(repo != null){
            repo.setCount(repo.getCount() + 20 );
            int resRow = updateByVersion(repo);
            while(resRow == 0){
                repo = getById(id);
                repo.setCount(repo.getCount() - 20 );
                resRow = updateByVersion(repo);
            }
            return "ok";
        }

        return "ko";
    }

    Repo getById(int id){
        List<Repo> repoList=jdbcTemplate.query("select id,count,version from repo where id=? ",new Object[]{id},new RepoRowMapper());
        Repo repo=null;
        if (!repoList.isEmpty()){
            repo=repoList.get(0);
        }
        return repo;
    }

    int updateById(Repo repo){
        int resRow=jdbcTemplate.update("update repo set count = ?, version = ? where id = ? ",new Object[]{
                repo.getCount(), repo.getVersion(), repo.getId()
        });
        return resRow;
    }

    private Repo getByIdWithLock(int id) {
        List<Repo> repoList=jdbcTemplate.query("select id,count,version from repo where id=? for update ",new Object[]{id},new RepoRowMapper());
        Repo repo=null;
        if (!repoList.isEmpty()){
            repo=repoList.get(0);
        }
        return repo;
    }

    int updateByVersion(Repo repo){
        int resRow=jdbcTemplate.update("update repo set count = ?, version = version + 1 where id = ? and version = ?",new Object[]{
                repo.getCount(), repo.getId(), repo.getVersion()
        });
        return resRow;
    }

}

/**
 * 行映射
 */
class RepoRowMapper implements RowMapper<Repo> {

    @Override
    public Repo mapRow(ResultSet resultSet, int i) throws SQLException {
        Repo repo=new Repo();
        repo.setId(resultSet.getInt("id"));
        repo.setCount(resultSet.getInt("count"));
        repo.setVersion(resultSet.getInt("version"));
        return repo;
    }

}
