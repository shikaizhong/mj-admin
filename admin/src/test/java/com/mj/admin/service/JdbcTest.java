package com.mj.admin.service;

import com.mj.admin.jdbc.DBHelp;
import com.mj.dao.vo.ComplaintVo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTest {
    public static void main(String[] args){
        ComplaintVo complaintVo = new ComplaintVo();
        String wangwangnums = "晋泰数码专营店";
//        String sqlList = "SELECT * FROM Customer cu LEFT JOIN CustomerRecords cr on cu.WangWangNum = cr.Trader WHERE cu.WangWangNum  ='"+ wangwangnums +"'";
        StringBuffer sqlList = new StringBuffer().append("SELECT * FROM Customer cu LEFT JOIN CustomerRecords cr on cu.WangWangNum = cr.Trader WHERE cu.WangWangNum  ='"+ wangwangnums +"'");
        //得到连接
        Connection connectionList = null;
//        Statement statementList = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSetList = null;
        List<ComplaintVo> complaintVos = new ArrayList<ComplaintVo>();
        List<Object> complaintVoList = new ArrayList<Object>();
        try {
            connectionList = DBHelp.connection();
            preparedStatement = connectionList.prepareStatement(sqlList.toString());
//            statementList =connectionList.createStatement();
//            resultSetList = statementList.executeQuery(sqlList);

            resultSetList = preparedStatement.executeQuery();
            preparedStatement(preparedStatement,complaintVoList);
            if (resultSetList.next()){
                complaintVo.setWangwangnum(resultSetList.getString("wangwangnum"));
//                complaintVo.setTeamid(resultSetList.getInt("technologyRecruitmentid"));
                complaintVo.setTscustomer(resultSetList.getString("tscustomer"));
                complaintVo.setPersonnelid(resultSetList.getInt("personnelid"));
                complaintVo.setShopptype(resultSetList.getString("shopptype"));
                System.out.println(complaintVo.getShopptype());
                complaintVos.add(complaintVo);
                System.out.println(complaintVos.size());
            }
            if (complaintVo.getTeamid() != -1){
                sqlList.append("AND teamid = ?");
                complaintVoList.add(complaintVo.getTeamid());
            }if (complaintVo.getPersonnelid() != -1){
                sqlList.append("AND personnelid = ?");
                complaintVoList.add(complaintVo.getPersonnelid());
            }if (complaintVo.getTscustomer() != null) {
                sqlList.append("AND tscustomer = ?");
                complaintVoList.add(complaintVo.getTscustomer());
            }
        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            DBHelp.closeAll(connectionList,preparedStatement,resultSetList);
        }
//        addStatement(complaintVo,list,sqlList);
    }
    private static void addStatement(ComplaintVo complaintVo, List<Object> list, StringBuffer sqlList){

    }
    private static void preparedStatement(PreparedStatement preparedStatement, List<Object> list){
        if (list != null){
            for (int i = 0;i<list.size();i++){
                try {
                    preparedStatement.setObject(i+1,list.get(i));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
