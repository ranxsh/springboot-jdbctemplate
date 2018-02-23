package com.xsr.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.Date;

/**
 * Created by 145811 on 2018/1/31.
 */
@Service
public class RepoService {

    @Autowired
    RepoRepository repoRepository;
    public void move1st500() {
        Date dtB = new Date();
        System.out.println("begin" + dtB.getTime());
        List<Future> futureList = new ArrayList<Future>();
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for(int i = 0; i < 500; i ++){
            Future<String> future = executorService.submit(new ThreadRepo1st(repoRepository));
            futureList.add(future);
        }
        for(Future f : futureList){
            try {
                f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        Date dtE = new Date();
        System.out.println("end" + dtE.getTime());
        System.out.println("use Time " + (dtE.getTime() - dtB.getTime()));
    }

    public void move2nd500() {
        Date dtB = new Date();
        System.out.println("begin" + dtB.getTime());
        List<Future> futureList = new ArrayList<Future>();
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for(int i = 0; i < 500; i ++){
            Future<String> future = executorService.submit(new ThreadRepo2nd(repoRepository));
            futureList.add(future);
        }
        for(Future f : futureList){
            try {
                f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        Date dtE = new Date();
        System.out.println("end" + dtE.getTime());
        System.out.println("use Time " + (dtE.getTime() - dtB.getTime()));
    }

    public void move3rd500() {
        Date dtB = new Date();
        System.out.println("begin" + dtB.getTime());
        List<Future> futureList = new ArrayList<Future>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 500; i ++){
            Future<String> future = executorService.submit(new ThreadRepo3rd(repoRepository));
            futureList.add(future);
        }
        for(Future f : futureList){
            try {
                f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        Date dtE = new Date();
        System.out.println("end" + dtE.getTime());
        System.out.println("use Time " + (dtE.getTime() - dtB.getTime()));
    }

    /**
     * 从1到2转移20件
     */
    public void moveSimple() {
        repoRepository.move1st();
    }
}

class ThreadRepo1st implements Callable<String>{
    private RepoRepository repoRepository;
    public ThreadRepo1st(RepoRepository repoRepository){
        this.repoRepository = repoRepository;
    }
//    @Override
//    public void run() {
//        repoRepository.plus1st();
//    }

    @Override
    public String call() throws Exception {
        repoRepository.move1st();
        return "ok";
    }
}

class ThreadRepo2nd implements Callable<String> {
    private RepoRepository repoRepository;
    public ThreadRepo2nd(RepoRepository repoRepository){
        this.repoRepository = repoRepository;
    }
//    @Override
//    public void run() {
//        repoRepository.plus2nd();
//        System.out.println("in plus2nd" + new Date().getTime());
//    }

    @Override
    public String call() throws Exception {
        repoRepository.move2nd();
//        System.out.println("in plus2nd" + new Date().getTime());
        return "ok";
    }
}

class ThreadRepo3rd implements Callable<String> {
    private RepoRepository repoRepository;

    public ThreadRepo3rd(RepoRepository repoRepository) {
        this.repoRepository = repoRepository;
    }
//    @Override
//    public void run() {
//        repoRepository.plus2nd();
//        System.out.println("in plus2nd" + new Date().getTime());
//    }

    @Override
    public String call() throws Exception {
        repoRepository.move3rd();
//        System.out.println("in plus2nd" + new Date().getTime());
        return "ok";
    }
}
