package com.murray.service.imp;import com.github.pagehelper.PageHelper;import com.github.pagehelper.PageInfo;import com.murray.mapper.UserInfoMapper;import com.murray.model.UserInfo;import com.murray.service.UserInfoService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import java.util.List;/** * Created by chujulong on 2017/2/15. */@Servicepublic class UserInfoServiceImpl implements UserInfoService {    @Autowired    private UserInfoMapper userInfoMapper;    public UserInfo getById(int id) {        return userInfoMapper.selectById(id);    }    public int removeById(int id) {        return userInfoMapper.delete(id);    }    public int modifyUserInfo(UserInfo userInfo) {        return userInfoMapper.update(userInfo);    }    public int createUserInfo(UserInfo userInfo) {        return userInfoMapper.insert(userInfo);    }    public int createBatchUserIno(List<UserInfo> userInfos) {        return userInfoMapper.insertBatch(userInfos);    }    @Override    public PageInfo<UserInfo> queryByPage(Integer pageNo, Integer pageSize) {        //分页方法存在问题 一直读取数据库全部数据        pageNo = pageNo == null ? 1 : pageNo;        pageSize = pageSize == null ? 10 : pageSize;        PageHelper.startPage(2, 2);        List<UserInfo> userInfos = userInfoMapper.selectAll();        PageInfo<UserInfo> pageInfo = new PageInfo<>(userInfos);        return pageInfo;    }}