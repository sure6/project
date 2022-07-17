package com.uow.test;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class zkClient {
    ZooKeeper zk = null;
    @Before
    public void init() throws IOException {
        zk = new ZooKeeper("127.0.0.1:2181",3000,null);
    }
    @Test
//创建
    public void testCreate() throws Exception{
        //参数1:节点的路径  参数2:数据  参数3:访问权限  参数4:节点类型
        String create = zk.create("/demo123","hello demo123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(create);
        zk.close();
    }
    @Test
//修改
    public void testUpdata()throws Exception{
        //参数1:节点的路径  参数2:数据  参数3:数据的版本:-1表示所有的版本
        zk.setData("/demo123","我看见你没听课".getBytes("Utf-8"),-1);
        zk.close();
    }

    @Test
    public void testDel() throws Exception{
        zk.delete("/demo123",-1);
        zk.close();
    }

}
